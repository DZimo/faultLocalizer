package src;

import java.lang.reflect.Method;

public class codeTester {
    Method methodToTest;
    script instanceOfScript;

    public codeTester (Method method, script instanceOfScript){
        this.methodToTest=method;
        this.instanceOfScript = instanceOfScript;
    }

    public void runTest(int argToPass) {
        try {
            methodToTest.invoke(instanceOfScript,argToPass);
            System.out.println("Method executed successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred during method execution: " + e.getMessage());
        }
    }
}
