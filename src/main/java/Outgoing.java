import java.text.SimpleDateFormat;

public class Outgoing extends Document{
    String addressee;
    String deliveryMethod;
    @Override
    public void toString(String s) {
        SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(" ------ "+name +" №"+ regnum +" от "+ dt.format(regDate)+". "+ subject );
    }

}

