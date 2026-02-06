package in.kgcoding.challange80;

public class LibraryItem {
    private String ItemId;
    private String title;
    private String author;

    public void checkout(){
        System.out.println("Checkout");

    }

    public void returnItem(){
        System.out.println("Returning the item");
    }
}
