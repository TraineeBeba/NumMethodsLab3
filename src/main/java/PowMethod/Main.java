package PowMethod;

public class Main {

    public static void main(String[] args) {
        final double EPS = 0.001;
        final double[][] A = {
                {1.0 , 0.5 , 1.0/3.0},
                {0.5 , 1.0/3.0 , 1.0/4.0},
                {1.0/3.0 , 1.0/4.0 , 1.0/5.0}
        };

//        final double EPS = 0.5;
//        final double[][] A = {
//                {2, -1, 0},
//                {-1, 2, -1},
//                {0, -1, 2},
//        };

        double answer = PowMethod.getMinEigenValue(A , EPS);

        System.out.printf("Min eigenvalue = %.3f", answer);
    }
}