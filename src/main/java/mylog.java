import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class mylog {
    private boolean sing_new = false;
    public void write(String my_message){
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
