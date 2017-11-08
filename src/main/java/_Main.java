import java.util.*;

class _Main {

    private static ArrayList<String> persCollection = _Main.generatePersList();
  //  static final Random random = new Random();

    private static ArrayList<String> getPersCollection() {
       return persCollection;
    }
    public static void main(String[] args){
        Random random = new Random();
        DocumentManager docMan = new DocumentManager();
        Document doc;

        for (int i = 0; i<20;i++) {

            doc = docMan.createNewObject(Collector.getTypes().get(random.nextInt(2)), "");
            try {
                docMan.register(doc);
                Collector.getDocCollection().add(doc);


            } catch (DocumentManager.DocumentExistsException e) {
                e.printStackTrace();
            }


        }
        System.out.println("---------------------------------------");
        // Collections.sort(docCollection, Document.DocComparator);
        Collections.sort( Collector.getDocCollection());
        String dAuth= "";
        for(Document dd: Collector.getDocCollection()){
            if (dAuth.compareTo(dd.getAuthor())!=0) {
                System.out.println(dd.getAuthor());
            }

            dd.toString("");
            dAuth = dd.getAuthor();
        }

    }

    private static ArrayList<String> generatePersList(){
        ArrayList<String> persList = new ArrayList<String>();
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
        if(!getPersCollection().isEmpty()){
            pers = getPersCollection().get((random.nextInt(7)));
        }

        return pers != null ? pers.toString() : null;

    }

}
