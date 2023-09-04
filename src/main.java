package src;

public class main {
    public static void main(String[] args) throws Exception {
        script script = new script();
        codeTester codeTester = new codeTester(script.class.getMethod("scriptExample", int.class), script);
        errorCalculator errorCalculator = new errorCalculator(codeTester);
        Tarantula taran = new Tarantula(errorCalculator.calculateAllValues());
        System.out.println(taran.metricCalculator());
    }
}
