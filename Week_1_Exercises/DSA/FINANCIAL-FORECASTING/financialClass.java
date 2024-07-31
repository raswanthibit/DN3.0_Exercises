public class FinancialForecasting {

    // Recursive method to calculate future value
    public double calValue(double pv, double r, int n) {
        if (n == 0) {
            return pv; // Base case
        } else {
            return (1 + r) * calValue(pv, r, n - 1); 
        }
    }
}
