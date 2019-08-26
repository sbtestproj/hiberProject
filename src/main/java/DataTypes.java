import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet("/data_types")
public class DataTypes extends HttpServlet {

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
        List ListArr = javaBean.getDataTypes(parName, parValue);

        final String json = new ObjectMapper().writeValueAsString(ListArr);

        resp.addHeader( "Access-Control-Allow-Origin", "*");


        resp.getWriter().write(  json );
    }


}
