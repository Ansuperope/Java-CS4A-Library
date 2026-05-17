/**
 * @file Library.java
 * Manager system. Constains a variety of shelves
 */
package project.include;
import project.include.Compartment;
import project.include.Shelf;
import project.include.LibraryItem;
import project.include.Book;
import project.include.Movie;
import project.include.Magazine;

public class Library {
    private Compartment[][] shelves;    //Standard Library Inventory

    /**
     * @brief Constructor
     */
    public Library() {
        shelves = new Compartment[10][15];

        /***************************************************************
         * INTIALIZE
         **************************************************************/
        for (int s = 0; s < 10; s++) {
            for (int c = 0; c < 15; c++) {
                shelves[s][c] = new Compartment();
            } // END (int c = 0; c < 15; c++)
        } // END (int s = 0; s < 10; s++)
    } // END Library / Constructor


    /**
     * @brief Helper function to check boundaries
     * @return true = valid, false = invalid
     * @param shelf shelf index
     * @param comp component index
     */
    public boolean isValidLocation(int shelf, int comp) {
        return shelf >= 0 && shelf < 10 &&
               comp >= 0 && comp < 15;
    } // END isValidLocation

    /**
     * @brief Prints all stored items
     */
    public String printLibrary() {

        StringBuilder sb = new StringBuilder();
        sb.append("All items currently checked into storage:\n");

        // Used to track if we found at least one checked-in item
        boolean found = false;

        /***************************************************************
         * LOOP THROUGH ALL SHELVES (0-9) AND COMPARTMENTS (0-14)
         **************************************************************/
        for (int s = 0; s < 10; s++) {
            for (int c = 0; c < 15; c++) {

                // Access the current compartment
                Compartment comp = shelves[s][c];

                // Skip this compartment if no item is stored here
                if (!comp.isOccupied()) {
                    continue;
                }

                // Retrieve the LibraryItem stored in this compartment
                LibraryItem item = comp.getItem();

                /*******************************************************
                 * Only print if the item exists
                 ******************************************************/
                if (item != null) {

                    found = true; // At least one checked-in item exists

                    // Print shelf and compartment location
                    sb.append("Shelf ")
                      .append(s)
                      .append(", Compartment ")
                      .append(c)
                      .append("\n");

                    // Print item details
                    sb.append(item)
                      .append("\n");

                    sb.append("-----------------------------\n");
                } // END if (item != null)

            } // END for (int c = 0; c < 15; c++)
        } // END (int s = 0; s < 10; s++)

        /***************************************************************
         * If no checked-in items were found, notify the user
         **************************************************************/
        if (!found) {
            sb.append("No items are currently checked into storage.\n");
        } // END if (!found)

        return sb.toString();
    } // END printLibrary

    /**
     * @brief Prints checked out items
     */
    public String printCheckedOutItems() {

        StringBuilder sb = new StringBuilder();
        sb.append("All items currently checked out:\n");

        // Used to track if we found at least one checked-out item
        boolean found = false;

        /***************************************************************
         * LOOP THROUGH ALL SHELVES (0-9) AND COMPARTMENTS (0-14)
         **************************************************************/
        for (int s = 0; s < 10; s++) {
            for (int c = 0; c < 15; c++) {

                // Access the current compartment
                Compartment comp = shelves[s][c];

                // Skip this compartment if no item is stored here
                if (!comp.isOccupied()) {
                    continue;
                }

                // Retrieve the LibraryItem stored in this compartment
                LibraryItem item = comp.getItem();

                /*******************************************************
                 * Only print if the item exists
                 ******************************************************/
                if (item != null && item.getCheckedOut()) {

                    found = true;

                    sb.append("Shelf ")
                      .append(s)
                      .append(", Compartment ")
                      .append(c)
                      .append("\n");

                    sb.append("Name: ")
                      .append(item.getName())
                      .append("\n");

                    sb.append("Checked Out By: ")
                      .append(item.getCheckedOutName())
                      .append("\n");

                    sb.append("Return Date: ")
                      .append(item.getReturnDate())
                      .append("\n");

                    sb.append("-----------------------------\n");
                } // END if (item != null && item.getCheckedOut())

            } // END for (int c = 0; c < 15; c++)
        } // END for (int s = 0; s < 10; s++)

        /***************************************************************
         * If no checked-out items were found, notify the user
         **************************************************************/
        if (!found) {
            sb.append("No items are currently checked out.\n");
        } // END if (!found)

        return sb.toString();
    } // END printCheckedOutItems

    /**
     * @brief Swap two compartments
     * @param cell1 compartment 1
     * @param cell2 compartment 2
     */
    public void swap(Compartment cell1, Compartment cell2) {

        /***************************************************************
         * Check that both compartments are occupied before swapping
         **************************************************************/
        if (!cell1.isOccupied() || !cell2.isOccupied()) {
            System.out.println("Error: One or both compartments are empty.");
            return;
        } // END (!cell1.isOccupied() || !cell2.isOccupied())

        //Get the LibraryItem stored at each Compartment
        LibraryItem item1 = cell1.getItem();
        LibraryItem item2 = cell2.getItem();

        /***************************************************************
         * Check that both compartments have items not checked out
         **************************************************************/
        if (item1.getCheckedOut() || item2.getCheckedOut()) {

            //Error message displays depending on which Compartment was invalid

            // Compartment 1 Invalid
            if (item1.getCheckedOut()) {
                System.out.println("Error: Cannot swap " + 
                                    item1.getName() +
                                    " as it is checked out.");
            } // END (item1.isCheckedOut())

            // Compartment 1 Invalid
            if (item2.getCheckedOut()) {
                System.out.println("Error: Cannot swap " +
                                    item2.getName() +
                                    " as it is checked out.");
            } // END (item1.isCheckedOut())

            return;
        } // END (item1.getCheckedOut() || item2.getCheckedOut())

        // Swap items
        cell1.setItem(item2);
        cell2.setItem(item1);

        System.out.println("Items swapped successfully.");
    } // END swap

    /**
     * @brief Returns a shelf
     * @param shelfIndex index to print
     */
    public Shelf getShelf (int shelfIndex) {

        /***************************************************************
         * Checking if entered shelf index is valid
         **************************************************************/
        if (shelfIndex < 0 || shelfIndex >= 10) {
            System.out.println("Error: Shelf index must be between 0 and 9.");
            return null;
        } // END if (shelfIndex < 0 || shelfIndex >= 10)

        return new Shelf(shelves[shelfIndex]);
    } // END getShelf

    /**
     * @brief Default printing library
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        /***************************************************************
         * Print shelf
         **************************************************************/
        for (int s = 0; s < 10; s++) {

            sb.append("Shelf ")
              .append(s)
              .append(":\n");

            /***********************************************************
             * Print compartment
             **********************************************************/
            for (int c = 0; c < 15; c++) {

                sb.append("  Compartment ")
                  .append(c)
                  .append(": ")
                  .append(shelves[s][c])
                  .append("\n");
            } // END for (int c = 0; c < 15; c++)

            sb.append("\n");
        } // END for (int s = 0; s < 10; s++)

        return sb.toString();
    } // END toString

} // END class Library