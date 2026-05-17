[![Java CI](https://github.com/Ansuperope/Java-CS4A-Library/actions/workflows/java.yml/badge.svg)](https://github.com/Ansuperope/Java-CS4A-Library/actions/workflows/java.yml)
[![Documentation](https://img.shields.io/badge/Documentation-Doxygen-blue?logo=doxygen)](https://ansuperope.github.io/Java-CS4A-Library/)

# Library Inventory System Design and Implementation

**DONT COUT FOR EXCEPTION HANDLING INSTEAD USE THROW**

You are tasked with designing and implementing a Library Inventory
System that manages the storage and checkout of items in a library. The
system must adhere to the following specifications and constraints:

## Storage System

1\. Structure:  
- The library storage is modeled using **shelves**, where:  
- Each shelf contains up to 15 **compartments**.  
- Each compartment can hold a single item.  
2. Access:  
- Implement the system so that it supports the **\[\]** **operator** for
accessing items.  
- For example, if the library storage is represented by a variable
libraryInventory, you should be able to access the fifth compartment on
the third shelf using: libraryInventory\[2\]\[4\].

## Items in the Library

1\. General Structure:  
- All items should have the following properties:  
~~- **name**: Name of the item.  
- **description**: Description of the item.  
- **id**: Unique identifier for the item.  
  
2. Specific Item Types:  
- <u>Books:</u>  
- **Additional properties:** title, author, and copyrightDate.  
- <u>Movies:</u>  
- **Additional properties:** title, director, and a collection of
mainActors.  
- <u>Magazines:</u>  
- **Additional properties:** edition and the title of the main
article.  
  
3. Operator Overloading:  
- Overload the **\<\< operator** to display the details of each type of
item.~~

## System Operations

1\. Add an Item:  
- Add an item to the storage system at a specific shelf and compartment
location.  
  
2. Check out an Item:  
- Allow a person to check out an item from a specific compartment.  
- When checked out:  
- Record the name of the person who checked out the item.  
- Record the due date for returning the item.  
  
3. Return an Item:  
- Allow a person to return an item to its original compartment.  
  
4. Print Items in Storage:  
- Print all items that are currently checked into storage, displaying
their shelf and compartment locations.  
  
5. Print Checked-Out Items:  
- Print all items that are currently checked out, along with:  
- The name of the person who checked them out.  
- Their due date.  
  
6. Swap Items:  
- Swap the contents of two compartments in the library storage.  
- Ensure there is an item in both compartments before performing the
swap.

## Requirements

1\. Use classes to model the storage system, items, and operations.
Organize your code in a clean and modular fashion.  
2. Ensure proper handling of edge cases, such as:  
- Attempting to access compartments or shelves that do not exist.  
- Attempting to check out, check in, or swap items when a compartment is
empty.  
3. Demonstrate object-oriented programming principles, including:  
- Encapsulation.  
- Inheritance (for the item types).  
- Polymorphism (where applicable).  
4. Include appropriate input validation and error messages for invalid
operations.

## What You Must Submit

1\. Class Definitions:  
- Define all necessary classes (e.g., LibraryStorage, Item, Book, Movie,
Magazine, etc.).  
  
2. Implementation:  
- Implement the functionality described above, including operator
overloads.  
  
3. Testing Code:  
- Write a main function to test your library system:  
- Add items to storage.  
- Check out and check in items.  
- Print the current state of the storage and checked-out items.  
- Perform a swap operation and demonstrate error handling.

## Evaluation Criteria

\- Correctness:  
- Does the system correctly implement the described functionality?  
- Code Quality:  
- Is the code well-organized, readable, and adherent to OOP
principles?  
- Testing:  
- Does the testing code cover all edge cases and demonstrate the
functionality of the system?

Game Plan

<img src="assets/media/image1.png" style="width:6in;height:4.94978in" />

- This visual represents a **library** containing **10 shelves** with
  **15 compartments** per shelf

- There are 2 objects here: the **library** and the **compartment**

  - Each **library** holds **10 shelves**

    - Each **Shelf** holds **15 compartments**

      - Each **compartment** holds an item of **LibraryItem** type,
        which can be:

        - **Book**

        - **Movie**

        - **Magazine**

- Each **library** object contains the following:

  - Attributes:

    - One **2D array** of **compartment** objects, representing the **10
      shelves** (the rows) and **15 compartments** (the columns)

  - Functions/Operators:

    - Overloaded \<\< operator displays the entire **library**; this can
      involve calling the overloaded \<\< operators of the
      **compartment**, and **LibraryItem** classes (this will serve as
      our print function)

    - Overloaded \[\] operator accesses a specific **compartment**
      (i.e., **library\[0\]\[0\]** would access the **LibraryItem** at
      **shelf \#1** and **compartment \#1**, while
      **library\[9\]\[14\]** would access the **LibraryItem** at **shelf
      \#9** and **compartment \#14**); because the **library** only has
      **10 shelves** and **15 compartments**, this value can only range
      from **0-9 for the shelves** and **0-14 for the compartments**

    - A **swap** function that swaps the position of two
      **LibraryItems**

      - Prerequisites: the **isOccupied compartment** bool is true, and
        the **isCheckedOut LibraryItem** bool is false

        - If one of these prerequisites fails when the **swap** function
          is called, print an error message stating which prerequisite
          failed

      - Has 4 parameters:

        - Param 1 (int): The shelf of the first LibraryItem

        - Param 2 (int): The compartment of the first LibraryItem

        - Param 3 (int): The shelf of the second LibraryItem

        - Param 4 (int): The compartment of the second LibraryItem

    - An **addItem** function that allows you to create a new
      **LibraryItem** in a certain compartment

      - Prerequisite: the **isOccupied compartment** bool is false

        - If this prerequisite fails when the **addItem** function is
          called, print an error message stating why it has failed

      - Has 3 common parameters:

        - Param 1 (int): The shelf where you want to add a LibraryItem

        - Param 2 (int): The compartment where you want to add a
          LibraryItem

        - Param 3 (int): A 1, 2, or 3, depending on if the user wants to
          add a book (enter 1), movie (enter 2), or magazine (enter 3)

      - If the user wants to add a **Book**:

        - Param 4 (string): title of the book

        - Param 5 (string): author of the book

        - Param 6 (string) copyright date in the MM/DD/YYYY format

      - If the user wants to add a **Movie**:

        - Param 4 (string): title of the movie

        - Param 5 (string): director of the movie

        - Param 6 (string): a list of the main actors of the movie

      - If the user wants to add a **Magazine**:

        - Param 4 (int): edition of the magazine

        - Param 5 (string): title of the main article

      - Note: We can use 3 overloaded **addItem** functions to
        accommodate the 3 types of **LibraryItem** objects

      - If the **addItem** function is successful, the item will be
        added to that location in the **library**, the **isOccupied
        compartment** bool will be set to true, and the **isCheckedOut
        LibraryItem** bool will be set to false

    - A **checkoutItem** function that allows you to check out a
      **LibraryItem** in a certain **compartment**

      - Prerequisites: the **isOccupied compartment** bool is true, and
        the **isCheckedOut LibraryItem** bool is false

        - If one of these prerequisites fails when the **checkoutItem**
          function is called, print an error message stating which
          prerequisite failed

      - Has three parameters:

        - Param 1 (int): The shelf where you want to check out an item

        - Param 2 (int): The compartment where you want to check out an
          item

        - Param 3 (string): The name of the person checking out the item

      - If the **checkedItem** function is successful, the item will be
        checked out from that location in the library, the
        **isCheckedOut LibraryItem** bool will be false, the string
        entered for Param 3 will be stored in the **checkedOutName
        LibraryItem** string, and the **returnDate LibraryItem** string
        will be automatically set

    - A **returnItem** function that allows you to return a LibraryItem
      in a certain compartment

      - Prerequisites: the **isOccupied compartment** bool is true, and
        the **isCheckedOut LibraryItem** bool is true

        - If one of these prerequisites fails when the **returnItem**
          function is called, print an error message stating which
          prerequisite failed

      - Has two parameters:

        - Param 1 (string): The name of the item being returned

        - Param 2 (string): The name of the person returning the item

      - If the **returnItem** function is successful, the **isCheckedOut
        LibraryItem** bool will be false, the **checkedOutName
        LibraryItem** string will be blank, and the **returnDate
        LibraryItem** string will be blank

    - A **printCheckedOut** function that prints all items currently
      checked out

      - For an item to be considered “checked out,” the **isOccupied
        compartment** bool is true and the **isCheckedOut LibraryItem**
        bool is false

      - This function could simply be a nested for-loop that goes shelf
        by she

<!-- -->

- Each **compartment** contains the following:

  - Attributes:

    - **isOccupied** (bool); true if there is a **LibraryItem** stored
      at that compartment, false if not

    - **LibraryItem** object; can be a **Book**, **Movie**, or
      **Magazine**

  - This class will have an overloaded \<\< operator

    - If there is no item stored in that compartment, a message will
      display “Compart x on shelf y is unoccupied.”

    - If there is an item stored in that compartment, call the \<\<
      operator on the **LibraryItem**

- Each **LibraryItem** contains the following:

  - Attributes:

    - **name** (string); the name of the item

    - **description** (string); a description of the item

    - **id** (int); a unique identifier for the item

    - **isCheckedOut** (bool); true if the item is checked out, false if
      not

    - **checkedOutName** (string); blank if isCheckedOut is false,
      contains a name if isCheckedOut is true

    - **returnDate** (string); blank is isCheckedOut is false, contains
      a date in the format MM/DD/YYYY if isCheckedOut is true

  - Operators:

    - Overloaded \<\< operator that prints the name and description of
      an item

- Each **Book** contains the following:

  - Attributes:

    - **title** (string); the title of the book

    - **author** (string); the author of the book

    - **copyrightDate** (string); the copyright date of the book in the
      MM/DD/YYYY format

  - Functions/Operators

    - Overloaded \<\< operator that displays the **title**, **author**,
      **copyrightDate**, and **description** of the **Book**

- Each **Movie** contains the following:

  - Attributes:

    - **title** (string); the title of the movie

    - **director** (string); the director of the movie

    - **mainActors** (string); a string containing the names of the main
      actors

  - Functions/Operators

    - Overloaded \<\< operator that displays the **title**,
      **director**, **mainActors**, and **description** of the **Movie**

- Each **Magazine** contains the following:

  - Attributes:

    - **edition** (int); the edition of the magazine

    - **mainArticle** (string); the title of the main article

  - Functions/Operators

    - Overloaded \<\< operator that displays the **name**, **edition**,
      **mainArticle**, and **description** of the **Magazine**

- **Note**: for all **Book** and **Movie** objects, the name and title
  should be the same

- **Note**: because we need to demonstrate polymorphism, we need to use
  dynamically allocated memory to create all of our objects in the
  **library**

  - **LibraryItem** b1 = new **Book**();

- Because of this, we will also need to figure out a way to call the
  delete keyword for each object we create dynamically. Can someone come
  up with an idea and write it down?

NOTES:

Associate the checkout person’s name and return date with the
compartment because it would be assigned to the book and to the item

Rename the LibraryProxy class to “shelf” or something like that

“Structure looks pretty good”

NOTES from 11/24:

Exception handling

Source.cpp

\#include \<iostream\>

\#include "Library.h"

\#include "LibraryItem.h"

\#include "Shelf.h"

\#include "Compartment.h"

\#include "Book.h"

\#include "Movie.h"

\#include "Magazine.h"

int main()

{

//Creates a Library object called libraryInventory

Library libraryInventory;

//Creating a Book, Movie, and Magazine object

LibraryItem\* book1 = new Book("To Kill a Mockingbird", "Harper Lee",
"July 11, 1960", "A novel that explores the themes of racial inequality,
class and society, loss of innocence, and gender roles.");

LibraryItem\* movie1 = new Movie("The Force Awakens", "J.J. Abrams",
"Daisy Ridley, John Boyega, Harrison Ford, Adam Driver", "The seventh
Star Wars movie, set thirty years after the Return of the Jedi.");

LibraryItem\* magazine1 = new Magazine(1, "30 under 30", "Forbes", "A
magazine by Forbes, showcasing 30 people under 30 years of age making
advancements in their fields.");

//Printing the current library inventory

std::cout \<\< "\nPrinting current library inventory with no
items:\n\n";

libraryInventory.printLibrary(std::cout);

std::cout \<\< std::endl;

libraryInventory.printCheckedOutItems(std::cout);

//Adding the object book1 to the Library at Shelf 1, Compartment 1

libraryInventory\[0\]\[0\].addItem(book1);

//Adding the object movie1 to the Library at Shelf 9, Compartment 14

libraryInventory\[9\]\[14\].addItem(movie1);

//Testing edge cases using magazine1

//Shelf accepts values ranging from 0-9, Compartment accepts values
ranging from 0-14

std::cout \<\< "\n\n\nTesting edge cases for adding items:\n\n";

libraryInventory\[-1\]\[0\].addItem(magazine1);

std::cout \<\< std::endl;

libraryInventory\[0\]\[-1\].addItem(magazine1);

std::cout \<\< std::endl;

libraryInventory\[-2\]\[-2\].addItem(magazine1);

std::cout \<\< std::endl;

libraryInventory\[10\]\[0\].addItem(magazine1);

std::cout \<\< std::endl;

libraryInventory\[0\]\[15\].addItem(magazine1);

std::cout \<\< std::endl;

libraryInventory\[11\]\[16\].addItem(magazine1);

//Printing the current library inventory

std::cout \<\< "\n\n\nPrinting current library inventory with 2
checked-in items:\n\n";

libraryInventory.printLibrary(std::cout);

std::cout \<\< std::endl;

libraryInventory.printCheckedOutItems(std::cout);

//Checking out an item using invalid shelf/compartment values

std::cout \<\< "\n\n\nChecking out items using invalid shelf/compartment
values:\n\n";

libraryInventory\[-1\]\[0\].checkoutItem("Matthew Contreras",
"12/20/25");

std::cout \<\< std::endl;

libraryInventory\[0\]\[-1\].checkoutItem("Adam Zeidan", "12/25/25");

std::cout \<\< std::endl;

libraryInventory\[-2\]\[-2\].checkoutItem("Saddleback College",
"12/30/25");

std::cout \<\< std::endl;

libraryInventory\[10\]\[0\].checkoutItem("Kevin Ford", "1/25/26");

std::cout \<\< std::endl;

libraryInventory\[0\]\[15\].checkoutItem("Timothy Nguyen", "1/10/26");

std::cout \<\< std::endl;

libraryInventory\[11\]\[16\].checkoutItem("Irvine Valley College",
"1/20/26");

//Checking out book1

std::cout \<\< "\n\n\nChecking out a book:\n\n";

libraryInventory\[0\]\[0\].checkoutItem("Christian Metoyer",
"11/30/25");

//Checking out an item that has already been checked out

std::cout \<\< "\n\n\nChecking out an item thats already checked
out:\n\n";

libraryInventory\[0\]\[0\].checkoutItem("Devon Scott", "12/05/25");

//Printing the current library inventory

std::cout \<\< "\n\n\nPrinting current library inventory with 1
checked-in, 1 checked-out item:\n\n";

libraryInventory.printLibrary(std::cout);

std::cout \<\< std::endl;

libraryInventory.printCheckedOutItems(std::cout);

//Checking out movie1

std::cout \<\< "\n\n\nChecking out a movie:\n\n";

libraryInventory\[9\]\[14\].checkoutItem("UC Irvine", "12/31/25");

//Printing the current library inventory

std::cout \<\< "\n\n\nPrinting current library inventory with 2
checked-out items:\n\n";

libraryInventory.printLibrary(std::cout);

std::cout \<\< std::endl;

libraryInventory.printCheckedOutItems(std::cout);

//Returning an item using invalid shelf/compartment values

std::cout \<\< "\n\n\nTesting edge cases for returning items:\n\n";

libraryInventory\[-1\]\[0\].returnItem();

std::cout \<\< std::endl;

libraryInventory\[0\]\[-1\].returnItem();

std::cout \<\< std::endl;

libraryInventory\[-2\]\[-2\].returnItem();

std::cout \<\< std::endl;

libraryInventory\[10\]\[0\].returnItem();

std::cout \<\< std::endl;

libraryInventory\[0\]\[15\].returnItem();

std::cout \<\< std::endl;

libraryInventory\[11\]\[16\].returnItem();

//Returning book1

std::cout \<\< "\n\n\nReturning a book:\n\n";

libraryInventory\[0\]\[0\].returnItem();

//Printing the current library inventory

std::cout \<\< "\n\n\nPrinting current library inventory with 1
checked-in, 1 checked-out item:\n\n";

libraryInventory.printLibrary(std::cout);

std::cout \<\< std::endl;

libraryInventory.printCheckedOutItems(std::cout);

//Attempting to swap two items when one isn't in the library

std::cout \<\< "\n\n\Attempting swap with one item not in
inventory:\n\n";

libraryInventory.swap(libraryInventory\[0\]\[0\],
libraryInventory\[9\]\[14\]);

//Returning movie1

std::cout \<\< "\n\n\nReturning a movie:\n\n";

libraryInventory\[9\]\[14\].returnItem();

//Printing the current library inventory

std::cout \<\< "\n\n\nPrinting current library inventory with 2
checked-in items:\n\n";

libraryInventory.printLibrary(std::cout);

std::cout \<\< std::endl;

libraryInventory.printCheckedOutItems(std::cout);

//Returning an item that already has been returned

std::cout \<\< "\n\n\nReturning an item thats already returned:\n\n";

libraryInventory\[0\]\[0\].returnItem();

//Swapping two items when both are present

std::cout \<\< "\n\n\Swapping two items:\n\n";

libraryInventory.swap(libraryInventory\[0\]\[0\],
libraryInventory\[9\]\[14\]);

//Printing the current library inventory; book1 and movie1 have swapped
locations

std::cout \<\< "\n\n\nPrinting current library inventory with 2
checked-in items:\n\n";

libraryInventory.printLibrary(std::cout);

std::cout \<\< std::endl;

libraryInventory.printCheckedOutItems(std::cout);

return 0;

}

Library.h

\#ifndef LIBRARY_H

\#define LIBRARY_H

\#include "Compartment.h"

\#include "Shelf.h"

\#include "LibraryItem.h"

\#include "Book.h"

\#include "Movie.h"

\#include "Magazine.h"

class Library {

public:

//Constructor

Library();

//Destructor

~Library();

//Helper function

bool validLocation(int shelf, int comp) const;

//Print functions for entire library and checked-out items

void printLibrary(std::ostream& os) const;

void printCheckedOutItems(std::ostream& os) const;

//Swap function takes two Compartment parameters to swap

void swap(Compartment& cell1, Compartment& cell2);

//Needed to override \[\]\[\] operator for 2D arrays specifically

//Compartment\* operator\[\](int shelfIndex);

Shelf operator\[\](int shelfIndex);

//Overloaded \<\< operator

friend std::ostream& operator\<\<(std::ostream& out, const Library&
lib);

private:

//Standard Library Inventory

Compartment shelves\[10\]\[15\];

};

\#endif

Library.cpp

\#include "Library.h"

\#include \<iostream\>

\#include \<utility\>

//Constructor

Library::Library() {}

//Destructor

Library::~Library()

{

//Clear memory of all occupied compartments

for (int s = 0; s \< 10; s++) {

for (int c = 0; c \< 15; c++) {

shelves\[s\]\[c\].clear();

}

}

}

// A helper function to check boundaries without repeat code

bool Library::validLocation(int shelf, int comp) const {

return shelf \>= 0 && shelf \< 10 && comp \>= 0 && comp \< 15;

}

void Library::printLibrary(std::ostream& os) const

{

os \<\< "All items currently checked into storage:\n";

// Used to track if we found at least one checked-in item

bool found = false;

// Loop through all shelves (0–9)

for (int s = 0; s \< 10; s++)

{

// Loop through all compartments on the shelf (0–14)

for (int c = 0; c \< 15; c++)

{

// Access the current compartment

const Compartment& comp = shelves\[s\]\[c\];

// Skip this compartment if no item is stored here

if (!comp.isOccupied())

continue;

// Retrieve the LibraryItem stored in this compartment

LibraryItem\* item = comp.getItem();

// Only print if the item exists

if (item != nullptr)

{

found = true; // At least one checked-in item exists

// Print shelf and compartment location

os \<\< "Shelf " \<\< s \<\< ", Compartment " \<\< c \<\< "\n";

// Print item details

os \<\< \*item \<\< "\n";

os \<\< "-----------------------------\n";

}

}

}

// If no checked-in items were found, notify the user

if (!found)

{

os \<\< "No items are currently checked into storage.\n";

}

}

void Library::printCheckedOutItems(std::ostream& os) const

{

// Start the output header

os \<\< "All items currently checked out:\n";

// Used to track if we found at least one checked-out item

bool found = false;

// Loop through all shelves (0–9)

for (int s = 0; s \< 10; s++)

{

// Loop through all compartments on the shelf (0–14)

for (int c = 0; c \< 15; c++)

{

// Access the current compartment

const Compartment& comp = shelves\[s\]\[c\];

// Skip this compartment if no item is stored here

if (!comp.isOccupied())

continue;

// Retrieve the LibraryItem stored in this compartment

LibraryItem\* item = comp.getItem();

// Only print if the item exists and is checked out

if (item != nullptr && item-\>getCheckedOut())

{

found = true; // At least one checked-out item exists

// Print shelf and compartment location

os \<\< "Shelf " \<\< s \<\< ", Compartment " \<\< c \<\< "\n";

// Print item details

os \<\< "Name: " \<\< item-\>getName() \<\< "\n";

os \<\< "Checked Out By: " \<\< item-\>getCheckedOutName() \<\< "\n";

os \<\< "Return Date: " \<\< item-\>getReturnDate() \<\< "\n";

os \<\< "-----------------------------\n";

}

}

}

// If no checked-out items were found, notify the user

if (!found)

{

os \<\< "No items are currently checked out.\n";

}

}

void Library::swap(Compartment& cell1, Compartment& cell2)

{

//Check that both compartments are occupied before swapping

if (!cell1.isOccupied() \|\| !cell2.isOccupied())

{

std::cout \<\< "Error: One of both compartments are empty.\n";

return;

}

//Get the LibraryItem stored at each Compartment

LibraryItem\* item1 = cell1.getItem();

LibraryItem\* item2 = cell2.getItem();

//Check that both compartments have items not checked out

if (item1-\>getCheckedOut() \|\| item2-\>getCheckedOut())

{

//Error message displays depending on which Compartment was invalid

if (item1-\>getCheckedOut())

std::cout \<\< "Error: Cannot swap " \<\< item1-\>getName() \<\< " as it
is checked out.\n";

if (item2-\>getCheckedOut())

std::cout \<\< "Error: Cannot swap " \<\< item2-\>getName() \<\< " as it
is checked out.\n";

return;

}

//Swap the pointers

std::swap(cell1.item, cell2.item);

std::swap(cell1.occupied, cell2.occupied);

std::cout \<\< "Items swapped successfully.\n";

}

//Overloaded \[\] operator

Shelf Library::operator\[\](int shelfIndex) {

//Checking if entered shelf index is valid

if (shelfIndex \< 0 \|\| shelfIndex \>= 10) {

std::cout \<\< "Error: Shelf index must be between 0 and 9. " \<\<
shelfIndex \<\< " is invalid.\n";

//Dummy variable returned if shelf index is invalid

static Compartment invalidShelfIndex\[15\];

for (int i = 0; i \< 15; ++i)

{

invalidShelfIndex\[i\].isPlaceholder = true;

}

return invalidShelfIndex;

}

return Shelf(shelves\[shelfIndex\]);

}

//Used for printing a Library with overloaded \<\< operator

std::ostream& operator\<\<(std::ostream& out, const Library& lib) {

for (int s = 0; s \< 10; s++) {

out \<\< "Shelf " \<\< s \<\< ":\n";

for (int c = 0; c \< 15; c++) {

out \<\< " Compartment " \<\< c \<\< ": " \<\< lib.shelves\[s\]\[c\]
\<\< "\n";

}

out \<\< "\n";

}

return out;

}

Shelf.h

\#pragma once

\#include "Compartment.h"

// Shelf allows library\[shelf\]\[compartment\] syntax.

// It holds a pointer to one row of 15 compartments.

class Shelf {

private:

Compartment\* row; // pointer to a row of 15 Compartment objects

public:

// Constructor

Shelf(Compartment\* rowPtr);

// Overload \[\] so that calling library\[shelf\]\[comp\]

// returns the correct compartment.

Compartment& operator\[\](int compartmentIndex);

};

Shelf.cpp

\#include "Shelf.h"

\#include \<iostream\>

//Constructor

Shelf::Shelf(Compartment\* rowPtr)

: row(rowPtr)

{

}

//Overloaded \[\] operator returns a reference to a Compartment

Compartment& Shelf::operator\[\](int compartmentIndex)

{

//Testing for invalid comparment indexes

if (compartmentIndex \< 0 \|\| compartmentIndex \>= 15)

{

std::cout \<\< "Error: Compartment index must be between 0 and 14. "
\<\< compartmentIndex \<\< " is invalid.\n";

//Dummy variable returned if index is invalid

static Compartment invalidCompartmentIndex;

invalidCompartmentIndex.setPlaceholder();

return invalidCompartmentIndex;

}

return row\[compartmentIndex\];

}

LibraryItem.h

\#pragma once

\#include \<string\>

\#include \<iostream\>

\#include \<iomanip\>

//LibraryItem will be the parent class of Book, Magazine, and Movie

class LibraryItem {

private:

static int idCount;

protected:

std::string name;

std::string description;

int id;

bool isCheckedOut;

std::string checkedOutName;

std::string returnDate;

public:

//Constructor

LibraryItem(std::string nm, std::string desc);

//Destructor

virtual ~LibraryItem();

//Getters

bool getCheckedOut() const;

std::string getName() const;

std::string getReturnDate() const;

std::string getCheckedOutName() const;

//Setters

void checkoutItem(const std::string& person, const std::string& date);

void returnItem();

//Overloading the \<\< operator

friend std::ostream& operator\<\<(std::ostream& os, const LibraryItem&
item);

//Virtual print function enables polymorphic printing

virtual void print(std::ostream& os) const;

};

LibraryItem.cpp

\#include "LibraryItem.h"

\#include \<stdexcept\>

//Static variable assigns IDs to LibraryItem objects

int LibraryItem::idCount = 1;

//Constructor

LibraryItem::LibraryItem(std::string nm, std::string desc)

: name(nm), description(desc), id(idCount++), isCheckedOut(false),
checkedOutName(""), returnDate("") {

}

//Destructor

LibraryItem::~LibraryItem() {}

//Getters

bool LibraryItem::getCheckedOut() const { return isCheckedOut; }

std::string LibraryItem::getName() const { return name; }

std::string LibraryItem::getReturnDate() const { return returnDate; }

std::string LibraryItem::getCheckedOutName() const { return
checkedOutName; }

//Setter for checking out an item

void LibraryItem::checkoutItem(const std::string& person, const
std::string& date) {

isCheckedOut = true;

checkedOutName = person;

returnDate = date;

}

//Setter for returning an item

void LibraryItem::returnItem() {

isCheckedOut = false;

checkedOutName = "";

returnDate = "";

}

//Overloaded \<\< operator calls print function to display LibraryItem
attributes polymorphically

std::ostream& operator\<\<(std::ostream& os, const LibraryItem& item) {

item.print(os);

return os;

}

//print is virtual, enabling polymorphism of overloaded \<\< operators

void LibraryItem::print(std::ostream& os) const {

os \<\< "Name: " \<\< name \<\< "\n"

\<\< "Description: " \<\< description \<\< "\n"

\<\< "ID: " \<\< id \<\< "\n";

}

Book.h

\#pragma once

\#include "LibraryItem.h"

//Book is a child class of LibraryItem

class Book : public LibraryItem {

private:

std::string title;

std::string author;

std::string copyrightDate;

public:

//Constructor

Book(std::string t, std::string a, std::string cd, std::string desc);

//Destructor

~Book();

//Overloading the \<\< operator

friend std::ostream& operator\<\<(std::ostream& os, const Book& book);

//Used to display the overloaded \<\< operator

virtual void print(std::ostream& os) const override;

};

Book.cpp

\#include "Book.h"

//Constructor

Book::Book(std::string t, std::string a, std::string cd, std::string
desc) : LibraryItem(t, desc), title(t), author(a), copyrightDate(cd)

{

}

//Destructor

Book::~Book() {}

//Overloaded \<\< operator prints the title, author, copyright date,
description, id, and if the book is checked out

//If checked out, also prints who its checked out by and return date

std::ostream& operator\<\<(std::ostream& os, const Book& book) {

os \<\< "Book Title: " \<\< book.title \<\< "\n"

\<\< "Author: " \<\< book.author \<\< "\n"

\<\< "Copyright: " \<\< book.copyrightDate \<\< "\n"

\<\< "Description: " \<\< book.description \<\< "\n"

\<\< "ID: " \<\< book.id \<\< "\n"

\<\< "Checked Out? " \<\< (book.isCheckedOut ? "Yes" : "No") \<\< "\n";

if (book.isCheckedOut) {

os \<\< "Checked Out By: " \<\< book.checkedOutName \<\< "\n"

\<\< "Return Date: " \<\< book.returnDate \<\< "\n";

}

return os;

}

//Calling the \<\< operator on a Book object

void Book::print(std::ostream& os) const {

os \<\< \*this;

}

Magazine.h

\#pragma once

\#include "LibraryItem.h"

//Magazine is a child class of LibraryItem

class Magazine : public LibraryItem {

private:

int edition;

std::string mainArticle;

public:

//Constructor

Magazine(int ed, std::string article, std::string nm, std::string desc);

//Destructor

~Magazine();

//Overloading the \<\< operator

friend std::ostream& operator\<\<(std::ostream& os, const Magazine&
magazine);

//Used to display the overloaded \<\< operator

virtual void print(std::ostream& os) const override;

};

Magazine.cpp

\#include "Magazine.h"

//Constructor

Magazine::Magazine(int ed, std::string article, std::string nm,
std::string desc)

: LibraryItem(nm, desc), edition(ed), mainArticle(article)

{

}

//Destructor

Magazine::~Magazine() {}

//Overloaded \<\< operator prints the name, edition, main article,
description, id, and if the magazine is checked out

//If checked out, also prints who its checked out by and return date

std::ostream& operator\<\<(std::ostream& os, const Magazine& magazine) {

os \<\< "Magazine Name: " \<\< magazine.name \<\< "\n"

\<\< "Edition: " \<\< magazine.edition \<\< "\n"

\<\< "Main Article: " \<\< magazine.mainArticle \<\< "\n"

\<\< "Description: " \<\< magazine.description \<\< "\n"

\<\< "ID: " \<\< magazine.id \<\< "\n"

\<\< "Checked Out? " \<\< (magazine.isCheckedOut ? "Yes" : "No") \<\<
"\n";

if (magazine.isCheckedOut) {

os \<\< "Checked Out By: " \<\< magazine.checkedOutName \<\< "\n"

\<\< "Return Date: " \<\< magazine.returnDate \<\< "\n";

}

return os;

}

//Calling the \<\< operator on a Magazine object

void Magazine::print(std::ostream& os) const {

os \<\< \*this;

}

Movie.h

\#pragma once

\#include "LibraryItem.h"

class Movie : public LibraryItem {

private:

std::string title;

std::string director;

std::string mainActors;

public:

//Constructor

Movie(std::string t, std::string d, std::string actors,

std::string desc);

//Destructor

~Movie();

//Overloading the \<\< operator

friend std::ostream& operator\<\<(std::ostream& os, const Movie& movie);

//Used to display the overloaded \<\< operator

virtual void print(std::ostream& os) const override;

};

Movie.cpp

\#include "Movie.h"

//Constructor

Movie::Movie(std::string t, std::string d, std::string actors,
std::string desc)

: LibraryItem(t, desc), title(t), director(d), mainActors(actors)

{

}

//Destructor

Movie::~Movie() {}

//Overloaded \<\< operator prints the title, director, main actors,
description, id, and if the movie is checked out

//If checked out, also prints who its checked out by and return date

std::ostream& operator\<\<(std::ostream& os, const Movie& movie) {

os \<\< "Movie Title: " \<\< movie.title \<\< "\n"

\<\< "Director: " \<\< movie.director \<\< "\n"

\<\< "Main Actors: " \<\< movie.mainActors \<\< "\n"

\<\< "Description: " \<\< movie.description \<\< "\n"

\<\< "ID: " \<\< movie.id \<\< "\n"

\<\< "Checked Out? " \<\< (movie.isCheckedOut ? "Yes" : "No") \<\< "\n";

if (movie.isCheckedOut) {

os \<\< "Checked Out By: " \<\< movie.checkedOutName \<\< "\n"

\<\< "Return Date: " \<\< movie.returnDate \<\< "\n";

}

return os;

}

//Calling the \<\< operator on a Movie object

void Movie::print(std::ostream& os) const {

os \<\< \*this;

}

Compartment.h

\#pragma once

\#include \<iostream\>

\#include "LibraryItem.h"

class Compartment {

private:

LibraryItem\* item; // pointer for polymorphism

bool occupied;

//isPlaceholder is used to prevent invalid indexes from being accepted
into \[\] operator

bool isPlaceholder;

public:

//Constructor

Compartment();

//Destructor

~Compartment();

//Functionalities of a Compartment

void addItem(LibraryItem\* it);

void checkoutItem(const std::string& person, const std::string& date);

void returnItem();

//Used to set isPlaceholder true

void setPlaceholder();

//Helper function

void setItem(LibraryItem\* it);

//Accessors

bool isOccupied() const;

LibraryItem\* getItem() const;

//Clear the compartment (delete the item)

void clear();

//Overloaded \<\< operator for

friend std::ostream& operator\<\<(std::ostream& os, const Compartment&
c);

//Used to implement the swap function in Library class

friend class Library;

};

Compartment.cpp

\#include "Compartment.h"

//Constructor

Compartment::Compartment()

: item(nullptr), occupied(false), isPlaceholder(false) {

}

//Destructor

Compartment::~Compartment()

{

}

//Accessors

bool Compartment::isOccupied() const { return isPlaceholder ? false :
occupied; }

LibraryItem\* Compartment::getItem() const { return item; }

void Compartment::setPlaceholder() { isPlaceholder = true; }

//Add a LibraryItem object

void Compartment::addItem(LibraryItem\* it)

{

//Check if an invalid index was entered

if (isPlaceholder) {

return;

}

//Check if it is a nullptr

if (!it) {

return;

}

//Check if the Compartment is occupied

if (occupied) {

std::cout \<\< "Error: Compartment already occupied.\n";

return;

}

//Add the item to the Compartment

item = it;

occupied = true;

}

//checkoutItem function

//Takes two string parameters for the person checking out and return
date

void Compartment::checkoutItem(const std::string& person, const
std::string& date) {

//Won't check out if the index is invalid

if (isPlaceholder) {

return;

}

//Won't check out if the compartment is unoccupied

if (!occupied \|\| item == nullptr) {

std::cout \<\< "Error: Compartment is empty.\n";

return;

}

//Won't check out if the item at the compartment is already checked out

if (item-\>getCheckedOut()) {

std::cout \<\< "Error: Item already checked out.\n";

return;

}

//Check out an item successfully

item-\>checkoutItem(person, date);

std::cout \<\< item-\>getName() \<\< " successfully checked out.\n";

}

void Compartment::returnItem() {

//Won't return if the index is invalid

if (isPlaceholder) {

return;

}

//Won't return if Compartment is empty

if (!occupied \|\| item == nullptr) {

std::cout \<\< "Error: Compartment is empty.\n";

return;

}

//Won't return if item in the Compartment is not checked out

if (!item-\>getCheckedOut()) {

std::cout \<\< "Error: Item is not checked out.\n";

return;

}

//Return an item successfully

item-\>returnItem();

std::cout \<\< item-\>getName() \<\< " successfully returned.\n";

}

void Compartment::setItem(LibraryItem\* it)

{

//Won't return if the index is invalid

if (isPlaceholder) {

return;

}

//Prevent memory leaks

if (occupied && item != nullptr) {

delete item;

}

//Set the item accordingly

item = it;

occupied = (it != nullptr);

}

//Used to delete items

void Compartment::clear() {

//Nothing to delete if invalid index

if (isPlaceholder) {

return;

}

//Successfully deletes an item if it exists

if (item != nullptr) {

delete item;

item = nullptr;

}

occupied = false;

}

//Overloaded \<\< operator implementation

std::ostream& operator\<\<(std::ostream& os, const Compartment& c) {

if (c.isPlaceholder) {

std::cout \<\< "\[INVALID\].\n";

}

else if (!c.occupied \|\| c.item == nullptr) {

os \<\< "\[EMPTY\]";

}

else {

os \<\< \*(c.item); // Calls LibraryItem operator\<\<

}

return os;

}
