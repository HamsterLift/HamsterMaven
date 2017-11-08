import java.util.*;

public class _Main {
    public static ArrayList persCollection = generatePersList();
    public static ArrayList regNumCollection = new ArrayList();
    public static ArrayList types = new ArrayList<String>(Arrays.asList("Task","Outgoing","Incoming"));
    public static List<Document> docCollection = new ArrayList<Document>();
  //  static final Random random = new Random();

    public static void main(String[] args){
        Random random = new Random();
        DocumentManager docMan = new DocumentManager();

        Document doc;

        for (int i = 0; i<20;i++) {

            doc = docMan.createNewObject(types.get(random.nextInt(2)).toString(), "");
            try {
                docMan.register(doc);
                docCollection.add(doc);


            } catch (DocumentManager.DocumentExistsException e) {
                e.printStackTrace();
            }


        }
        System.out.println("---------------------------------------");
        // Collections.sort(docCollection, Document.DocComparator);
        Collections.sort(docCollection);
        String dAuth= "";
        for(Document dd:docCollection){
            if (dAuth.compareTo(dd.author)!=0) {
                System.out.println(dd.author);
            }

            dd.toString("");
            dAuth = dd.author;
        }

    }

    private static ArrayList generatePersList(){
        ArrayList persList = new ArrayList();
        persList.add("Петров Андрей Петрович");
        persList.add("Петрова Анна Петровна");
        persList.add("Андреев Андрей Петрович");
        persList.add("Чернов Сергей Андреевич");
        persList.add("Белов Валерий Петрович");
        persList.add("Владимиров Иван Петрович");
        persList.add("Краснов Владимир Петрович");
        persList.add("Чирков Андрей Владимирович");

        return persList;

    }
    public static String getRandomPers(){
        Random random = new Random();
        Object pers =null;
        if(!persCollection.isEmpty()){
            pers = persCollection.get((random.nextInt(7)));
        }

        return pers.toString();

    }

}
