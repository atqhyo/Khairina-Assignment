import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class User{
    private String name;
    private int age;
    private ArrayList<String>borrowedBooks;
    private Map<String, LocalDate>borrowedBooksDueDate;

    public User(String n, int a){
        this.name = n;
        this.age = a;
        this.borrowedBooks = new ArrayList<>();
        this.borrowedBooksDueDate = new HashMap<>();
    }

    public void setUser(String n, int a){
        this.name = n;
        this.age = a;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    public void borrowBook(String bookTitle){
        borrowedBooks.add(bookTitle);

        LocalDate duedate = LocalDate.now().plusDays(14);
        borrowedBooksDueDate.put(bookTitle, duedate);

        System.out.println("Book: " + bookTitle + " borrowed." + "\nDue date: " + duedate.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy")));
    }

    public void returnBook(String bookTitle){
        if(borrowedBooks.remove(bookTitle)){
            System.out.println("Book: " + bookTitle + " returned successfully.");
        }else{
            System.out.println("Book: " + bookTitle + " not found in borrowed list.");
        }
    }

    public void checkDuedates(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy");
        
        for(String book: borrowedBooks){
            LocalDate dueDate = borrowedBooksDueDate.get(book);

            System.out.println("Book: " + book + "\nDue Date: " + dueDate.format((formatter)));
        }
    }

    public void checkOverdueBooks(){
        LocalDate nowD = LocalDate.now();

        boolean hasOverdueBooks = false;

        for(String book: borrowedBooks){
            LocalDate dueDate = borrowedBooksDueDate.get(book);
            
            Period period = Period.between(dueDate, nowD);
            
            int daysOverdue = period.getDays();

            String message = daysOverdue > 0 
            ? "Book: " + book + " is overdue by " + daysOverdue + " days." 
            : "Book: " + book + " is not overdue.";

            System.out.println(message);

            if (daysOverdue > 0){
                hasOverdueBooks = true;
            }
        }

        if(!hasOverdueBooks){
            System.out.println("No overdue books.");
        }
    }

    public void printBorrowedBooks(){
        System.out.println("User: " + name + " Borrowed: " + borrowedBooks);
    }
}