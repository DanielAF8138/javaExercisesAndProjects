import java.util.*;

/**
 * A very simple FormattedDocument class that can be used to explore
 * issues related to accessibility/visibility
 *
 * Compared to its parent, this class modifies:
 *
 *     1. The getText() method (provides line-wrap at word boundaries)
 *
 * Compared to its parent, this class adds:
 *
 *     1. A maxWidth attribute (used for line-wrap)
 *     1. A setWidth() method
 *
 * @author  Prof. David Bernstein, James Madison University
 * @version 2.0
 */
public class FormattedDocument extends Document
{
    private int          maxWidth;


    /**
     * Explicit Value Constuctor
     *
     * @param text   The text of the document
     * @param width  The maximum width of a line
     */
    public FormattedDocument(String text, int width)
    {
	super(text);

	maxWidth = width;
    }

    
    /**
     * Get the text of this Document
     *
     * @return  The text
     */
    public String getText()
    {
	int                currentWidth, wordWidth;
	String             result, word;
	StringTokenizer    tokenizer;

	// Construct the tokenizer
	tokenizer = new StringTokenizer(super.getText(), " ");

	// Initialization
	currentWidth =  0;
	result       = "";

	// Loop through the words in the text
	while (tokenizer.hasMoreTokens())
	{
	    word = tokenizer.nextToken();
	    wordWidth = word.length();
	    
	    
	    if ((currentWidth + wordWidth + 1) > maxWidth)
	    {
		// Time for a new line
		result += "\n" + word;
		currentWidth = wordWidth;

	    } else {

		// Put this word on the current line
		if (currentWidth == 0) 
                {
		    // First word on the line
		    result += word;
		    currentWidth = currentWidth + wordWidth;

		} else {

		    // Not the first word on the line
		    result += " " + word;
		    currentWidth = currentWidth + wordWidth + 1;
		}
	    }
	}

	return result;
    }




    /**
     * Set the maximum width (in characters)
     * of a line
     *
     * @param width  The maximum line width
     */
    public void setWidth(int width)
    {
	maxWidth = width;
    }
}
