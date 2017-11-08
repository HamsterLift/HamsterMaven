import java.text.SimpleDateFormat;
import java.util.Date;

public class Incoming extends Document{
    String outNum;
    Date outDate;
    String sender;
    String addressee;
    String controller;

    @Override
      public void toString(String s) {
        SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy");
          System.out.println(" ------ "+name +" №"+ regnum +" от "+ dt.format(regDate)+". "+ subject );
      }


}
