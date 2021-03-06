package document;

import staff.Person;

import java.util.Comparator;
import java.util.Date;

public abstract class Document implements Comparable<Document> {
    public static Comparator<Document> DocComparator = new Comparator<Document>() {

        public int compare(Document doc1, Document doc2) {

            String docName1 = doc1.getName().toUpperCase();
            String docName2 = doc2.getName().toUpperCase();

            //ascending order
            return docName1.compareTo(docName2);

            //descending order
            //return fruitName2.compareTo(fruitName1);
        }

    };
    private String id;
    private String name;
    private String subject;
    private String regnum;
    private Date regDate;
    private Person author;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRegnum() {
        return regnum;
    }

    public void setRegnum(String regnum) {
        this.regnum = regnum;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public String getDocumentID() {
        return id;
    }

    @Override
    public int compareTo(Document o) {
        String doc1 = getAuthor() + "|" + getName();
        String doc2 = o.getAuthor() + "|" + o.getName();
        if (doc1.compareTo(doc2) >= 0) {
            return 1;
        }
        return -1;
    }

    public abstract void toString(String s);
}

