package src;

public class main {
    public static void main(String[] args) throws Exception {

        script script = new script();
        script.scriptExample(); // here we try to do tests and collect results to get number of errors

        tarantula taran = new tarantula(5,2,3,5);
        System.out.println(taran.metricCalculator());
    }
}
