/**
 * Simple test driver for the Document class.
 * 
 * @author Nathan Sprague
 *
 */
public class DocumentTestDriver
{

    /**
     * Start the application.
     * 
     * @param args not used
     */
    public static void main(String[] args)
    {
        Document docEmpty = new Document();
        Document docFull = new Document();

        docFull.appendLine("CS159 is");
        docFull.appendLine("super fun.");

        System.out.println("PRINTING A DOCUMENT WITH TWO LINES:");
        System.out.print(docFull.toString());

        System.out.println("\nPRINTING AN EMPTY DOCUMENT:");
        System.out.print(docEmpty.toString());

        System.out.println("\nREMOVING LINE 0:");
        docFull.deleteLine(0);
        System.out.print(docFull.toString());

        System.out.println("\nADDING TWO MORE LINES:");
        docFull.appendLine("sooooooper fun");
        docFull.appendLine("fun.");
        System.out.print(docFull.toString());

        System.out.println("\nCHARACTER COUNT (SHOULD BE 28)");
        System.out.println(docFull.characterCount());

        System.out.println("\nLONGEST LINE:");
        System.out.print(docFull.longestLine());

    }

}
