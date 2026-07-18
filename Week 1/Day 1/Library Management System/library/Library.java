import java.util.ArrayList;
import java.util.List;

public class Library {
    private  List<Book> booksList;
    private  List<Member> membersList;

    public Library() {
        booksList = new ArrayList<>();
        membersList = new ArrayList<>();
    };

    public List<Book> getBooks() {
        return booksList;
    }
    public void setBooks(List<Book> books) {
        this.booksList = books;
    }
    public List<Member> getMembers() {
        return membersList;
    }
    public void setMembers(List<Member> membersList) {
        this.membersList = membersList;
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

        if(!booksList.contains(book.getIsbn())){
            booksList.add(book);
            System.out.println("Book added successfully!");
        }else {
            System.out.println("Book already exists");
        }
    }

    public void addMember(Member member) {
        if(membersList == null) {
            membersList = new ArrayList<>();
        }

        if(!membersList.contains(member.getMemberId())){
            membersList.add(member);
            System.out.println("Member added successfully!");
        }else{
            System.out.print("Member already exists");
        }
    }

    public boolean borrowBook(long memberId, String isbn){
        Member member = findMember(memberId);
        if(member == null){
            System.out.println("Member not found!");
            return false;
        }
        Book book = findBook(isbn);
        if(book == null){
            System.out.println("Book not found!");
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

        book.setAvailable(true);
        member.returnBook(book);
        System.out.println("Book returned successfully!");
        return true;
    }

    public void findByAuthor(String author){
        if(membersList == null) {
            membersList = new ArrayList<>();
        }
       for(int i = 0; i < booksList.size(); i++){
           if(booksList.get(i).getAuthor().equals(author)){
               System.out.println(booksList.get(i));
           }
       }
    }

    public void printCatalog(){

        for(Book book : booksList){
            System.out.println(book);
        }
    }
}
