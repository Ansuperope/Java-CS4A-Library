/**
 * @file Book.java
 * 
 * Derived class
 */
package project.include;
import project.include.LibraryItem;

public class Book extends LibraryItem {
    private String title;
    private String author;
    private String copyrightDate;

    /**
     * @brief constructor
     * 
     * @param t title
     * @param a author
     * @param cd copyright date
     * @param desc description
     */
    Book(String t, String a, String cd, String desc) {
        super(t, desc);
        this.title = t;
        this.author = a;
        this.copyrightDate = cd;
    } // END Book / constructor

    /**
     * @brief printing item contents
     */
    @Override
    public String toString() {
        String output =
            "Book Title: "   + title + "\n" +
            "Author: "       + author + "\n" +
            "Copyright: "    + copyrightDate + "\n" +
            "Description: "  + this.description + "\n" +
            "ID: "           + this.id + "\n" +
            "Checked Out?: " + (this.isCheckedOut ? "Yes" : "No") + "\n";

        // IF CHECKED OUT PRINT CHECKOUT INFO
        if (this.isCheckedOut) {
            output +=
                "Checked Out By: "  + this.checkedOutName + "\n" +
                "Return Date: "     + this.returnDate + "\n";
        } // END if

        return output;
    } // END toString
    
} // END class Book