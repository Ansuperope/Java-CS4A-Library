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

    Movie (String t, String d, String actors, String desc) {
        super(t, desc);
        this.title = t;
        this.director = d;
        this.mainActors = actors;
    } // END Movie / constructor

} // END class Movie