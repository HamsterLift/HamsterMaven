package document;

import staff.Person;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Incoming extends Document {
    private String outNum;
    private Date outDate;
    private Person sender;
    private String addressee;
    private Person controller;

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

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
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
        System.out.println(" ------ " + getName() + " №" + getRegnum() + " от " + dt.format(getRegDate()) + ". " + getSubject());
    }


}
