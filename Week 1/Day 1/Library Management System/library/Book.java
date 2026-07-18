import java.util.Objects;

public class Book {

    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean available;


    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book Details: " + getTitle() + ", " + getAuthor() + ", " + getYear() + ". Available: " + isAvailable();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if( !(o instanceof Book other)) return false;
        return isbn.equals(other.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
