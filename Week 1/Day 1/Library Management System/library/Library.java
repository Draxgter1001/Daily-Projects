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
        if(booksList == null) {
            booksList = new ArrayList<>();
        }

        if(findBook(book.getIsbn()) == null) {
            booksList.add(book);
            System.out.println("Book added successfully!");
        }else {
            System.out.println("Book already exists");
            System.out.println();
        }
    }

    public void addMember(Member member) {
        if(membersList == null) {
            membersList = new ArrayList<>();
        }

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
        if(member == null ||  member.getBorrowedBooks().size() >= 3){
            System.out.println("Member not found or member already borrowed!");
            return false;
        }
        Book book = findBook(isbn);
        if(book == null){
            System.out.println("Book not found or isbn not found!");
            return false;
        }

        if(book.getIsbn().equals(isbn) && member.getMemberId() == memberId && member.getBorrowedBooks().size() < 3){
            book.setAvailable(false);
            member.borrowBook(book);
            System.out.println("Book borrowed successfully!");
        }
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

        if(book.getIsbn().equals(isbn) && member.getMemberId() == memberId && !member.getBorrowedBooks().isEmpty()){
            book.setAvailable(true);
            member.returnBook(book);
            System.out.println("Book returned successfully!");
        }

        return true;
    }

    public void findByAuthor(String author){
        if(membersList == null) {
            membersList = new ArrayList<>();
        }
        for (Book book : booksList) {
            if (book.getAuthor().equals(author)) {
                System.out.println(book);
            }
        }
    }

    public void printCatalog(){

        for(Book book : booksList){
            System.out.println(book);
        }
    }
}
