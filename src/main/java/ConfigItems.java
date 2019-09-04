import Entities.tbl_config_items;
import JavaBeans.JavaBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ejb.EJB;
import javax.enterprise.inject.New;
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

@WebServlet("/config_items")
public class ConfigItems extends HttpServlet{

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
        List ListArr = javaBean.getConfigItems(parName, parValue);

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
        tbl_config_items configitems = g.fromJson(jsonString, tbl_config_items.class);

        log("\n\nModule name: " + configitems.getConfig_item_name());
          tbl_config_items NewConfigItems = new tbl_config_items();

          NewConfigItems.setConfig_item_name(configitems.getConfig_item_name());
          NewConfigItems.setConfig_item_types_id(configitems.getConfig_item_types_id());
          NewConfigItems.setConfig_sources_id(configitems.getConfig_sources_id());
          NewConfigItems.setDefault_value(configitems.getDefault_value());
          NewConfigItems.setMax_value(configitems.getMax_value());
          NewConfigItems.setMin_value(configitems.getMin_value());
          NewConfigItems.setModule_versions_id(configitems.getModule_versions_id());
          NewConfigItems.setDynamic_flag(configitems.isDynamic_flag());
          NewConfigItems.setRead_only_flag(configitems.isRead_only_flag());
          NewConfigItems.setColumn_ordinal_position(configitems.getColumn_ordinal_position());
          NewConfigItems.setIgnore_flag(configitems.isIgnore_flag());
          NewConfigItems.setReference_description(configitems.getReference_description());
          NewConfigItems.setIs_foreign_key(configitems.isIs_foreign_key());
          NewConfigItems.setIs_nullable(configitems.isIs_nullable());
          NewConfigItems.setIs_primary_key(configitems.isIs_primary_key());
          NewConfigItems.setConfig_item_description(configitems.getConfig_item_description());
          NewConfigItems.setData_types_id(configitems.getData_types_id());
          NewConfigItems.setConfig_item_sections_id(configitems.getConfig_item_sections_id());

        List out = javaBean.saveConfigItem( NewConfigItems );
        Gson gsonBuilder = new GsonBuilder().create();
        jsonString = gsonBuilder.toJson(out); //translate to json
        resp.getWriter().write( jsonString );

    }

}
