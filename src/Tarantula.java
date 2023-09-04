package src;

/**
 * Responsible for calculating the tarantula metric.
 * A fault localization technique
 */
public class Tarantula {

    private final double cExecutionFail;
    private final double cNoExecutionFail;
    private final double cExecutionPass;
    private final double cNoExecutionPass;

    /**
     *  
     *
     * @param cExecutionFail    Number of failed test cases where the code was executed.
     * @param cNoExecutionFail  Number of failed test cases where the code was not executed.
     * @param cExecutionPass    Number of passed test cases where the code was executed.
     * @param cNoExecutionPass  Number of passed test cases where the code was not executed.
     */
    public Tarantula(int cExecutionFail, int cNoExecutionFail, int cExecutionPass, int cNoExecutionPass) {
        this.cExecutionFail = cExecutionFail;
        this.cNoExecutionFail = cNoExecutionFail;
        this.cExecutionPass = cExecutionPass;
        this.cNoExecutionPass = cNoExecutionPass;
    }

    /**
     * Calculates the tarantula metric.
     *
     * @return The tarantula metric value.
     * @throws Exception If the values provided lead to an invalid computation.
     */
    public double metricCalculator() throws Exception {
        // Ensure that we don't have a denominator of zero in our calculations
        if (cExecutionFail + cNoExecutionFail == 0 || cExecutionPass + cNoExecutionPass == 0) {
            throw new Exception("we must fix your values!");
        }

        // Calculate the suspicious ness ratio for failed test cases
        double suspiciousNessFail = cExecutionFail / (cExecutionFail + cNoExecutionFail);
        if (suspiciousNessFail == 0) {
            throw new Exception("We must fix values for failed tests!");
        }
        // Calculate the suspicious ness ratio for passed test cases
        double suspiciousNessPass = cExecutionPass / (cExecutionPass + cNoExecutionPass);
        if (suspiciousNessPass == 0) {
            throw new Exception("We must fix values for passed tests!");
        }
        // Calculate the final tarantula metric

        return suspiciousNessFail / (suspiciousNessFail + suspiciousNessPass);
    }
}
