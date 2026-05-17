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
    public Compartment getComp(int compartmentIndex) {

        /***************************************************************
         * Checking if entered shelf index is valid
         **************************************************************/
        if (compartmentIndex < 0 || compartmentIndex >= 15) {
            throw new IndexOutOfBoundsException("Shelf index must be between 0 and 14: " 
                                                + compartmentIndex);
        } // END if (compartmentIndex < 0 || compartmentIndex >= 10)

        // Valid
        return row[compartmentIndex];
    } // END get
} // END class Shelf
