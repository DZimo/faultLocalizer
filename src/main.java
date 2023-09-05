package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Hashtable;
import java.util.Scanner;

import static src.MethodLinesCounter.countLinesInMethod;

public class main {
    public static void main(String[] args) throws Exception {
        Script script = new Script();
        CodeTester codeTester = new CodeTester(Script.class.getMethod("scriptExample", int.class), script);
        ErrorCalculator errorCalculator = new ErrorCalculator(codeTester);
        errorCalculator.findTheError(1);
        double lines = countLinesInMethod("src/main.java", "main");
        System.out.println("Number of lines in method: " + lines);
        //bugFinder();
        /*CoverageAnalyzer analyzer = new CoverageAnalyzer();
        try {
            analyzer.analyzeCoverage();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    public static void bugFinder() throws FileNotFoundException {
        DecimalFormat df = new DecimalFormat("#.00");
        Hashtable<String, Double> passed = new Hashtable<String, Double>();
        Hashtable<String, Double> failed = new Hashtable<String, Double>();
        Hashtable<String, Double> result = new Hashtable<String, Double>();
        int failCount = 0;
        int passCount = 0;
        File file = new File("src\\testResults.txt");
        Scanner sc = new Scanner(file);
        //Look at this, I added a comment that wont do anything
        while (sc.hasNextLine())
        {
            String parsedLine[] = sc.nextLine().split(" ");
            if (parsedLine[0].equals("p"))
            {
                passCount++;
                for (int i = 1; i < parsedLine.length; i++)
                {
                    if (passed.get(parsedLine[i]) == null)
                    {
                        passed.put(parsedLine[i], 1.0);
                    }
                    else
                    {
                        passed.put(parsedLine[i], (Double)passed.get(parsedLine[i]) + 1.0 );

                    }
                }
            }
            else if (parsedLine[0].equals("f"))
            {
                failCount++;
                for (int i = 1; i < parsedLine.length; i++)
                {
                    if (failed.get(parsedLine[i]) == null)
                    {
                        failed.put(parsedLine[i], 1.0);
                    }
                    else
                    {
                        failed.put(parsedLine[i], (Double)failed.get(parsedLine[i]) + 1.0 );
                    }
                }
            }
        }

        /*for(String key: failed.keySet()) {
            if(passed.get(key) == null)
                failed.remove(key);
        }*/

        int finalFailCount = failCount;
        int finalPassCount = passCount;

        failed.forEach((k, v) ->
        {
            double susp = 0.0;
            double passedVal;
            if(passed.get(k) != null) {
                passedVal = passed.get(k);
            }
            else {
                passedVal = 0;
            }
            //if(failed.get(k) != 0) {
            susp = (failed.get(k) / finalFailCount) / ((double)(failed.get(k) / finalFailCount)+(double)(passedVal / finalPassCount));
            result.put(k, susp);
            //}

        });
        System.out.println("The following tests were found to be the most suspicious:");
        for(int i = 1; i <= 5; i++) {
            int finalI = i;
            double maxValue = 0;
            boolean multiple = false;
            String maxState = "";

            for(String key: result.keySet()) {
                Double tmp = result.get(key);
                if(tmp.compareTo(maxValue) > 0) {
                    maxValue = tmp;
                    maxState = key;
                    multiple = false;
                }
                else if (tmp == maxValue && maxState != key)
                {
                    maxState = maxState + ", " + key;
                    multiple = true;
                }
            }
            if(!multiple)
                System.out.println(finalI + ": Statement " + maxState + " has a suspiciousness of " + df.format(maxValue));
            else
                System.out.println(finalI + ": Statements {" + maxState + "} have a suspiciousness of " + df.format(maxValue));

            String parsedLine[] = maxState.split(", ");
            for (int j = 0; j < parsedLine.length; j++)
            {
                result.remove(parsedLine[j]);
            }
            //result.remove(maxState);
        }

        // Failed and Executed: If a line starts with "f", then the test case failed. The numbers that follow represent the statement IDs that were executed during this failed test case.
        //
        //For example, the line f 111 132 146 149 ... means that the test case failed, and during this failed test case, the statements with IDs 111, 132, 146, 149, etc., were executed.
        //
        //Passed and Executed: If a line starts with "p", then the test case passed. The numbers that follow represent the statement IDs that were executed during this passed test case.
        //
        //For example, the line p 111 132 146 149 ... means that the test case passed, and during this passed test case, the statements with IDs 111, 132, 146, 149, etc., were executed.
        //
        //Failed and Not Executed: To find which statements were not executed during the failing tests, you would have to know the complete list of possible statement IDs. Any ID that is not in a "failed" line but is in the complete list was not executed during that failing test.
        //
        //Passed and Not Executed: Similarly, to find which statements were not executed during the passing tests, you would again have to know the complete list of possible statement IDs. Any ID that is not in a "passed" line but is in the complete list was not executed during that passing test.
    }

}

