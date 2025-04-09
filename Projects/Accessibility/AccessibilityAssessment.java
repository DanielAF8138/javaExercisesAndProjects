
public class AccessibilityAssessment {
    private String category;
    private String googleResult;
    private String waveResult;
    private String sortsiteResult;
    private String aslintResult;
    private String description;

    public AccessibilityAssessment(String category, String googleResult, String waveResult, String sortsiteResult,
            String aslintResult, String description) {
        this.category = category;
        this.googleResult = googleResult;
        this.waveResult = waveResult;
        this.sortsiteResult = sortsiteResult;
        this.aslintResult = aslintResult;
        this.description = description;
    }

    public String toString() {
        return String.format("%s - Google : %s WAVE : %s SortSite : %s ASLint : %s - %s", category, googleResult,
                waveResult, sortsiteResult, aslintResult, description);
    }

    public boolean equals(Object other) {
        if (!(other instanceof AccessibilityAssessment)) {
            return false;
        }

        AccessibilityAssessment otherAccessibilityAssessment = (AccessibilityAssessment) other;

        return category.equals(otherAccessibilityAssessment.category)
                && googleResult.equals(otherAccessibilityAssessment.googleResult)
                && waveResult.equals(otherAccessibilityAssessment.waveResult)
                && sortsiteResult.equals(otherAccessibilityAssessment.sortsiteResult)
                && aslintResult.equals(otherAccessibilityAssessment.aslintResult)
                && description.equals(otherAccessibilityAssessment.description);
    }

    public boolean passed(String checkerPartialName) {
        if (checkerPartialName.equals("google")) {
            if (googleResult.equals("error") || googleResult.equals("error_paid")) {
                return true;
            }
        } else if (checkerPartialName.equals("sortsite")) {
            if (sortsiteResult.equals("error") || sortsiteResult.equals("error_paid")) {
                return true;
            }
        } else if (checkerPartialName.equals("wave")) {
            if (waveResult.equals("error") || waveResult.equals("error_paid")) {
                return true;
            }
        } else if (checkerPartialName.equals("lint")) {
            if (waveResult.equals("error") || waveResult.equals("error_paid")) {
                return true;
            }
        }
        return false;
    }

    public String getCategory() {
        return category;
    }

    public String getGoogleResult() {
        return googleResult;
    }

    public String getWaveResult() {
        return waveResult;
    }

    public String getSortsiteResult() {
        return sortsiteResult;
    }

    public String getAslintResult() {
        return aslintResult;
    }

    public String getDescription() {
        return description;
    }
}