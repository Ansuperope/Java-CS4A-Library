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
    
} // END class Book