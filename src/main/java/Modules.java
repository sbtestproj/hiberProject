import com.fasterxml.jackson.databind.ObjectMapper;

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
