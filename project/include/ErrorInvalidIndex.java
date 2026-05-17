/**
 * @file ErrorInvalidIndex.java
 * @brief exception class when inavlid index is used
 */
package project.include;

public class ErrorInvalidIndex extends Exception {

    /**
     * @param message error message to output
     * @brief ouptuts error message when sees exception
     */
    public ErrorInvalidIndex (String message) {
        super(message);
    } // END ErrorInvalidIndex

    /**
     * @brief exception message
     */
    public ErrorInvalidIndex () {
        super("Error! Out of bounds.");
    } // END ErrorInvalidIndex
} // END ErrorInvalidIndex