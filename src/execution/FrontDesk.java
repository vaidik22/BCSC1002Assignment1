/*  Created by IntelliJ IDEA.
 *  User: Divyansh Bhardwaj (dbc2201)
 *  Date: 21/08/20
 *  Time: 3:50 PM
 *  File Name : FrontDesk.java
 * */
package execution;

import definitions.Library;
import definitions.Student;

import java.util.Scanner;

public class FrontDesk {
        private static final int ISSUE_BOOK = 1;
        private static final int RETURN_BOOK = 2;
        private static final int ALL_ISSUED_BOOKS = 3;
        private static final int Exit = 4;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int studentInput;
            Student student = new Student();
            Library library = new Library();
            library.setBooksInLibrary();
            String bookName;
            do {
                System.out.println("-=-=--=-=-\"Welcome To The Front Desk\"-=-=--=-=-");
                System.out.println("How may I help you today?");
                System.out.println("1. Issue a new book for me.");
                System.out.println("2. Return a previously issues book for me.");
                System.out.println("3. Show me all my issues books.");
                System.out.println("4. Exit.");
                System.out.println("Enter your choice (1..4): ");
                studentInput = scanner.nextInt();
                switch (studentInput) {
                    case ISSUE_BOOK:
                        scanner.nextLine();
                        System.out.println("Enter your First name:");
                        student.setStudentFirstName(scanner.nextLine());
                        System.out.println("Enter your Middle name:");
                        student.setStudentMiddleName(scanner.nextLine());
                        System.out.println("Enter your Last name:");
                        student.setStudentLastName(scanner.nextLine());
                        System.out.println("Enter your University roll number: ");
                        student.setStudentUniversityRollNumber(scanner.nextLong());
                        System.out.println("How much books you want to issue: ");
                        student.setNumberOfBooksIssued(scanner.nextInt());
                        System.out.println("These are the available books: ");
                        library.showAvailableBooks();
                        scanner.nextLine();
                        System.out.println("Enter the details of the books you want to issue: ");
                        for (int bookIssuingIndex = 0; bookIssuingIndex < student.getNumberOfBooksIssued(); bookIssuingIndex++) {
                            System.out.println("Enter name of book " + (bookIssuingIndex + 1) + ": ");
                            bookName = scanner.nextLine();
                            student.issueBooksToStudents(bookIssuingIndex, bookName);
                        }
                        System.out.println("Thank you for Issuing the Books..");
                        break;
                    case RETURN_BOOK:
                        if (student.getNumberOfBooksIssued() == 0) {
                            System.out.println("Sorry, you haven't issued any book yet so you can't return book.");
                        } else {
                            System.out.println("Enter the name of the book you want to return: ");
                            scanner.nextLine();
                            bookName = scanner.nextLine();
                            if (student.returnBook(bookName)) {
                                System.out.println("Thank you for returning the book " + bookName + ".");
                            }
                        }
                        break;
                    case ALL_ISSUED_BOOKS:
                        student.showIssuedBooksByStudent();
                        break;
                    case Exit:
                        System.out.println("Thanks for using our service");
                        break;
                    default:
                        System.out.println("Sorry you entered wrong choice");
                        break;
                }
            } while (studentInput != Exit);
            scanner.close();
        }
    }


