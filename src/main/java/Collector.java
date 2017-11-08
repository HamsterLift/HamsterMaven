import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Collector {
    private static ArrayList regNumCollection = new ArrayList();
    private static ArrayList<String> types = new ArrayList<String>(Arrays.asList("Task","Outgoing","Incoming"));
    private static List<Document> docCollection = new ArrayList<Document>();


    public static ArrayList getRegNumCollection() {
        return regNumCollection;
    }

    public static ArrayList<String> getTypes() {
        return types;
    }

    public static List<Document> getDocCollection() {
        return docCollection;
    }



}
