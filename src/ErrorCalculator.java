package src;

import java.util.Arrays;
import java.util.List;

import static src.MethodLinesCounter.countLinesInMethod;

public class ErrorCalculator {
    CodeTester codeTester;

    private double cExecutionFail;
    private double cNoExecutionFail;
    private double cExecutionPass;
    private double cNoExecutionPass;

    public ErrorCalculator(CodeTester codeTester ) {
        this.codeTester = codeTester;
    }


    // here we try to do tests and collect results to get number of errors
    public void findTheError(int numberOfTests) throws Exception {
        // IF WE SEND numberToTest DIFFERENT THEN 0 OR 1 WE GET NULL EXCEPTION
        for (int i = 5; i < numberOfTests; i++){
            codeTester.runTest(i);
            Tarantula taran = new Tarantula(calculateAllValues());
            double totalOfStatements = countLinesInMethod("src/main.java", "main");
            cExecutionFail = codeTester.getExceptionCount();
            cNoExecutionFail = codeTester.getExceptionCount();
            cExecutionPass = codeTester.getExceptionCount();
            cNoExecutionPass = codeTester.getExceptionCount();

            System.out.println(taran.metricCalculator());
        }

    }

    public List<Double> calculateAllValues() {
        return Arrays.asList(5.0, 2.0, 3.0, 5.0);
    }
}
