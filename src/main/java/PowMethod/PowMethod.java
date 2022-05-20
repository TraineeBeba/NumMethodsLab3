package PowMethod;

public class PowMethod {
    private static final double[][] E = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
    };

    private static double A_between_two_double_lines;

    static void find_A_between_two_double_lines(double[][] A) {
        double[] temp = new double[A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                temp[i] += Math.abs(A[i][j]);
            }
        }

        double max = temp[0];
        for (int i = 1; i < temp.length; i++) {
            if (max < temp[i]) max = temp[i];
        }
        A_between_two_double_lines = max;
    }

    private static double normalize(double[] xn1) {
        double norm = 0;
        for (double v : xn1) {
            norm += Math.pow(v, 2);
        }
        return Math.sqrt(norm);
    }

    static double[][] find_B(double[][] A) {
        double[][] B = new double [E.length][E.length];
        for (int i = 0; i < E.length; i++) {
            E[i][i] *= A_between_two_double_lines;
        }

        for (int i = 0; i < E.length; i++) {
            for (int j = 0; j < E.length; j++) {
                B[i][j] = E[i][j] - A[i][j];
            }
        }
        return B;
    }

    static double findMaxEigenValueForB(final double[][] B, final double EPS) {
        double[] Xn = new double[B.length];
        for (int i = 0; i < B.length; i++) {
            Xn[i] = 1;
        }
        double[] Xn1;

        double lambda = 20;
        double lambda_prev;

        do {
            Xn1 = MtrUtil.multiply(B, Xn);
            someMagicWithZeroCheck(EPS, Xn1);

            lambda_prev = lambda;

            lambda = Xn1[2] / Xn[2];

            double norm = normalize(Xn1);

            for (int i = 0; i < Xn1.length; i++) {
                Xn1[i] /= norm;
            }

            Xn = Xn1;

        } while ((Math.abs(lambda - lambda_prev)) > EPS);
        return lambda;
    }

    private static void someMagicWithZeroCheck(double EPS, double[] Xn1) {
        for (int i = 0; i < Xn1.length; i++) {
            if(Xn1[i] < EPS && Xn1[i] > -EPS) {
                Xn1[i] = 0.0;
            }
        }
    }

    static double getMinEigenValue(final double[][] A, final double EPS) {
        find_A_between_two_double_lines(A);
        double[][] B = find_B(A);
        return A_between_two_double_lines - findMaxEigenValueForB(B, EPS);
    }
}
