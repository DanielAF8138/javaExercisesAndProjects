import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A simple editor application designed to exercise the Document class.
 * 
 * @author Nathan Sprague
 * @version V3.0, 3/10/21
 */
public class Editor {

    private Document document;
    private Scanner scanner;

    /**
     * Initialize the scanner and document.
     */
    public Editor() {
        scanner = new Scanner(System.in);
        document = new Document();
    }

    /**
     * The run method handles the main user interaction loop.
     * 
     * @throws FileNotFoundException SHOULD BE FIXED!
     */
    public void run() {
        String curLine;

        System.out.println("\nNanovimacs, the worlds" + " greatest command-line text editor!\n");

        printPrompt();

        while (scanner.hasNextLine()) {
            curLine = scanner.nextLine();
            switch (curLine.trim().toLowerCase()) {
                case "a":
                    readText();
                    break;
                case "d":
                    deleteLine();
                    break;
                case "l":
                    System.out.println("\nThe longest line is:");
                    System.out.println("\n" + document.longestLine());
                    break;
                case "c":
                    System.out.println("\nThe character count is:");
                    System.out.println("\n" + document.characterCount());
                    break;
                case "p":
                    System.out.println("\n" + document);
                    break;
                case "s":
                    saveFile();
                    break;
                case "r":
                    loadFile();
                    break;
                default:
                    System.out.println("Unrecognized command.");
            }
            printPrompt();

        }
        System.out.println();
    }

    /**
     * Read lines of text until the user enters a empty line.
     */
    private void readText() {
        String curLine;
        System.out.println("Enter text. Enter a blank line to finish.");
        while (scanner.hasNextLine()) {
            curLine = scanner.nextLine();
            if (curLine.equals("")) {
                break;
            }
            document.appendLine(curLine);
        }

    }

    /**
     * Deletes a line of text provided by the user.
     */
    private void deleteLine() {
        int lineNumber;
        System.out.println("Which line number should be deleted?");
        if (scanner.hasNextInt()) {
            lineNumber = scanner.nextInt();
            document.deleteLine(lineNumber);
        } else {
            System.out.println("Bad line number.");
        }
        scanner.nextLine();
    }

    /**
     * Loads a new document from a user-provided file name.
     * 
     * @throws FileNotFoundException SHOULD BE FIXED!
     */
    private void loadFile() {
        String name;
        System.out.print("Enter a file name: ");
        name = scanner.nextLine();
        try {
            document = new Document(name);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Saves the document using the user-provided file name.
     * 
     * @throws FileNotFoundException SHOULD BE FIXED!
     */
    private void saveFile() {
        String name;
        System.out.print("Enter a file name: ");
        name = scanner.nextLine();
        try {
            document.save(name);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Print the instruction prompt.
     */
    public static void printPrompt() {
        System.out.print("\n\"a\" to enter text\n" + "\"d\" to delete a line\n" + "\"l\" to print the longest line\n"
                + "\"c\" to print the character count\n" + "\"p\" to display the entire document\n" + "\"r\" to load\n"
                + "\"s\" to save\n" + "CTRL-D to exit\n" + "Command: ");
    }

    /**
     * Start the application.
     * 
     * @param args not used
     * @throws FileNotFoundException SHOULD BE FIXED!
     */
    public static void main(String[] args) throws FileNotFoundException {
        Editor editor = new Editor();
        editor.run();
    }

}
