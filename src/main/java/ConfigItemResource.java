import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET; import javax.ws.rs.Path;
import Entities.tbl_config_items;


@Path(value="/contacts")
public class ConfigItemResource {


    @GET public List<tbl_config_items> getContacts() {

        mylog("contacts");
        return null;

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
