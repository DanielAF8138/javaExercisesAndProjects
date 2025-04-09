import java.io.File;

/**
 * This is a utility class that provides some of the functionality of the Unix
 * ls and find commands.
 * 
 * @author fulle2da
 * @version 20/04/23
 */
public class DirectorySearcher {

    private final File start;

    /**
     * Construct a DirectorySearcher to search (or list files) inside a
     * particular directory.
     * 
     * @param path the name of the directory that will be searched
     */
    public DirectorySearcher(String path) {
        this.start = new File(path);
    }

    /**
     * List the contents of the start directory (but not subdirectories).
     */
    public void listDirectory() {
        File[] files = start.listFiles();
        for (File curFile : files) {
            System.out.print(curFile.getName());
            if (curFile.isDirectory()) {
                System.out.print("\t(Directory)");
            }
            System.out.println();
        }
    }

    /**
     * Recursively list the contents of the start directory and all of the
     * directories it contains.
     */
    public void listDirectories() {
        // You will need to create a recursive helper method that takes a
        // directory as an argument.
        File[] files = start.listFiles();
        System.out.println(start.getName() + "/");
        for (File curFile : files) {
            helper(curFile, 1);
        }
    }
    
    /**
     * Helper method1.
     * @param start start file
     * @param indent indent amount
     */
    public void helper(File start, int indent) {
        if (start.isFile()) {
            System.out.println("\t".repeat(indent) + start.getName());
        } else if (start.isDirectory()) {
            System.out.println("\t".repeat(indent) + start.getName() + "/");
            File[] files = start.listFiles();
            for (File curFile : files) {
                helper(curFile, indent + 1);
            }
        }
    }

    /**
     * Recursively search the start directory and all of the directories it
     * contains. This method will print out only the file and directory names
     * that contain the search string.
     * 
     * For example if the string is "txt", the files "hello.txt" and
     * "blatxt.doc" would both match, but "text.doc" would not.
     * 
     * @param searchString the pattern to search for
     */
    public void searchDirectories(String searchString) {
        // You will need to create a recursive helper method that takes a
        // directory and the search string as arguments.
        File[] files = start.listFiles();
        if (start.getName().contains(searchString)) {
            System.out.println(start);
        }
        for (File curFile : files) {
            helper2(curFile, searchString);
        }
    }
    
    /**
     * Helper method2.
     * @param start start file
     * @param searchString searchString
     */
    public void helper2(File start, String searchString) {
        if (start.isFile() && start.getName().contains(searchString)) {
            System.out.println(start);
        } else if (start.isDirectory()) {
            if (start.getName().contains(searchString)) {
                System.out.println(start);
            }
            File[] files = start.listFiles();
            for (File curFile: files) {
                helper2(curFile, searchString);
            }
            
        }
    }
    
}
