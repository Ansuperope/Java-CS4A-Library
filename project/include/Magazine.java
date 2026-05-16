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

    /**
     * @brief printing item contents
     */
    @Override
    public String toString() {
        String output =
            "Magazine Title: "  + this.name + "\n" +
            "Edition: "         + edition + "\n" +
            "Main Article: "    + mainArticle + "\n" +
            "Description: "     + this.description + "\n" +
            "ID: "              + this.id + "\n" +
            "Checked Out?: "    + (this.isCheckedOut ? "Yes" : "No") + "\n";

        // IF CHECKED OUT PRINT CHECKOUT INFO
        if (this.isCheckedOut) {
            output +=
                "Checked Out By: "  + this.checkedOutName + "\n" +
                "Return Date: "     + this.returnDate + "\n";
        } // END if

        return output;
    } // END toString

} // END class Magazine