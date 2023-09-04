package src;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class errorCalculator {
    codeTester codeTester;
    public errorCalculator(  codeTester codeTester ) {
        this.codeTester = codeTester;
    }


    // here we try to do tests and collect results to get number of errors
    public void findTheError() throws NoSuchMethodException {
        // IF WE SEND numberToTest DIFFERENT THEN 0 OR 1 WE GET NULL EXCEPTION
        int numberToTest = 0;
        codeTester.runTest(numberToTest);
    }

    public List<Double> calculateAllValues() throws NoSuchMethodException {
        return Arrays.asList(5.0, 2.0, 3.0, 5.0);
    }
}
