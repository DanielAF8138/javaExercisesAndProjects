/**
 * A driver for testing the FormattedDocument class
 */
public class Driver2
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

	System.out.println();
	System.out.println(formatted.getDescription());
	System.out.println();
	System.out.println(formatted.getText());

    }
}
