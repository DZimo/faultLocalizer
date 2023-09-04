package src;

public class main {
    public main(String[] args) throws Exception {
        Script script = new Script();
        CodeTester codeTester = new CodeTester(Script.class.getMethod("scriptExample", int.class), script);
        ErrorCalculator errorCalculator = new ErrorCalculator(codeTester);
        Tarantula taran = new Tarantula(errorCalculator.calculateAllValues());
        System.out.println(taran.metricCalculator());
    }
}
