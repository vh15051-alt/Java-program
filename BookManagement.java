import java.util.*;

class Book {
    int bookId;
    String title;
    String author;
    double price;

    Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println("Book ID : " + bookId);
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
        System.out.println("Price   : " + price);
        System.out.println("-------------------------");
    }
}

public class BookManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Book> books = new HashMap<>();
        ArrayList<Book> bookList = new ArrayList<>();

        Book b1 = new Book(101, "Java Programming", "James", 500);
        Book b2 = new Book(102, "Python Basics", "Guido", 450);
        Book b3 = new Book(103, "C Programming", "Dennis", 400);

        books.put(b1.bookId, b1);
        books.put(b2.bookId, b2);
        books.put(b3.bookId, b3);

        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);

        System.out.println("===== BOOK MANAGEMENT SYSTEM =====");

        System.out.println("\n--- All Book Records ---");

        for (Book b : books.values()) {
            b.display();
        }

        System.out.print("Enter Book ID to search: ");
        int searchId = sc.nextInt();

        if (books.containsKey(searchId)) {
            System.out.println("\nBook Found:");
            books.get(searchId).display();
        } else {
            System.out.println("Book not found.");
        }

        System.out.print("\nEnter Book ID to update: ");
        int updateId = sc.nextInt();
        sc.nextLine();

        if (books.containsKey(updateId)) {
            Book b = books.get(updateId);

            System.out.print("Enter new title: ");
            b.title = sc.nextLine();

            System.out.print("Enter new author: ");
            b.author = sc.nextLine();

            System.out.print("Enter new price: ");
            b.price = sc.nextDouble();

            System.out.println("\nBook updated successfully!");
        } else {
            System.out.println("Book not found.");
        }

        System.out.print("\nEnter Book ID to delete: ");
        int deleteId = sc.nextInt();

        if (books.containsKey(deleteId)) {
            books.remove(deleteId);

            Iterator<Book> iterator = bookList.iterator();

            while (iterator.hasNext()) {
                Book b = iterator.next();

                if (b.bookId == deleteId) {
                    iterator.remove();
                }
            }

            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("\n--- Updated Book Records ---");

        for (Map.Entry<Integer, Book> entry : books.entrySet()) {
            entry.getValue().display();
        }

        System.out.println("--- ArrayList Records ---");

        Iterator<Book> it = bookList.iterator();

        while (it.hasNext()) {
            Book b = it.next();
            b.display();
        }

        sc.close();
    }
}