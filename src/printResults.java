package src;

public class printResults {
    int totalOfLines;
    int lineNumber;
    int result;

    public printResults(int totalOfLines, int lineNumber, int result) {
        this.totalOfLines = totalOfLines;
        this.lineNumber = lineNumber;
        this.result = result;
    }

    public void printAll(int totalOfLines, int result)
    {
        int lineNumber=0;
        for (int i = 0; i < totalOfLines; i++)
        {
            System.out.println(lineNumber + " " + result );
            lineNumber++;
        }
    }
}
