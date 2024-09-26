public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable = true;

    public Book(String title, String author, String isbn, boolean isAvailable){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    public void setAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getIsbn(){
        return isbn;
    }
    public boolean isAvailable(){
        return isAvailable;
    }

    public String printBookInfo(){
        return ("Title: " + title + "Author: " + author + "ISBN: " + isbn + "Available: " + isAvailable);
    }
}
