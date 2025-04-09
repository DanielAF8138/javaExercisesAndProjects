import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class starts to test the {@link AccessibilityAssessment} class.
 *
 * @author hcientist
 * @version s23
 *
 */
class AccessibilityAssessmentStudentTest {

    private static final String CTGY_1 = "TEST/category";
    // private static final String CTGY_2 = "Category/Test2";

    private static final String[] RESULT_VALUES = { "error", "error_paid", "warning", "manual", "identified",
            "notfound" };
    private static final String DESC_1 = "this desc over hrrr";
    // private static final String DESC_2 = "We are a community committed to preparing students to be educated and "
    // +"enlightened citizens who lead productive and meaningful lives.";
    private AccessibilityAssessment aa1; // , aa2, aaNotSame, aaNotSame2;

    /**
     * Any method that has junit5's {@link BeforeEach} annotation will be run before each of the test methods (those
     * that are annotated with {@link Test}).
     */
    @BeforeEach
    void setUp() {
        aa1 = new AccessibilityAssessment(CTGY_1, RESULT_VALUES[0], RESULT_VALUES[1], RESULT_VALUES[2],
                RESULT_VALUES[3], DESC_1);
    }

    /**
     * Tests the getter and constructor.
     */
    @Test
    void testConstructoGet1() {
        assertEquals(CTGY_1, aa1.getCategory(), "getCategory() should match first constructor arg");
    }

    /**
     * Tests the getter and constructor.
     */
    @Test
    void testConstructoGet2() {
        assertEquals(RESULT_VALUES[0], aa1.getGoogleResult(), "getGoogleResult() should match second constructor arg");
    }

    /**
     * Tests the getter and constructor.
     */
    @Test
    void testConstructoGet3() {
        assertEquals(RESULT_VALUES[1], aa1.getWaveResult(), "getWaveResult() should match third constructor arg");
    }

    /**
     * Tests the getter and constructor.
     */
    @Test
    void testConstructoGet4() {
        assertEquals(RESULT_VALUES[2], aa1.getSortsiteResult(),
                "getSortsiteResult() should match fourth constructor arg");
    }

    /**
     * Tests the getter and constructor.
     */
    @Test
    void testConstructoGet5() {
        assertEquals(RESULT_VALUES[3], aa1.getAslintResult(), "getAslintResult() should match fifth constructor arg");
    }

    /**
     * Tests the getter and constructor.
     */
    @Test
    void testConstructoGet6() {
        assertEquals(DESC_1, aa1.getDescription(), "getDescription() should match sixth constructor arg");
    }

    /**
     * Tests the getter and constructor.
     */
    @Test
    void testSameEquals() {
        // this one works even with default, inherited equals
        assertEquals(aa1, aa1, "Same should be equals");
    }

}
