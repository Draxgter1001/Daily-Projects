import java.util.List;
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
            System.out.println("3. Borrow Book (Each member can only borrow up to 3 books)");
            System.out.println("4. Return Book");
            System.out.println("5. Find Book By Author");
            System.out.println("6. View The Library");
            System.out.println("7. Quit");
            System.out.print("Enter your choice: ");
            int option = input.nextInt();
            input.nextLine();

            switch(option){
                case 1:

                    System.out.print("Enter Book ISBN: ");
                    String isbn = Main.input.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = Main.input.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = Main.input.nextLine();
                    System.out.print("Enter Book Year: ");
                    int year = Main.input.nextInt();
                    input.nextLine();

                    library.addBook(new Book(isbn, title, author, year));
                    break;
                case 2:
                    System.out.print("Enter Member ID: ");
                    int memberID = Main.input.nextInt();
                    input.nextLine();
                    System.out.print("Enter Member Name: ");
                    String memberName = Main.input.nextLine();

                    library.addMember(new Member(memberID, memberName));
                    break;
                case 3:
                    System.out.print("Enter Member ID: ");
                    long  borrowMemberId = input.nextLong();
                    input.nextLine();
                    System.out.print("Enter Book ISBN: ");
                    String borrowIsbn = input.nextLine();
                    library.borrowBook(borrowMemberId, borrowIsbn);
                    break;
                case 4:
                    System.out.print("Enter Member ID: ");
                    long  returnMemberId = input.nextLong();
                    input.nextLine();
                    System.out.print("Enter Book ISBN: ");
                    String returnIsbn = input.nextLine();
                    library.returnBook(returnMemberId, returnIsbn);
                    break;
                case 5:
                    System.out.print("Enter Book's Author: ");
                    String filterByAuthor = input.nextLine();
                    List<Book> found = library.findByAuthor(filterByAuthor);
                    if(found.isEmpty()){
                        System.out.println("No books found with that author");
                    }else{
                        found.forEach(System.out::println);
                    }
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
