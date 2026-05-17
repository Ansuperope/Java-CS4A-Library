/**
 * @file Shelf.java
 * Stores compartments
 */
package project.include;
import project.include.Compartment;

public class Shelf {
    // row of 15 Compartment objects
    private Compartment[] row;
    
    /*******************************************************************
     * @brief constructor
     ******************************************************************/
    public Shelf (Compartment[] inRow) {
        this.row = inRow;
    } // END Shelf / constructor

    /**
     * @brief Returns a compartment at the given index
     * @param compartmentIndex index to check
     */
    public Compartment get(int compartmentIndex) {

        // Test for invalid compartment indexes
        if (compartmentIndex < 0 || compartmentIndex >= 15) {

            System.out.println("Error: Compartment index must be between 0 and 14. "
                                + compartmentIndex + " is invalid.");

            // Dummy compartment returned if invalid
            Compartment invalidCompartmentIndex = new Compartment();
            invalidCompartmentIndex.setPlaceholder();

            return invalidCompartmentIndex;
        } // END if

        // Valid
        return row[compartmentIndex];
    } // END get
} // END class Shelf
