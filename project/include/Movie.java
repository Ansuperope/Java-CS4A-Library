/**
 * @file Movie.java
 * 
 * Derived class
 */
package project.include;
import project.include.LibraryItem;

public class Movie extends LibraryItem {
    private String title;
    private String director;
    private String mainActors;

    /**
     * @brief constructor
     * 
     * @param t title
     * @param d director
     * @param actors main actors
     * @param desc description
     */
    Movie (String t, String d, String actors, String desc) {
        super(t, desc);
        this.title = t;
        this.director = d;
        this.mainActors = actors;
    } // END Movie / constructor

    /**
     * @brief printing item contents
     */
    @Override
    public String toString() {
        String output =
            "Movie Title: "  + title + "\n" +
            "Director: "     + director + "\n" +
            "Main Actors: "  + mainActors + "\n" +
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

} // END class Movie