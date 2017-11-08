import java.text.SimpleDateFormat;
import java.util.Date;

public class Task extends Document{
Date sendDate;
Date execDate;
String executor;
String isControl;
String controller;
    @Override
    public void toString(String s) {
        SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(" ------ "+name +" от " + dt.format(sendDate)+". "+ subject );
    }

}
