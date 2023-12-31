package src;

import java.util.List;

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

     */
    public Tarantula(List<Double> numbersToUse) {
        this.cExecutionFail = numbersToUse.get(0);
        this.cNoExecutionFail = numbersToUse.get(1);
        this.cExecutionPass = numbersToUse.get(2);
        this.cNoExecutionPass = numbersToUse.get(3);
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
