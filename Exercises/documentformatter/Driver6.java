/**
 * A driver for testing the FormattedDocument class
 */
public class Driver6
{
    /**
     * The entry point of the application
     *
     * @param args   The command line arguments
     */
    public static void main(String[] args)
    {
	FormattedDocument        formatted;
	String                   text;


	text = "George is a little monkey, "+
               "and all monkeys are curious.\n"+
               "But no monkey is as curious "+
               "as George.";


	formatted = new FormattedDocument(text, 20);

        print(formatted);        
    }

    /**
     * Print an Object
     */
    private static void print(Object doc)
    {
	System.out.println("doc is an Object");
    }

    /**
     * Print a Document
     */
    private static void print(Document doc)
    {
	System.out.println("doc is a Document");
    }

    /**
     * Print a FormattedDocument
     */
    private static void print(FormattedDocument doc)
    {
	System.out.println("doc is a FormattedDocument");
    }

}
