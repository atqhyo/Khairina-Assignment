import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        // Initialize Scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // Initialize library
        Library library = new Library();
        
        // Add some books to the library
        library.addBook(new Book("Harry Potter", "J.K. Rowling", "12345", true));
        library.addBook(new Book("Lord of the Rings", "J.R.R. Tolkien", "67890", true));
        
        // User input
        System.out.println("Welcome to the Library Management System!");
        
        // Input user details
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        // Create user and add to library system
        User user = new User(name, age);
        library.addUser(user);

        // Display available books
        System.out.println("\n--- Available Books ---");
        library.listAvailableBooks();
        
        // Borrow a book
        System.out.print("\nEnter the title of the book you want to borrow: ");
        String bookTitle = scanner.nextLine();
        library.borrowBook(user, bookTitle);
        
        // Check borrowed books
        System.out.println("\n--- Borrowed Books ---");
        user.printBorrowedBooks();
        
        // Check due dates
        System.out.println("\n--- Due Dates ---");
        user.checkDuedates();
        
        // Check for overdue books
        System.out.println("\n--- Overdue Books ---");
        user.checkOverdueBooks();
        
        scanner.close();
    }
    
}
