import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Member {

    private long memberId;
    private String name;
    private List<Book> borrowedBooks;

    public Member(long memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public long getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return List.copyOf(borrowedBooks);
    }

    public void borrowBook(Book book) {
        this.borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        this.borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Member's Details: " + getMemberId() + ", " + getName() + ". Books Borrowed: " + getBorrowedBooks();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( !(o instanceof Member other)) return false;
        return memberId == other.memberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId);
    }
}
