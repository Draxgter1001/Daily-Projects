import java.util.ArrayList;
import java.util.List;

public class Library {
    private  List<Book> booksList;
    private  List<Member> membersList;

    public Library() {
        booksList = new ArrayList<>();
        membersList = new ArrayList<>();
    }

    private Member findMember(long memberId){
        for(Member member : membersList){
            if(member.getMemberId() == memberId){
                return member;
            }
        }
        return null;
    }

    private Book findBook(String bookId){
        for(Book book : booksList) {
            if (book.getIsbn().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book) {

        if(findBook(book.getIsbn()) == null) {
            booksList.add(book);
            System.out.println("Book added successfully!");
        }else {
            System.out.println("Book already exists");
            System.out.println();
        }
    }

    public void addMember(Member member) {

        if(findMember(member.getMemberId()) == null) {
            membersList.add(member);
            System.out.println("Member added successfully!");
        }else{
            System.out.print("Member already exists");
            System.out.println();
        }
    }

    public boolean borrowBook(long memberId, String isbn){
        Member member = findMember(memberId);
        if(member == null){
            System.out.println("Member not found!");
            return false;
        }
        if(member.getBorrowedBooks().size() >= 3){
            System.out.println("Borrow limit reached!");
            return false;
        }

        Book book = findBook(isbn);
        if(book == null){
            System.out.println("Book not found or isbn not found!");
            return false;
        }

        if(!book.isAvailable()){
            System.out.println("Book is not available!");
            return false;
        }

        book.setAvailable(false);
        member.borrowBook(book);
        System.out.println("Book borrowed successfully!");
        return true;
    }

    public boolean returnBook(long memberId, String isbn){
        Member  member = findMember(memberId);
        Book book = findBook(isbn);

        if(book == null){
            System.out.println("Book not found!");
            return false;
        }
        if(member == null){
            System.out.println("Member not found!");
            return false;
        }

        if(!member.getBorrowedBooks().contains(book)){
            System.out.println("This member has not borrowed this book!");
            return false;
        }

        book.setAvailable(true);
        member.returnBook(book);
        System.out.println("Book returned successfully!");
        return true;
    }

    public List<Book> findByAuthor(String author){
        List<Book> result = new ArrayList<>();
        for(Book book : booksList){
            if(book.getAuthor().equalsIgnoreCase(author)){
                result.add(book);
            }
        }

        return result;
    }

    public void printCatalog(){

        for(Book book : booksList){
            System.out.println(book);
        }
    }
}
