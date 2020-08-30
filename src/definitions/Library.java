/*  Created by IntelliJ IDEA.
 *  User: Divyansh Bhardwaj (dbc2201)
 *  Date: 21/08/20
 *  Time: 3:50 PM
 *  File Name : Library.java
 * */
package definitions;

import java.util.Arrays;

public class Library {
    private static final int MAXIMUM_BOOKS_IN_LIBRARY = 5;
    private Book[] available;

    public Library() {
        this.available= new Book[MAXIMUM_BOOKS_IN_LIBRARY];
        for (int i = 0; i < MAXIMUM_BOOKS_IN_LIBRARY; i++) {
            available[i] = new Book();
        }
    }

    public Library(Book[] available) {
        this.available= available;
    }

    public Book[] getAvailableBooks() {
        return available;
    }

    public void setAvailable(Book[] available) {
        this.available= available;
    }


    @Override
    public String toString() {
        return "availableBooks=" + Arrays.toString(available) + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Arrays.equals(available, library.available);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(available);
    }

    /**
     * This method will set the Information of books available in Library.
     */
    public void setBooksInLibrary() {
        available[0].setBookName("Ethics for a Whole World");
        available[0].setBookAuthorName("Dalai Lama");
        available[0].setIsbnNumber("9352836537000");
        available[1].setBookName("I Witness: Partial Observations");
        available[1].setBookAuthorName("Kapil Sibal");
        available[1].setIsbnNumber("9353062012000");
        available[2].setBookName("A Guide to Contentment");
        available[2].setBookAuthorName("Dalai Lama");
        available[2].setIsbnNumber("9789332582705");
        available[3].setBookName("2For the New Generation");
        available[3].setBookAuthorName("Kiran bedi");
        available[3].setIsbnNumber("9789388028028");
        available[4].setBookName("The Hanging of afzal Guru");
        available[4].setBookAuthorName("Arundhati Roy");
        available[4].setIsbnNumber("9351199258111");
    }

    /**
     * This method will show the Information of books available in Library.
     */
    public void showAvailableBooks() {
        System.out.println("****************************");
        System.out.printf("%-36s %-21s %-21s\n", "Book Name", "Author Name", "ISBN Number");
        System.out.println("*****************************");
        for (int libraryIndex = 0; libraryIndex < MAXIMUM_BOOKS_IN_LIBRARY; libraryIndex++) {
            System.out.printf("%-36s %-21s %-21s\n", available[libraryIndex].getBookName(), available[libraryIndex].getBookAuthor(), available[libraryIndex].getBookISBN());
        }
        System.out.println("****************************");
    }
}

