/*  Created by IntelliJ IDEA.
 *  User: Divyansh Bhardwaj (dbc2201)
 *  Date: 21/08/20
 *  Time: 3:49 PM
 *  File Name : Student.java
 * */
package definitions;

import java.util.Arrays;
import java.util.Objects;

public class Student {
    private static final int MAXIMUM_BOOKS_STUDENT_CAN_ISSUE = 5;
    private String studentFirstName;
    private String studentMiddleName;
    private String studentLastName;
    private long studentUniversityRollNumber;
    private int numberOfBooksIssued;
    private Book[] namesOfBooksIssuedByStudent;

    public Student() {
        this.studentFirstName = "vaidik";
        this.studentMiddleName = "";
        this.studentLastName = "nigam";
        this.studentUniversityRollNumber = 191500892;
        this.numberOfBooksIssued = 5;
        this.namesOfBooksIssuedByStudent = new Book[MAXIMUM_BOOKS_STUDENT_CAN_ISSUE];
        for (int i = 0; i < MAXIMUM_BOOKS_STUDENT_CAN_ISSUE; i++) {
            namesOfBooksIssuedByStudent[i] = new Book();
        }
    }


    public Student(String studentName, long studentUniversityRollNumber, int numberOfBooksIssued, Book[] namesOfBooksIssuedByStudent) {
        this.studentFirstName = studentFirstName;
        this.studentMiddleName = studentMiddleName;
        this.studentLastName = studentLastName;
        this.studentUniversityRollNumber = studentUniversityRollNumber;
        this.numberOfBooksIssued = numberOfBooksIssued;
        this.namesOfBooksIssuedByStudent = namesOfBooksIssuedByStudent;
    }

    public Book[] getNamesOfBooksIssuedByStudent() {
        return namesOfBooksIssuedByStudent;
    }

    public void setNamesOfBooksIssuedByStudent(Book[] namesOfBooksIssuedByStudent) {
        this.namesOfBooksIssuedByStudent = namesOfBooksIssuedByStudent;
    }
    public boolean returnBook(String bookName) {
        boolean returnSuccessful = false;
        int returnBookIndex = 0;
        for (int tempIndex = 0; tempIndex < MAXIMUM_BOOKS_STUDENT_CAN_ISSUE; tempIndex++) {
            if (bookName.equals(namesOfBooksIssuedByStudent[tempIndex].getBookName())) {
                returnSuccessful = true;
                returnBookIndex = tempIndex;
                setNumberOfBooksIssued(getNumberOfBooksIssued() - 1);
                break;
            }
        }
        if (returnSuccessful) {
            namesOfBooksIssuedByStudent[returnBookIndex].setBookName(null);
        } else {
            System.out.println("Please Enter the correct book name.");
        }
        return returnSuccessful;
    }

    /**
     * This method will allow show the names of all all issued books .
     */
    public void listOfIssuedBooks() {
        for (Book book : this.namesOfBooksIssuedByStudent) {
            System.out.println(book);
        }
    }

    public String getStudentFirstNameName() {
        return studentFirstName;
    }
    public String getStudentMiddleName(){
        return studentMiddleName;
    }
    public String getStudentLastName(){
        return studentLastName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }
    public void setStudentMiddleName(String studentMiddleName) {
        this.studentMiddleName = studentMiddleName;
    }
    public void setStudentLastName(String studentLastName){
        this.studentLastName = studentLastName;
    }

    public long getStudentUniversityRollNumber() {
        return studentUniversityRollNumber;
    }

    public void setStudentUniversityRollNumber(long studentUniversityRollNumber) {
        this.studentUniversityRollNumber = studentUniversityRollNumber;
    }

    public int getNumberOfBooksIssued() {
        return numberOfBooksIssued;
    }

    public void setNumberOfBooksIssued(int numberOfBooksIssued) {
        this.numberOfBooksIssued = numberOfBooksIssued;
    }

    @Override
    public String toString() {
        return "studentFirstName='" + studentFirstName + '\'' +
                "studentMiddleName='" + studentMiddleName + '\'' +
                "studentLastName='" + studentLastName + '\'' +
                ", studentUniversityRollNumber=" + studentUniversityRollNumber +
                ", numberOfBooksIssued=" + numberOfBooksIssued +
                ", namesOfBooksIssuedByStudent=" + Arrays.toString(namesOfBooksIssuedByStudent) + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentUniversityRollNumber == student.studentUniversityRollNumber &&
                numberOfBooksIssued == student.numberOfBooksIssued &&
                Objects.equals(studentFirstName, student.studentFirstName) &&
                Objects.equals(studentMiddleName, student.studentMiddleName) &&
                Objects.equals(studentLastName, student.studentLastName) &&
                Arrays.equals(namesOfBooksIssuedByStudent, student.namesOfBooksIssuedByStudent);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(studentFirstName,studentMiddleName,studentLastName, studentUniversityRollNumber, numberOfBooksIssued);
        result = 31 * result + Arrays.hashCode(namesOfBooksIssuedByStudent);
        return result;
    }

    /**
     * This method will issue the books to the Student
     *
     * @param bookIssuingIndex The index where the book is issueing.
     * @param bookName         The name of the book which is issuing.
     */
    public void issueBooksToStudents(int bookIssuingIndex, String bookName) {
        namesOfBooksIssuedByStudent[bookIssuingIndex].setBookName(bookName);
    }

    /**
     * This method will show all the books which is issued by the Student.
     */
    public void showIssuedBooksByStudent() {
        if (getNumberOfBooksIssued() == 0) {
            System.out.println("Sorry, you haven't issued any book yet.");
        } else {
            System.out.println("These are the books issued by you: ");
            for (int issuedBookIndex = 0; issuedBookIndex < MAXIMUM_BOOKS_STUDENT_CAN_ISSUE; issuedBookIndex++) {
                if (namesOfBooksIssuedByStudent[issuedBookIndex].getBookName() != null) {
                    System.out.print(namesOfBooksIssuedByStudent[issuedBookIndex].getBookName() + (issuedBookIndex < getNumberOfBooksIssued() - 1 ? ", " : ".\n"));
                }
            }
        }
    }

}
