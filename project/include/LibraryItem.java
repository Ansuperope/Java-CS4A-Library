/**
 * @file LiraryItem.java
 * 
 * Abstract base class. No destructor since java does it automatically
 */
package project.include;

public abstract class LibraryItem {
    private int idCount;            // number of objects made?
    
    protected String name;            // item name
    protected String description;     // item description
    protected int id;                 // item id (like isbn?)
    protected boolean isCheckedOut;   // if item was checked out
    protected String checkedOutName;  // who checked out item
    protected String returnDate;      // date to return item
    
    /**
     * @brief constructor
     * 
     * @param nm name of item
     * @param desc item description
     */
    LibraryItem(String nm, String desc) {
        this.name = nm;
        this.description = desc;
        this.id = idCount++;
        this.isCheckedOut = false;
        this.checkedOutName = "";
        this.returnDate = "";
    } // END constructor

    /**
     * @brief getter for isCheckedOut
     * @return if checked out (true or false)
     */
    public boolean getCheckedOut() { return isCheckedOut; } 

    /**
     * @brief getter for name
     * @return name
     */
    public String getName() { return name; }

    /**
     * @brief getter for returnDate
     * @return return date
     */
    public String getReturnDate() { return returnDate; }

    /**
     * @brief getter for checkedOutName
     * @return name of who checked it out
     */
    public String getCheckedOutName() { return checkedOutName; }

    /**
     * @brief setter for checking out an item
     */
    public void checkOutItem(String person, String date) {
        isCheckedOut = true;
        checkedOutName = person;
        returnDate = date;
    } // END checkOutItem

    /**
     * @brief setter for returning an item
     */
    public void returnItem() {
        isCheckedOut = false;
        checkedOutName = "";
        returnDate = "";
    } // END returnItem
    
} // END class LibraryItem