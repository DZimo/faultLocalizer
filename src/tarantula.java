package src;

public class tarantula {

    public double CexecutionFail, CnoExecutionFail, CexecutionPass, CnoExecutionPass;
    public tarantula(int CexecutionFail, int CnoExecutionFail, int CexecutionPass, int CnoExecutionPass) {
        this.CexecutionFail = CexecutionFail;
        this.CnoExecutionFail = CnoExecutionFail;
        this.CexecutionPass = CexecutionPass;
        this.CnoExecutionPass = CnoExecutionPass;
    }

    public double metricCalculator() throws Exception {
        if((CexecutionFail+CnoExecutionFail) != 0)
        {
            double a = CexecutionFail/ (CexecutionFail+CnoExecutionFail);
            double b = (CexecutionFail/(CexecutionFail+CnoExecutionFail) ) + (CexecutionPass/(CexecutionPass+CnoExecutionPass) );
            if(b == 0)
            {
                throw new Exception("You must fix your values!");
            }
            return  a  / b;
        }
        else throw new Exception("You must fix your values!");
    }
}
