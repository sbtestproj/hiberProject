import Entities.tbl_modules;
import JavaBeans.JavaBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


@WebServlet("/modules")
public class Modules extends HttpServlet {

    @EJB
    JavaBean javaBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // *********** parameters and values *******************
          String parName = ""; String parValue = "";

        for ( Map.Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
            parName = entry.getKey();  mylog("name:" +  parName);
            parValue = entry.getValue()[0]; mylog ("val : "+parValue);
        }
        //******************************************************
        List ListArr = javaBean.getModules(parName, parValue);

        final String json = new ObjectMapper().writeValueAsString(ListArr);

        resp.addHeader( "Access-Control-Allow-Origin", "*");


        resp.getWriter().write(  json );
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        mylog("modules Post");
        Enumeration headerNames = req.getHeaderNames();
        mylog("**********************************\n");
        mylog( "method " + req.getMethod());
        mylog("protocl : " + req.getProtocol());
        mylog("url : " + req.getRequestURI());
        mylog("*** Headers: ***");
        while(headerNames.hasMoreElements()) {
            String headerName = (String)headerNames.nextElement();
            //   mylog("header name :" + headerName);
            mylog(headerName + " : " + req.getHeader(headerName));
        }

        //***************************************  printing headers  ***************************************************
        //****************************************                  ****************************************************
        //**************************************************************************************************************
        mylog("***********************************");
        mylog ("Post req");





        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods","GET,POST,PATCH,DELETE,PUT,OPTIONS");
        resp.addHeader("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token, content-type");
        resp.addHeader("Content-Type",   "application/json");  //"text/plain");

        resp.setStatus(200);


        mylog(" \n response\n");
        mylog("content-type: " + resp.getHeader("content-type") );

        mylog("\ncontent: \n");

        // *****************************************   Actions  ********************************************************
        // *******************************************       ***********************************************************
        // *************************************************************************************************************

        String jsonString = new String();
        try {
            String line = "";
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null) {
                jsonString += line;
                mylog(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



//        PrintWriter out = resp.getWriter();
//        out.print("servlet");
        Gson g = new Gson();

        tbl_modules Module = g.fromJson(jsonString, tbl_modules.class);

        mylog("\n\nModule name: " + Module.getModule_name());
        tbl_modules NewModule = new tbl_modules();
        NewModule.setModule_name(Module.getModule_name());
        NewModule.setModule_description(Module.getModule_description());
        NewModule.setResponsible_person(Module.getResponsible_person());

          List out = javaBean.saveModule( NewModule );
        Gson gsonBuilder = new GsonBuilder().create();
          jsonString = gsonBuilder.toJson(out); //translate to json
        resp.getWriter().write( jsonString );

    }



    private boolean sing_new = false;
    private void mylog(String my_message){
        String filename = "C:/java_projects/javalog.txt";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            if(!sing_new)
            {
                sing_new = true;
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filename, false), "UTF-8"));
                pw.println( "1. " + cal.getTime() +" : "+ my_message);
                pw.close();
                return;
            }
            else {

                PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filename, true), "UTF-8"));
                pw.println(" " + cal.getTime()+ " : " + my_message);
                pw.close();
            }
        }catch (Exception ex) {;}
    }


}
