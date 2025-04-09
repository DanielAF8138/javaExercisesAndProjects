import java.util.*;

/**
 * A very simple Document class that can be used to explore
 * issues related to accessibility/visibility
 *
 * @author  Prof. David Bernstein, James Madison University
 * @version 2.0
 */
public class Document
{
    // Note that the attributes are protected
    protected String       delimiters;
    private String text;

    /**
     * Explicit Value Constuctor
     *
     * @param text   The text of the document
     */
    public Document(String text)
    {
	this.text = text;
	delimiters = " ,.;:!?\t\n\r";
    }


    /**
     * Append additional text to the end of this Document
     *
     * @param addition   The text to append
     */
    public void append(String addition)
    {
	text = text + addition;
    }


    /**
     * Get a description of this Document that
     * includes a statistical summary
     *
     * @return  The description
     */
    public String getDescription()
    {
	int          count;
	String       result;

	count  = this.getWordCount();

	result = "This document has " + count;
	if (count == 1) result += " word ";
	else            result += " words ";

	count = this.getLineCount();
	result += "and " + count;
	if (count == 1) result += " line ";
	else            result += " lines ";

	return result;
    }




    /**
     * Get the text of this Document
     *
     * @return  The text
     */
    public String getText()
    {
	return text;
    }




    /**
     * Get the number of lines in this Document
     *
     * @return  The number of lines
     */
    public int getLineCount()
    {
	char               character;
	int                count, i;

	// Initialize the line counter
	count = 1;
	if (text.length() == 0) count = 0; // No words means no lines

	// Count the number of newline characters
	for (i=0; i < text.length(); i++) {

	    character = text.charAt(i);
	    if (character == '\n') count = count + 1;
	}

	return count;
    }





    /**
     * Get the number of words in this Document
     *
     * @return  The number of words
     */
    public int getWordCount()
    {
	int                count;
	StringTokenizer    tokenizer;

	tokenizer = new StringTokenizer(text, delimiters);
	
	count = tokenizer.countTokens();

	return count;
    }

}
