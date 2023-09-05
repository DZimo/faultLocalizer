package src;

import static src.MethodLinesCounter.countLinesInMethod;

public class main {
    public static void main(String[] args) throws Exception {
        Script script = new Script();
        CodeTester codeTester = new CodeTester(Script.class.getMethod("scriptExample", int.class), script);
        ErrorCalculator errorCalculator = new ErrorCalculator(codeTester);
        errorCalculator.findTheError();
        double lines = countLinesInMethod("src/main.java", "main");
        System.out.println("Number of lines in method: " + lines);
    }
}
