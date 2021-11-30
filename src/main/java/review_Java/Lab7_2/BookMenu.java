package review_Java.Lab7_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class BookMenu {
    static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        boolean isContinuing = true;
        int retryTime = 0;
        int MAX_TRY_TIME = 3;


        while (isContinuing) {
            System.out.println("Please select your number options. Max 3 times wrong choice.");
            System.out.println("1. Add book");
            System.out.println("2. Retrieve book");
            System.out.println("0. Exit");

            System.out.println("Your choice:");

            Scanner scanner = new Scanner(System.in);
            int userOption = scanner.nextInt();

            if (userOption == 1) {
                addBook();
            } else if (userOption == 2) {
                retrieveBook();
            } else if (userOption == 0) {
                isContinuing = false;
                break;
            } else {
                retryTime++;
                System.out.printf("Wrong option %d times%n", retryTime);
                if (retryTime == MAX_TRY_TIME) {
                    System.out.printf("You are wrong 3 times!");
                    break;
                }
            }
        }
    }

    private static void addBook() {
        String ISBN, title, author, year = "";
        Scanner bookInfoInput = new Scanner(System.in);
        System.out.println("ISBN:");
        ISBN = bookInfoInput.nextLine();

        System.out.println("Title:");
        title = bookInfoInput.nextLine();

        System.out.println("Author:");
        author = bookInfoInput.nextLine();

        System.out.println("Year:");
        year = bookInfoInput.nextLine();

        Book book = new Book(ISBN, title, author, year);
        books.add(book);
    }

    private static void retrieveBook() {
        String searchISBN = "";
        Scanner bookInfoInput = new Scanner(System.in);
        System.out.println("Search ISBN:");
        searchISBN = bookInfoInput.nextLine();

        for(Book book:books){
            String ISBN = book.getISBN().toUpperCase();
            if(ISBN.equals(searchISBN.toLowerCase())){
                System.out.println("Book found:");
                System.out.println(book);
                return;
            }
        }

        System.out.println("Not found");
    }
}
