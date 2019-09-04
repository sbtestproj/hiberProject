import Entities.tbl_module_version;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/module_versions")
public class ModulesVersions extends HttpServlet {

    @EJB
    JavaBean javaBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // *********** parameters and values *******************
        String parName = "";
        String parValue = "";

        for (Map.Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
            parName = entry.getKey(); // mylog("name:" +  parName);
            parValue = entry.getValue()[0]; // mylog ("val : "+parValue);
        }
        //******************************************************
        List ListArr = javaBean.getModulesVersions(parName, parValue);

        final String json = new ObjectMapper().writeValueAsString(ListArr);

        resp.addHeader("Access-Control-Allow-Origin", "*");

        resp.getWriter().write(  json );

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        resp.addHeader("Access-Control-Allow-Methods","GET,POST,PATCH,DELETE,PUT,OPTIONS");
        resp.addHeader("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token, content-type");
        resp.addHeader("Content-Type",   "application/json");  //"text/plain");

        resp.setStatus(200);


        log(" \n response\n");
        log("content-type: " + resp.getHeader("content-type") );

        log("\ncontent: \n");

// *********************************** Actions **********************************************************************

        // reading data to string
 mylog log = new mylog();
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


        tbl_module_version ModuleVersion = g.fromJson(jsonString, tbl_module_version.class);

        log("\n\nModuleVersions number: " + ModuleVersion.getVersion_number());
        tbl_module_version NewModuleVersions = new tbl_module_version();
        NewModuleVersions.setVersion_number(ModuleVersion.getVersion_number());
        NewModuleVersions.setModules_id(ModuleVersion.getModules_id());
       // NewModul.setResponsible_person(Module.getResponsible_person());

        List out = javaBean.saveModuleVersions( NewModuleVersions );
        Gson gsonBuilder = new GsonBuilder().create();
        jsonString = gsonBuilder.toJson(out); //translate to json
        resp.getWriter().write( jsonString );





    }


}
