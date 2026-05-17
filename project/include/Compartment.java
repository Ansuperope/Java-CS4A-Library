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
     * @brief Accessor: check if compartment is occupied
     * @return true = occupied, false = free
     */
    public boolean isOccupied() {
        return isPlaceholder ? false : occupied;
    } // END isOccupied()

    /**
     * @breif Accessor: get item
     * 
     * @return item
     */
    public LibraryItem getItem() {
        return item;
    } // END getItem

    /**
     * @brief Accessor placeholder to true
     */
    public void setPlaceholder() {
        isPlaceholder = true;
    } // END setPlaceholder

    /**
     * @brief Add LibraryItem object
     */
    public void addItem(LibraryItem newItem) {
        // CHECK IF VALID INDEX ENTERED
        if (isPlaceholder) {
            return;
        } // END if

        // CHECK IF NULL 
        if (newItem == null) {
            return;
        } // END if

        // CHECK IF OCCUPIED
        if (occupied) {
            System.out.println("Error! Compartment already occupied.");
            return;
        } // END if

        // ALL CHECKS PASSED - ADD ITEM
        item = newItem;
        occupied = true;
    } // END addItem

    /**
     * @brief checks out an item
     * @param person Person checking out item
     * @param date date of checkout
     */
    public void checkoutItem (String person, String date) {
        // CHECKS INDEX
        if (isPlaceholder) {
            return;
        } // END if

        // CHECKS IF UNOCCUPIED
        if (!occupied || item == null) {
            System.out.println("Error! Compartment is empty.");
            return;
        } // END if

        // CHECKS IF ALREADY CHECKED OUT
        if (item.getCheckedOut()) {
            System.out.println("Error! Item already checked out.");
            return;
        } // END if

        // ALL TESTS PASSED - CHECK OUT ITEM
        item.checkoutItem(person, date);
        System.out.println(item.getName() + " successfully checked out.");
    } // END checkoutItem

    /**
     * @brief return item that was checked out
     */
    public void returnItem () {
        // CHECK INDEX
        if(isPlaceholder) {
            return;
        } // END if

        // CHECK IF EMPTY
        if (!occupied || item == null) {
            System.out.println("Error! Compartment is empty.");
            return;
        } // END if

        // CHECK IF NOT CHECKED OUT
        if (!item.getCheckedOut()) {
            System.out.println("Error! Item is not checked out.");
            return;
        } // END if

        // ALL CHECKS PASSED - RETURN ITEM
        item.returnItem();
        System.out.println(item.getName() + " successfully returned.");
    } // END returnItem

    /**
     * @brief set item
     * @param it item we are setting
     */
    public void setItem (LibraryItem it) {

        // Won't continue if invalid placeholder
        if (isPlaceholder) {
            return;
        } // END if

        // Set item accordingly
        item = it;
        occupied = (it != null);
    } // END setItem

    /**
     * @brief Used to delete items
     */
    public void clear() {
        //Nothing to delete if invalid index
        if (isPlaceholder) {
            return;
        } // END if

        //Successfully deletes an item if it exists
        item = null;
        occupied = false;
    } // END clear

    /**
     * @brief output
     */
    @Override
    public String toString() {
        // CHECK INDEX
        if (isPlaceholder) {
            return "[INVALID]";
        }
        // CHECK IF EMPTY
        else if (!occupied || item == null) {
            return "[EMPTY]";
        }
        // OUTPUT ITEM DETAILS
        else {
            return item.toString();
        }
    } // END toString

} // END class Compartment