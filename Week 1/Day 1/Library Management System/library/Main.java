import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Library Management System!");

        while(true){
            System.out.println("Please choose from the following options: ");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Find Book By Author");
            System.out.println("5. View The Library");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            int option = input.nextInt();

            switch(option){
                case 1:
                    Library.addBook(new Book());
                    break;
                case 2:
                    Library.addMember(new Member());
                    break;
                case 3:
                    System.out.print("Enter Member ID: ");
                    long  memberId = input.nextLong();
                    System.out.print("Enter Book ISBN: ");
                    String isbn = input.next();
                    Library.borrowBook(memberId, isbn);
                    break;
                case 4:
                    System.out.print("Enter Book's Author: ");
                    String author = input.next();
                    Library.findByAuthor(author);
                    break;
                case 5:
                    Library.printCatalog();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
