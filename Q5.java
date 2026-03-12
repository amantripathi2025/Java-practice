package Basic;

interface Printable{
    void print();
}
class Document implements Printable{
    String title;
    Document(String title){
        this.title = title;
    }
    @Override
    public void print(){
        System.out.println("Printing Basic.Document: "+title);
    }
}

class Photo implements Printable{
    String filename;
    Photo(String filename){
            this.filename = filename;
    }
    @Override
    public void print(){
        System.out.println("My photo is store in: "+filename);
    }
}


public class Q5 {
    static void main() {
        Printable d = new Document("Resume.pdf");
        Printable p = new Photo("Image.jpg");

        d.print();
        p.print();
        }
    }

