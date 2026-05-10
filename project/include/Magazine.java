/**
 * @file Magazine.java
 * 
 * Derived class
 */
package project.include;
import project.include.LibraryItem;

public class Magazine extends LibraryItem {
    private int edition;
    private String mainArticle;

    /**
     * @brief constructor
     * 
     * @param ed edition
     * @param article main article
     * @param nm name
     * @param desc description
     */
    Magazine (int ed, String article, String nm, String desc) {
        super(nm, desc);
        this.edition = ed;
        this.mainArticle = article;
    } // END Magazine / constructor

    
} // END class Magazine