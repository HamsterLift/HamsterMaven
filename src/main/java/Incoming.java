import java.text.SimpleDateFormat;
import java.util.Date;

public class Incoming extends Document{
    private  String outNum;
    private  Date outDate;
    private  String sender;

    public String getOutNum() {
        return outNum;
    }

    public void setOutNum(String outNum) {
        this.outNum = outNum;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    private String addressee;
    private String controller;

    @Override
      public void toString(String s) {
        SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy");
          System.out.println(" ------ "+getName() +" №"+ getRegnum() +" от "+ dt.format(getRegDate())+". "+ getSubject() );
      }


}
