package src;

public class main {
    public static void main(String[] args) throws Exception {

        script script = new script();
        //script.scriptExample(0); // here we try to do tests and collect results to get number of errors
        codeTester codeTester = new codeTester(script.class.getMethod("scriptExample", int.class), script);
        codeTester.runTest();
        Tarantula taran = new Tarantula(5,2,3,5);
        System.out.println(taran.metricCalculator());
    }
}
