/**
 * A driver for testing the Document class
 */
public class Driver1
{
    /**
     * The entry point of the application
     *
     * @param args   The command line arguments
     */
    public static void main(String[] args)
    {
	Document                 unformatted;
	String                   text;


	text = "George is a little monkey, "+
               "and all monkeys are curious.\n"+
               "But no monkey is as curious "+
               "as George.";


	unformatted = new Document(text);

	System.out.println();
	System.out.println(unformatted.getDescription());
	System.out.println();
	System.out.println(unformatted.getText());

    }
}
