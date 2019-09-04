import JavaBeans.JavaBean;
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

@WebServlet("/appparameter")
public class AddParameter extends HttpServlet {
    @EJB
    JavaBean javaBean;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        mylog MyLog = new mylog();

        resp.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        resp.addHeader("Access-Control-Allow-Methods","GET,POST,PATCH,DELETE,PUT,OPTIONS");
        resp.addHeader("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token, content-type");
        resp.addHeader("Content-Type",   "application/json");  //"text/plain");

        resp.setStatus(200);

        MyLog.write("*****************addparameter post:******************* \n");
        String jsonString = new String();
        try {
            String line = "";
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null) {
                jsonString += line;
                MyLog.write(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        test json = new test();
        json.name="1";
        Gson gsonBuilder = new GsonBuilder().create();
        jsonString = gsonBuilder.toJson(json); //translate to json
        resp.getWriter().write( jsonString );

    }
}



