import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> books = new ArrayList<>();

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("📚 Book added successfully!");
    }

    // Display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("📭 The library is currently empty.");
            return;
        }
        System.out.println("\n--- Library Catalog ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Borrow a book by ID
    public void borrowBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("✅ You have successfully borrowed: " + book.getTitle());
                    return;
                } else {
                    System.out.println("❌ Sorry, this book is already borrowed.");
                    return;
                }
            }
        }
        System.out.println("🔍 Book with ID " + id + " not found.");
    }

    // Return a borrowed book
    public void returnBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("✅ Thank you! Successfully returned: " + book.getTitle());
                    return;
                } else {
                    System.out.println("⚠️ This book was not borrowed.");
                    return;
                }
            }
        }
        System.out.println("🔍 Book with ID " + id + " not found.");
    }
}