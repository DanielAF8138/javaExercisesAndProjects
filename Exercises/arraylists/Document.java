import java.util.ArrayList;

/**
 * The Document class represents a text document as an ArrayList of Strings, where each entry in the ArrayList stores a
 * single line of text.
 * 
 * @author Nathan Sprague and Daniel Fuller
 * @version 08/02/2023
 *
 */

public class Document {

    // DECLARE ARRAYLIST HERE
    private ArrayList<String> document;

    /**
     * Initialize a document containing no text.
     */
    public Document() {
        document = new ArrayList<String>();
    }

    /**
     * Add a single line of text to the end of the document. The line is stored "as-is". I.e. no newline characters are
     * added.
     * 
     * @param line The line of text to add
     */
    public void appendLine(String line) {
        document.add(line);
    }

    /**
     * Delete the indicate line of text. This method uses 0-based indexing. This method performs no error checking. It
     * may raise an exception if an invalid line number is provided.
     * 
     * @param lineNumber The index of the line to delete
     */
    public void deleteLine(int lineNumber) {
        document.remove(lineNumber);
    }

    /**
     * Returns the total number of characters in the document. The count includes spaces, but it does not include
     * newline characters. The count for an empty document will be 0.
     * 
     * @return The total number of characters.
     */
    public int characterCount() {
        int count = 0;
        for (String line : document) {
            count += line.length();
        }
        return count;
    }

    /**
     * This method returns the single longest line of text in the document. The line is returned without a trailing
     * newline character.
     * 
     * @return The longest line
     */
    public String longestLine() {
        String longLine = "";
        for (String line : document) {
            if (line.length() > longLine.length()) {
                longLine = line;
            }
        }
        return longLine;
    }

    /**
     * This method returns the entire document as a single string. Each line (including the last) will be terminated
     * with a single newline character. If the document is empty, then return value will be an empty string.
     * 
     * @return The entire document as a single string
     */
    public String toString() {
        String entireDocument = "";
        if (document == null) {
            return "";
        } else {
            for (String line : document) {
                entireDocument += line + "\n";
            }
            return entireDocument;
        }
    }

}
