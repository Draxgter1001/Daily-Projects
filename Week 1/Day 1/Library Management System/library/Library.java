import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library(List<Book> books, List<Member> members) {
        this.books = books;
        this.members = members;
    }

    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public List<Member> getMembers() {
        return members;
    }
    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void addBook(Book book) {
        if(this.books == null) {
            this.books = new ArrayList<>();
        }else{
            for(Book b : this.books) {
                if(!b.getIsbn().equals(book.getIsbn())) {
                    this.books.add(b);
                }else{
                    break;
                }
            }
        }
    }

    public void addMember(Member member) {
        if(this.members == null) {
            this.members = new ArrayList<>();
        }else{
            for(Member m : this.members) {
                if(m.getMemberId() != member.getMemberId()) {
                    this.members.add(m);
                }else{
                    break;
                }
            }
        }

    }

    public void borrowBook(String memberId, String isbn){
        
    }
}
