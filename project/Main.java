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

        // Print Checked out items from library libraryInventory
        System.out.println("Printing current library inventory checked out: ");
        System.out.println(libraryInventory.printCheckedOutItems());

        // Add object book1 to Library at Shelf 1, Compartment 1
        libraryInventory.getShelf(0).getComp(0).addItem(book1);

        // Adding the object movie1 to the Library at Shelf 9, Compartment 14
        libraryInventory.getShelf(9).getComp(14).addItem(movie1);

        // Testing edge cases using magazine1
	    // Shelf accepts values ranging from 0-9, Compartment accepts values ranging from 0-14
        System.out.println("Testing edge cases for adding items:\n");

        try {
            System.out.println("Invalid shelf (-1): ");
            libraryInventory.getShelf(-1).getComp(0).addItem(magazine1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nInvalid compartment (-1): ");
            libraryInventory.getShelf(0).getComp(-1).addItem(magazine1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nInvalid shelf (-2) and compartment (-2): ");
            libraryInventory.getShelf(-2).getComp(-2).addItem(magazine1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nInvalid shelf (10): ");
            libraryInventory.getShelf(10).getComp(0).addItem(magazine1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nInvalid compartment (15): ");
            libraryInventory.getShelf(0).getComp(15).addItem(magazine1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nInvalid shelf (11) and compartment (16): ");
            libraryInventory.getShelf(11).getComp(16).addItem(magazine1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        // Printing the current library inventory
        System.out.println("\nPrinting current library inventory with 2 checked-in items: ");
        System.out.println(libraryInventory.printLibrary());
        System.out.println(libraryInventory.printCheckedOutItems());

        //Checking out an item using invalid shelf/compartment values
        System.out.println("\nChecking out items using invalid shelf/compartment values:\n");

        try {
            libraryInventory.getShelf(-1).getComp(0).checkoutItem("Matthew Contreras", "12/20/25");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            libraryInventory.getShelf(0).getComp(-1).checkoutItem("Adam Zeidan", "12/25/25");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            libraryInventory.getShelf(-2).getComp(-2).checkoutItem("Saddleback College", "12/30/25");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            libraryInventory.getShelf(10).getComp(0).checkoutItem("Kevin Ford", "1/25/26");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            libraryInventory.getShelf(0).getComp(15).checkoutItem("Timothy Nguyen", "1/10/26");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            libraryInventory.getShelf(11).getComp(16).checkoutItem("Irvine Valley College", "1/20/26");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        //Checking out book1
        System.out.println("\nChecking out a book: ");
        libraryInventory.getShelf(0).getComp(0).checkoutItem("Christian Metoyer", "11/30/25");

        //Printing the current library inventory
        System.out.println("\nPrinting current library inventory with 1 checked-in, 1 checked-out item:");
        System.out.println(libraryInventory.printLibrary());
        System.out.println(libraryInventory.printCheckedOutItems());

        //Checking out movie1
        System.out.println("\nChecking out a movie: ");
        libraryInventory.getShelf(9).getComp(14).checkoutItem("UC Irvine", "12/31/25");

        
        //Printing the current library inventory
        System.out.println("\nPrinting current library inventory with 2 checked-out item:");
        System.out.println(libraryInventory.printLibrary());
        System.out.println(libraryInventory.printCheckedOutItems());

    } // END static main()
} // END class Main