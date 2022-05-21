package NewtonMethod;

public class Printer {
    /**
     * Вивід матриці
     */
    static final void printMatrix(double[][] m) {
        for (double[] doubles : m) {
            for (double aDouble : doubles) {
                System.out.printf("%8.3f", aDouble);
            }
            System.out.println();
        }
    }
}
