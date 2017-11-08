import java.text.SimpleDateFormat;
import java.util.Date;

public class Task extends Document{
    private Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getExecDate() {
        return execDate;
    }

    public void setExecDate(Date execDate) {
        this.execDate = execDate;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getIsControl() {
        return isControl;
    }

    public void setIsControl(String isControl) {
        this.isControl = isControl;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    private Date sendDate;
    private Date execDate;
    private String executor;
    private String isControl;
    private String controller;
    @Override
    public void toString(String s) {
        SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(" ------ "+getName() +" от " + dt.format(getSendDate())+". "+ getSubject() );
    }

}
