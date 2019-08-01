import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/test")
public class App extends HttpServlet{

    @EJB
    JavaBean javaBean;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nameparam = req.getParameter("name");
        ConfigItems CItems = new ConfigItems();
        List<ConfigItems> ListItems = javaBean.getItems(nameparam);

        final String json = new ObjectMapper().writeValueAsString(ListItems);

        resp.addHeader( "Access-Control-Allow-Origin", "*");;
        resp.getWriter().write(  json );

    }
}
