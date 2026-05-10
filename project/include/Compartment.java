/**
 * @file Compartment.java
 * 
 * @brief 
 */

package project.include;
import project.include.LibraryItem;

public class Compartment {
    private LibraryItem item;       // pointer for polymorphism
    private boolean occupied;       // compartment has objects in it
    private boolean isPlaceholder;  // prevent invalid indexes from being accepted

    /**
     * @brief constructor
     */
    Compartment () {
        this.item = null;
        this.occupied = false;
        this.isPlaceholder = false;
    } // END Compartment / constructor

    /**
     * @brief check if compartment is occupied
     */
    public boolean isOccupied() {
        return isPlaceholder ? false : occupied;
    } // END isOccupied()

    /**
     * @breif getter function, get item
     * 
     * @return item
     */
    public LibraryItem getItem() {
        return item;
    } // END getItem

    /**
     * @brief set placeholder to true
     */
    public void setPlaceholder() {
        isPlaceholder = true;
    } // END setPlaceholder

} // END class Compartment