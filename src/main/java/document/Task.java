package document;

import staff.Person;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task extends Document {
    private Date sendDate;
    private Date execDate;
    private Person executor;
    private String isControl;
    private Person controller;

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

    public Person getExecutor() {
        return executor;
    }

    public void setExecutor(Person executor) {
        this.executor = executor;
    }

    public String getIsControl() {
        return isControl;
    }

    public void setIsControl(String isControl) {
        this.isControl = isControl;
    }

    public Person getController() {
        return controller;
    }

    public void setController(Person controller) {
        this.controller = controller;
    }

    @Override
    public void toString(String s) {
        SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(" ------ " + getName() + " от " + dt.format(getSendDate()) + ". " + getSubject());
    }

}
