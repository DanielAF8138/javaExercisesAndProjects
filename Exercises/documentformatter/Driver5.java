public class Driver5
{
    /**
     * The entry point of the application
     *
     * @param args   The command line arguments
     */
    public static void main(String[] args)
    {
	Document                 a, b;
	String                   text;


	text = "George is a little monkey, "+
               "and all monkeys are curious.\n"+
               "But no monkey is as curious "+
               "as George.";


        a = new Document(new String(text));
        b = new Document(new String(text));

        System.out.println(a == b);
    }
}
