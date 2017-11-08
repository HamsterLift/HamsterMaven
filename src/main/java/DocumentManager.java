import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;


public class DocumentManager {

    static final Random random = new Random();

     public Document createNewObject (String DocClass, String FabType){

         DocCreator newDoc = null;

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

        return newDoc.createDoc();
    }

    private static void rememberRegNum(String regNum){
        ArrayList regList = _Main.regNumCollection;
        regList.add(regNum);
    }

    private static Boolean hasRegNum(String regNum){
        ArrayList regList = _Main.regNumCollection;
        return regList.contains(regNum);
    }


    static class DocumentExistsException extends Exception{

        private String number;
        public DocumentExistsException(String message, String num){

            super(message + " ("+num+")");
            number=num;
        }
    }

    public void register(Document doc) throws DocumentExistsException {
        String regNum = Integer.toString(random.nextInt(100));
        if(hasRegNum(regNum)) {
            throw new DocumentExistsException("Документ с таким номером уже зарегистрирован",regNum);
        }else {
            rememberRegNum(regNum);
        }
        doc.regnum = regNum;

    }


    public class TaskCreator implements DocCreator{

        @Override
        public Task createDoc(){
            Task newTask = new Task();
            newTask.author = _Main.getRandomPers();
            newTask.controller =_Main.getRandomPers();
            Calendar cal = Calendar.getInstance();
            cal.set(2017,random.nextInt(12),random.nextInt(30));
            newTask.execDate = cal.getTime();
            newTask.executor =_Main.getRandomPers();
            newTask.id = Integer.toString(random.nextInt());
            newTask.isControl = Boolean.toString(random.nextBoolean());
            cal.set(2017,random.nextInt(12),random.nextInt(30));
            newTask.sendDate = cal.getTime();


            newTask.name = "Поручение";
            newTask.subject = "Тема поручения "+random.nextInt();



            return newTask;
        }
    }



    public class IncomingCreator implements DocCreator{


        @Override
        public Incoming createDoc(){
            Incoming newIncoming = new Incoming();
             newIncoming.outNum =Integer.toString(random.nextInt());
            Calendar cal = Calendar.getInstance();
            cal.set(2017,random.nextInt(12),random.nextInt(30));
             newIncoming.outDate =cal.getTime();
             newIncoming.sender =_Main.getRandomPers();
             newIncoming.addressee =_Main.getRandomPers();
             newIncoming.controller =_Main.getRandomPers();

            newIncoming.id = Integer.toString(random.nextInt());
            newIncoming.name = "Входящий";
            newIncoming.subject = "Краткое содержание "+random.nextInt();



            cal.set(2017,random.nextInt(12),random.nextInt(30));
            newIncoming.regDate = cal.getTime();
            newIncoming.author =_Main.getRandomPers();

            return newIncoming;
        }
    }

    public class OutgoingCreator implements DocCreator{


        @Override
        public Outgoing createDoc() {
            Outgoing newOutgoing = new Outgoing();
            newOutgoing.addressee = _Main.getRandomPers();
            newOutgoing.deliveryMethod ="Способ доставки " + random.nextInt();
            String Id = Integer.toString(random.nextInt());
            newOutgoing.name = "Исходящий";
            newOutgoing.subject = "Краткое содержание "+random.nextInt();
            Calendar cal = Calendar.getInstance();
            cal.set(2017, random.nextInt(11), random.nextInt(30));
            newOutgoing.regDate = cal.getTime();
            newOutgoing.author =_Main.getRandomPers();
            return newOutgoing;
        }
    }
}
