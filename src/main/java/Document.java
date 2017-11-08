import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public abstract class Document implements Comparable<Document> {
    //    идентификатор документа;
//    название документа;
//    текст документа;
//    регистрационный номер документа;
//    дата регистрации документа;
//    автор документа.
    String id;
    String name;
    String subject;
    String regnum;
    Date regDate;
    String author;


    public String getDocumentID() {
        return id;
    }


    public ArrayList getDocTable() {
        ArrayList docTable = null;
        return docTable;
    }

    @Override
    public int compareTo(Document o) {
        String doc1 = author +"|"+name;
        String doc2 =o.author +"|"+o.name;
        if (doc1.compareTo(doc2) >= 0) {
          return 1;
             }
      return -1;
    }

    public static Comparator<Document> DocComparator = new Comparator<Document>() {

        public int compare(Document doc1, Document doc2) {

            String docName1 = doc1.name.toUpperCase();
            String docName2 = doc2.name.toUpperCase();

            //ascending order
            return docName1.compareTo(docName2);

            //descending order
            //return fruitName2.compareTo(fruitName1);
        }

    };

    public abstract void toString(String s);
}

