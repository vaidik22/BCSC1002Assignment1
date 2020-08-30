/*  Created by IntelliJ IDEA.
 *  User: Divyansh Bhardwaj (dbc2201)
 *  Date: 21/08/20
 *  Time: 3:49 PM
 *  File Name : Book.java
 * */
package definitions;

import java.util.Objects;

public class Book {
    private String bookName;
    private String bookAuthor;
    private String bookISBN;

    public Book() {
        this.bookName = null;
        this.bookAuthor = null;
        this.bookISBN = null;
    }

    public Book(String bookName, String bookAuthorName, String isbnNumber) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthorName;
        this.bookISBN = isbnNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthorName(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setIsbnNumber(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String toString() {
        return "Book Name" + getBookName() + "," +
                "Authors Name" + getBookAuthor() + "," +
                "ISBN Number" + getBookISBN() + ".";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookName, book.bookName) &&
                Objects.equals(bookAuthor, book.bookAuthor) &&
                Objects.equals(bookISBN, book.bookISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, bookAuthor, bookISBN);
    }

}
