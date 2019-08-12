import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/test")
public class App extends HttpServlet{

    @EJB
    JavaBean javaBean;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nameparam = req.getParameter("name");
        tbl_config_items CItems = new tbl_config_items();

 //      List  ListItems = javaBean.getItems(nameparam);
        List ListItems = new ArrayList();
         ListItems = javaBean.getEntities(nameparam); // List<tbl_entities>


        Gson gsonBuilder = new GsonBuilder().create();

        String jsonNew  =  gsonBuilder.toJson(ListItems);



       // List<entity_types> ListItems = javaBean.getEntities();
       //_______  List<entity_types> ListItems = javaBean.getEntities();
     //   List<entities> ListItems = javaBean.getEntities();


        final String json = new ObjectMapper().writeValueAsString(ListItems);

        resp.addHeader( "Access-Control-Allow-Origin", "*");

       // resp.getWriter().write(  ListItems );
        resp.getWriter().write(  jsonNew );

    }
}
