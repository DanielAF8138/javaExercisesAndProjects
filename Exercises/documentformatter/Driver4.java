/**
 * A driver for testing the FormattedDocument class
 */
public class Driver4
{
    /**
     * The entry point of the application
     *
     * @param args   The command line arguments
     */
    public static void main(String[] args)
    {
	Document[]               documents;
	String                   text;


	text = "George is a little monkey, "+
               "and all monkeys are curious.\n"+
               "But no monkey is as curious "+
               "as George.";


        documents    = new Document[2];
	documents[0] = new Document(text);
        documents[1] = new FormattedDocument(text, 20);
        
        for (int i=0; i < documents.length; i++)
        {
            print(documents[i]);        
        }
    }

    /**
     * Print a Document
     */
    private static void print(Document doc)
    {
	System.out.println("A document:");
	System.out.println();
	System.out.println(doc.getText());
	System.out.println("\n");
    }

    /**
     * Print a FormattedDocument
     */
    private static void print(FormattedDocument doc)
    {
	System.out.println("A nicely formatted document:");
	System.out.println();
	System.out.println(doc.getText());
	System.out.println("\n");
    }
}
