import java.util.ArrayList;
import java.util.function.Predicate;;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library(){
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void getBorrowedBooksForAllUsers() {
        System.out.println("--- Borrowed Books by Users ---");
        for (User user : users) {
            System.out.println("User: " + user.getName());
            user.printBorrowedBooks();  // Prints the books borrowed by the user
        }
    }

    public void searchByTitle(String title){
        boolean found = false; //track any matching book are fornd
        
        for(Book book: books){
            if(book.getTitle().toLowerCase().contains(title.toLowerCase())){
                book.printBookInfo();
                found = true;
            }
        }

        if(!found){
            System.out.println("Book " + title + " not found");
        }
    }

    public void borrowBook(User user, String title){
        // boolean found= false;

        // for (Book book: books){
        //     if(book.getTitle().equalsIgnoreCase(title)){
        //         found = true;
        //     }

        //     if(book.isAvailable()){
        //         book.setAvailable(false);
        //         user.borrowBook(book.getTitle());

        //         System.out.println("Book " + title + " borrowed successfully by" + user.getName() + ".");
        //     } else{
        //             System.out.println("Book " + title + " is currently unavailable.");
        //     } break;
        // }
        
        // if (!found){
        //     System.out.println("Book " + title + " not found in the library.");
        // }

        Predicate<Book>isBookAvailable = book -> book.getTitle().equalsIgnoreCase(title) && book.isAvailable();

        for (Book book: books){
            if(isBookAvailable.test(book)){
                book.setAvailable(false);
                user.borrowBook(book.getTitle());
                System.out.println("Book: " + title + " borrowed successfully by " + user.getName() + ".");
                return;
            }
        }
        System.out.println("Book: " + title + " is not available or not found.");
    }

    public void listAvailableBooks() {
        for (Book book : books) {
            if (book.isAvailable()) {
                book.printBookInfo();
            }
        }
    }
}
