import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        Library library = new Library();
  
        library.addBook(new Book("Harry Potter", "J.K. Rowling", "12345", true));
        library.addBook(new Book("Lord of the Rings", "J.R.R. Tolkien", "67890", true));

        System.out.println("Welcome to the Library Management System!");
        
        for (int i = 0; i < 2; i++){
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
        
            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            sc.nextLine();
        
            User user = new User(name, age);
            library.addUser(user);

            System.out.println("\n--- Available Books ---");
            library.listAvailableBooks();
        
            System.out.print("\nEnter the title of the book you want to borrow: ");
            String bookTitle = sc.nextLine();
            library.borrowBook(user, bookTitle);
        
            System.out.println("\n--- Borrowed Books ---");
            user.printBorrowedBooks();
        
            System.out.println("\n--- Due Dates ---");
            user.checkDuedates();
        
            System.out.println("\n--- Overdue Books ---");
            user.checkOverdueBooks();
        }
        
        sc.close();
    }
    
}
