import Importer.ImportStaff;
import com.google.gson.Gson;
import document.Document;
import staff.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class _Main {

    private static ArrayList<Person> persCollection = _Main.generatePersList();
    private static ArrayList<String> addrCollection = _Main.generateAddrList();
    //  static final Random random = new Random();

    private static ArrayList<Person> getPersCollection() {
        return persCollection;
    }
    private static ArrayList<String> getAddrCollection() {
        return addrCollection;
    }
    public static void main(String[] args) {

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

        Map<String,List<Document>> byAuthor = new HashMap();

        for(Document dd: Collector.getDocCollection()){
            if(!byAuthor.containsKey(dd.getAuthor().getId())){
                byAuthor.put(dd.getAuthor().getId(), new ArrayList());
            }
            byAuthor.get(dd.getAuthor().getId()).add(dd);
        }

        for (Map.Entry<String, List<Document>> entry : byAuthor.entrySet()){
            Gson gson = new Gson();
            try {
                gson.toJson(entry, new FileWriter(entry.getKey()+".json"));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }



       /* Collections.sort( Collector.getDocCollection());

        for(Document dd: Collector.getDocCollection()){
            if (dAuth.compareTo(dd.getAuthor().getId())!=0) {
                System.out.println(dd.getAuthor());

            }



            try {
                gson.toJson(dd, new FileWriter(dd.getAuthor()+".json"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            dd.toString("");
            dAuth = dd.getAuthor().getId();
        }

*/


    }

    private static ArrayList<Person> generatePersList() {

        ArrayList<Person> persList = new ArrayList<Person>();

        ImportStaff parse = new ImportStaff();

        try {
            persList =  parse.loadStaff("person", "person.xml");
          //  parse.loadStaff("department", "deps.xml");
          //  parse.loadStaff("organization", "orgs.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persList;

    }

    private static ArrayList<String> generateAddrList() {

        ArrayList<String> addrList = new ArrayList<String>();

        addrList.add("Петров Андрей Петрович");
        addrList.add("Петрова Анна Петровна");
        addrList.add("Андреев Андрей Петрович");
        addrList.add("Чернов Сергей Андреевич");
        addrList.add("Белов Валерий Петрович");
        addrList.add("Владимиров Иван Петрович");
        addrList.add("Краснов Владимир Петрович");
        addrList.add("Чирков Андрей Владимирович");

        return addrList;

    }

    public static String getRandomAddressee() {
        Random random = new Random();
        String addr = null;
        if (!getAddrCollection().isEmpty()) {
            addr = getAddrCollection().get((random.nextInt(getAddrCollection().size())));
        }

        return addr != null ? addr : null;

    }

    public static Person getRandomPers() {
        Random random = new Random();
        Person pers = null;
        if (!getPersCollection().isEmpty()) {
            pers = getPersCollection().get((random.nextInt(getPersCollection().size())));
        }

        return pers != null ? pers : null;

    }

}
