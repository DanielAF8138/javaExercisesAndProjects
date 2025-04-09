/**
 * Simple utility to list the contents of a directory.
 * 
 * @author
 * @version
 */
public class DirectoryDriver {

    /**
     * List the contents of the current directory.
     * 
     * @param args ignored
     */
    public static void main(String[] args) {
        DirectorySearcher searcher = new DirectorySearcher(".");
        searcher.listDirectories();
    }

}
