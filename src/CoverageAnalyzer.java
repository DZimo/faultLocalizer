package src;

/*
import org.jacoco.core.analysis.*;
import org.jacoco.core.data.ExecutionData;
import org.jacoco.core.data.ExecutionDataReader;
import org.jacoco.core.data.ExecutionDataStore;
import org.jacoco.core.data.SessionInfoStore;
import org.jacoco.core.tools.ExecFileLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
*/

public class CoverageAnalyzer {

    /*
    public void analyzeCoverage() throws IOException {
            // Load JaCoCo execution data (.exec file)
            File execFile = new File("path/to/jacoco.exec");
            ExecFileLoader execFileLoader = new ExecFileLoader();
            execFileLoader.load(execFile);

            // Create a coverage analyzer
            final CoverageBuilder coverageBuilder = new CoverageBuilder();
            final Analyzer analyzer = new Analyzer(execFileLoader.getExecutionDataStore(), coverageBuilder);

            // Provide the class file for analysis (This should be the compiled .class file)
            analyzer.analyzeAll(new File("path/to/Script.class"));

            // Loop over all classes
            for (final IClassCoverage cc : coverageBuilder.getClasses()) {
                // Loop over every method in the class
                for (IMethodCoverage method : cc.getMethods()) {
                    // Check if it's the method we're interested in
                    if ("scriptExample".equals(method.getName())) {
                        System.out.println("Method: " + method.getName());

                        // Loop over each line in the method
                        for (int i = method.getFirstLine(); i <= method.getLastLine(); i++) {
                            ILine line = method.getLine(i);

                            // Check if the line has been executed
                            if (line.getStatus() == ICounter.FULLY_COVERED || line.getStatus() == ICounter.PARTLY_COVERED) {
                                System.out.println("Line " + i + " has been executed.");
                            } else {
                                System.out.println("Line " + i + " has NOT been executed.");
                            }
                        }
                    }
                }
            }
        }*/
}

