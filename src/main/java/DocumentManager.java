import document.Document;
import document.Incoming;
import document.Outgoing;
import document.Task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;


public class DocumentManager {

    private static final Random random = new Random();

    private static void rememberRegNum(String regNum) {
        ArrayList regList = Collector.getRegNumCollection();
        regList.add(regNum);
    }

    private static Boolean hasRegNum(String regNum) {
        ArrayList regList = Collector.getRegNumCollection();
        return regList.contains(regNum);
    }

    public Document createNewObject(String DocClass, String FabType) {

        DocCreator newDoc;

        String s = DocClass.toLowerCase();
        if (s.equals("task")) {
            newDoc = new TaskCreator();

        } else if (s.equals("incoming")) {
            newDoc = new IncomingCreator();

        } else if (s.equals("outgoing")) {
            newDoc = new OutgoingCreator();

        } else {
            newDoc = null;
        }

        return newDoc != null ? newDoc.createDoc() : null;
    }

    public void register(Document doc) throws DocumentExistsException {
        String regNum = Integer.toString(random.nextInt(100));
        if (hasRegNum(regNum)) {
            throw new DocumentExistsException("Документ с таким номером уже зарегистрирован", regNum);
        } else {
            rememberRegNum(regNum);
        }
        doc.setRegnum(regNum);

    }

    static class DocumentExistsException extends Exception {

        //private String number;
        DocumentExistsException(String message, String num) {

            super(message + " (" + num + ")");
            //    number=num;
        }
    }

    public class TaskCreator implements DocCreator {

        @Override
        public Task createDoc() {
            Task newTask = new Task();
            newTask.setAuthor(_Main.getRandomPers());
            newTask.setController(_Main.getRandomPers());
            Calendar cal = Calendar.getInstance();
            cal.set(2017, random.nextInt(12), random.nextInt(30));
            newTask.setExecDate(cal.getTime());
            newTask.setExecutor(_Main.getRandomPers());
            newTask.setId(Integer.toString(random.nextInt()));
            newTask.setIsControl(Boolean.toString(random.nextBoolean()));
            cal.set(2017, random.nextInt(12), random.nextInt(30));
            newTask.setSendDate(cal.getTime());
            newTask.setName("Поручение");
            newTask.setSubject("Тема поручения " + random.nextInt());

            return newTask;
        }
    }

    public class IncomingCreator implements DocCreator {


        @Override
        public Incoming createDoc() {
            Incoming newIncoming = new Incoming();
            newIncoming.setOutNum(Integer.toString(random.nextInt()));
            Calendar cal = Calendar.getInstance();
            cal.set(2017, random.nextInt(12), random.nextInt(30));
            newIncoming.setOutDate(cal.getTime());
            newIncoming.setSender(_Main.getRandomPers());
          //  newIncoming.setAddressee(_Main.getRandomAddressee());
            newIncoming.setController(_Main.getRandomPers());
            newIncoming.setId(Integer.toString(random.nextInt()));
            newIncoming.setName("Входящий");
            newIncoming.setSubject("Краткое содержание " + random.nextInt());
            cal.set(2017, random.nextInt(12), random.nextInt(30));
            newIncoming.setRegDate(cal.getTime());
            newIncoming.setAuthor(_Main.getRandomPers());

            return newIncoming;
        }
    }

    public class OutgoingCreator implements DocCreator {
        @Override
        public Outgoing createDoc() {
            Outgoing newOutgoing = new Outgoing();
            newOutgoing.setAddressee(_Main.getRandomAddressee());
            newOutgoing.setDeliveryMethod("Способ доставки " + random.nextInt());
            newOutgoing.setId(Integer.toString(random.nextInt()));
            newOutgoing.setName("Исходящий");
            newOutgoing.setSubject("Краткое содержание " + random.nextInt());
            Calendar cal = Calendar.getInstance();
            cal.set(2017, random.nextInt(11), random.nextInt(30));
            newOutgoing.setRegDate(cal.getTime());
            newOutgoing.setAuthor(_Main.getRandomPers());
            return newOutgoing;
        }
    }
}
