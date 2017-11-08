import java.text.SimpleDateFormat;

public class Outgoing extends Document{
    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    private   String addressee;
    private   String deliveryMethod;
    @Override
    public void toString(String s) {
        SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(" ------ "+getName() +" №"+ getRegnum() +" от "+ dt.format(getRegDate())+". "+ getSubject() );
    }

}

