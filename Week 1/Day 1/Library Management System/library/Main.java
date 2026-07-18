import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Library library = new Library();

        System.out.println("Welcome to Library Management System!");

        while(true){
            System.out.println("Please choose from the following options: ");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Find Book By Author");
            System.out.println("6. View The Library");
            System.out.println("7. Quit");
            System.out.print("Enter your choice: ");
            int option = input.nextInt();

            switch(option){
                case 1:

                    Book book = new Book();
                    System.out.print("Enter Book ISBN: ");
                    String isbn = Main.input.next();
                    System.out.print("Enter Book Title: ");
                    String title = Main.input.next();
                    input.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = Main.input.next();
                    System.out.print("Enter Book Year: ");
                    int year = Main.input.nextInt();
                    input.nextLine();

                    book.setIsbn(isbn);
                    book.setTitle(title);
                    book.setAuthor(author);
                    book.setYear(year);

                    library.addBook(book);
                    break;
                case 2:
                    System.out.print("Enter Member ID: ");
                    int memberID = Main.input.nextInt();
                    System.out.print("Enter Member Name: ");
                    String memberName = Main.input.next();

                    Member member = new Member(memberID, memberName);
                    member.setMemberId(memberID);
                    member.setName(memberName);

                    library.addMember(member);
                    break;
                case 3:
                    System.out.print("Enter Member ID: ");
                    long  borrowMemberId = input.nextLong();
                    System.out.print("Enter Book ISBN: ");
                    String borrowIsbn = input.next();
                    library.borrowBook(borrowMemberId, borrowIsbn);
                    break;
                case 4:
                    System.out.print("Enter Member ID: ");
                    long  returnMemberId = input.nextLong();
                    System.out.print("Enter Book ISBN: ");
                    String returnIsbn = input.next();
                    library.returnBook(returnMemberId, returnIsbn);
                    break;
                case 5:
                    System.out.print("Enter Book's Author: ");
                    String filterByAuthor = input.next();
                    library.findByAuthor(filterByAuthor);
                    break;
                case 6:
                    library.printCatalog();
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }
}
