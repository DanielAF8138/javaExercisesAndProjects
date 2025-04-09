import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AccessibilityResults {
    private ArrayList<AccessibilityAssessment> assessments;

    public AccessibilityResults(String filename) {
        ArrayList<AccessibilityAssessment> assessments = new ArrayList<>();

        try {
            Scanner s = new Scanner(new File(filename));
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] split = line.split(" ");
                String sub = "";
                for (int i = 5; i < split.length; i++) {
                    sub += split[i];
                }
                assessments.add(new AccessibilityAssessment(split[0], split[1], split[2], split[3], split[4], sub));
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.printf("File not found: %s", filename);
        }

    }

    public int numTests() {
        return assessments.size();

    }

    public ArrayList<AccessibilityAssessment> getAll() {
        return assessments;
    }

    public void saveResults(String filename, String format, ArrayList<AccessibilityAssessment> results) {
        try {
            PrintWriter out = new PrintWriter(filename);
            for (int i = 0; i < results.size(); i++) {
                out.println(results.toString());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.printf("File not found: %s", filename);
        }

    }

    public ArrayList<AccessibilityAssessment> showTestResults(String details) {

    }
}