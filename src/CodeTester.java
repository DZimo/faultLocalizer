package src;

import java.lang.reflect.Method;

public class CodeTester {
    Method methodToTest;
    Script instanceOfScript;

    public CodeTester(Method method, Script instanceOfScript){
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
