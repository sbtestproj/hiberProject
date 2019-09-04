import JavaBeans.JavaBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import Entities.tbl_config_item_sections;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@WebServlet("/config_items_sections")
public class ConfigItemSections  extends HttpServlet {

    @EJB
    JavaBean javaBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // *********** parameters and values *******************
        String parName = ""; String parValue = "";

        for ( Map.Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
            parName = entry.getKey();
            parValue = entry.getValue()[0];
        }
        //******************************************************
        List ListArr = javaBean.getConfigItemSections(parName, parValue);

        final String json = new ObjectMapper().writeValueAsString(ListArr);

        resp.addHeader( "Access-Control-Allow-Origin", "*");


        resp.getWriter().write(  json );


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log("configitem Post");
        Enumeration headerNames = req.getHeaderNames();
        log("**********************************\n");
        log( "method " + req.getMethod());
        log("protocl : " + req.getProtocol());
        log("url : " + req.getRequestURI());
        log("*** Headers: ***");
        while(headerNames.hasMoreElements()) {
            String headerName = (String)headerNames.nextElement();
            //   mylog("header name :" + headerName);
            log(headerName + " : " + req.getHeader(headerName));
        }

        //***************************************  printing headers  ***************************************************
        //****************************************                  ****************************************************
        //**************************************************************************************************************
        log("***********************************");
        log ("Post req");
        resp.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        resp.addHeader("Access-Control-Allow-Methods","GET,POST,PATCH,DELETE,PUT,OPTIONS");
        resp.addHeader("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token, content-type");
        resp.addHeader("Content-Type",   "application/json");  //"text/plain");

        resp.setStatus(200);


        log(" \n response\n");
        log("content-type: " + resp.getHeader("content-type") );

        log("\ncontent: \n");

        // *****************************************   Actions  ********************************************************
        // *******************************************       ***********************************************************
        // *************************************************************************************************************

        String jsonString = new String();
        try {
            String line = "";
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null) {
                jsonString += line;
                log(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Gson g = new Gson();
        tbl_config_item_sections configitemssections = g.fromJson(jsonString, tbl_config_item_sections.class);

        log("\n\nModule name: " + configitemssections.getConfig_item_section_name());
        tbl_config_item_sections NewConfigItemsSection = new tbl_config_item_sections();

        NewConfigItemsSection.setConfig_item_section_name(configitemssections.getConfig_item_section_name());
        NewConfigItemsSection.setConfig_item_section_description(configitemssections.getConfig_item_section_description());

        List out = javaBean.saveConfigItemSections( NewConfigItemsSection );
        Gson gsonBuilder = new GsonBuilder().create();
        jsonString = gsonBuilder.toJson(out); //translate to json
        resp.getWriter().write( jsonString );



    }



}
