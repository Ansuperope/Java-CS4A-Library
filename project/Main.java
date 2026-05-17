/**
 * @file Main.java
 * @brief LOREM
 * 
 * @details
 * LOREM
 */
package project;

// Include files from other folders
import project.include.Compartment;
import project.include.Library;
import project.include.LibraryItem;
import project.include.Shelf;
// Derived class
import project.include.Book;
import project.include.Movie;
import project.include.Magazine;

public class Main {
    public static void main(String[] args) {
        // Create Library object called libraryInventory
        Library libraryInventory = new Library();

        // Create a Book object
        LibraryItem book1 = new Book("To Kill a Mockingbird", 
            "Harper Lee", 
            "July 11, 1960", 
            "A novel that explores the themes of racial inequality, class and society, loss of innocence, and gender roles.");
	    
        // Create a Movie object
        LibraryItem movie1 = new Movie("The Force Awakens", 
            "J.J. Abrams", 
            "Daisy Ridley, John Boyega, Harrison Ford, Adam Driver", 
            "The seventh Star Wars movie, set thirty years after the Return of the Jedi.");

        // Create a Magazine object
        LibraryItem magazine1 = new Magazine(1, 
            "30 under 30", 
            "Forbes", 
            "A magazine by Forbes, showcasing 30 people under 30 years of age making advancements in their fields.");
        
        // Print current library libraryInventory
        System.out.println("Printing current library inventory with no items: ");
        System.out.println(libraryInventory);

        // Add object book1 to Library at Shelf 1, Compartment 1

        // Adding the object movie1 to the Library at Shelf 9, Compartment 14

        // Testing edge cases using magazine1
	    // Shelf accepts values ranging from 0-9, Compartment accepts values ranging from 0-14
        System.out.println("Testing edge cases for adding items: ");

        // Printing the current library inventory
        System.out.println("Printing current lirbary inventory with 2 checked-in items: ");


    } // END static main()
} // END class Main