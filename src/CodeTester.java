package src;

import java.lang.reflect.Method;

public class CodeTester {
    Method methodToTest;
    Script instanceOfScript;
    int failCount;

    public CodeTester(Method method, Script instanceOfScript){
        this.methodToTest=method;
        this.instanceOfScript = instanceOfScript;
    }

    public void runTest(int argToPass) {
        try {
            methodToTest.invoke(instanceOfScript,argToPass);
            System.out.println("Method executed successfully.");
        } catch (Exception e) {
            failCount++;
            System.out.println("An error occurred during method execution: " + e.getMessage());
        }
    }

    // Getter for failCount
    public int getExceptionCount() {
        return failCount;
    }
}
