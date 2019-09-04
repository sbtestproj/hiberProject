import Entities.tbl_config_items;
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



@WebServlet("/test")
public class App extends HttpServlet{

    @EJB
    JavaBean javaBean;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        mylog("get query");

        String nameparam = req.getParameter("name");
        mylog("value name" + nameparam);
        tbl_config_items CItems = new tbl_config_items();

 //      List  ListItems = javaBean.getItems(nameparam);
        List ListItems = new ArrayList();

         ListItems = javaBean.getEntities(nameparam); // List<Entities.tbl_entities>

        Gson gsonBuilder = new GsonBuilder().create();

        String jsonNew  =  gsonBuilder.toJson(ListItems);


        final String json = new ObjectMapper().writeValueAsString(ListItems);

        resp.addHeader( "Access-Control-Allow-Origin", "*");

        resp.getWriter().write(  jsonNew );

    }
    //*****************************************************************************

    //********************************************************************************
    //********************************************************************************
    //***********************************  POST  *************************************
    //************************************      **************************************
    //********************************************************************************

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


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

        Gson g = new Gson();
        test t = g.fromJson(jsonString, test.class);

        mylog("name: " + t.name );



        mylog("****************");

        List Arr = new ArrayList();
       // javaBean.setConfigItem(Arr);

        mylog("Value : " + jsonString);
        boolean sign = true;

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
         mylog("***********************************");
      mylog ("Post req");


        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods","GET,POST,PATCH,DELETE,PUT,OPTIONS");
        resp.addHeader("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token, content-type");


        resp.getWriter().write( jsonString );
    }
   //*********************************************************************************






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
