import java.util.ArrayList;
import java.util.List;

public class Library {
    private static List<Book> booksList = new ArrayList<>();
    private static List<Member> membersList = new ArrayList<>();

    public Library(List<Book> booksList, List<Member> membersList) {
        this.booksList = booksList;
        this.membersList = membersList;
    }

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

    public static void addBook(Book book) {
        if(booksList == null) {
            booksList = new ArrayList<>();
        }

        System.out.print("Enter Book ISBN: ");
        String isbn = Main.input.next();
        System.out.print("Enter Book Title: ");
        String title = Main.input.next();
        System.out.print("Enter Book Author: ");
        String author = Main.input.next();
        System.out.print("Enter Book Year: ");
        int year = Main.input.nextInt();
        System.out.print("Enter Book Availability: ");
        boolean available = Main.input.nextBoolean();

        if(!booksList.contains(book.getIsbn())){
            book.setIsbn(isbn);
            book.setTitle(title);
            book.setAuthor(author);
            book.setYear(year);
            book.setAvailable(available);
            booksList.add(book);
            System.out.println("Book added successfully!");
        }else {
            System.out.println("Book already exists");
        }
    }

    public static void addMember(Member member) {
        if(membersList == null) {
            membersList = new ArrayList<>();
        }

        System.out.print("Enter Member ID: ");
        int memberID = Main.input.nextInt();
        System.out.print("Enter Member Name: ");
        String memberName = Main.input.next();

        if(!membersList.contains(member.getMemberId())){
            member.setMemberId(memberID);
            member.setName(memberName);
            membersList.add(member);
            System.out.println("Member added successfully!");
        }else{
            System.out.print("Member already exists");
        }
    }

    public static void borrowBook(long memberId, String isbn){
        Member member = new Member();
        Book book = new Book();

        if(membersList.contains(member.getMemberId() == memberId)){
            if(booksList.contains(book.getIsbn().equals(isbn) && book.isAvailable() == true)) {
                addBook(book);
            } else if (book.isAvailable() == false) {
                System.out.println("Book is not available");
            }
        }else{
            System.out.println("Member ID not found");
        }
    }

    public static void returnBook(long memberId, String isbn){
        if(membersList == null) {
            membersList = new ArrayList<>();
        }
        Member member = new Member();
        Book book = new Book();
        if(membersList.contains(member.getMemberId() == memberId)){
            if(booksList.contains(book.getIsbn().equals(isbn) && book.isAvailable() == true)) {
                booksList.remove(book.getIsbn().equals(isbn) && book.isAvailable() == true);
            }else  {
                System.out.println("Book is not available");
            }
        }
    }

    public static Book findByAuthor(String author){
        if(membersList == null) {
            membersList = new ArrayList<>();
        }
       for(Book book : booksList){
           if(book.getAuthor().equals(author)){
               return book;
           }
       }
        return null;
    }

    public static void printCatalog(){

        for(Book book : booksList){
            System.out.println(book);
        }
    }
}
