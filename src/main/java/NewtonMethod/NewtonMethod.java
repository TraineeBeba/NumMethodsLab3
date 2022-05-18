package NewtonMethod;

import static java.lang.Math.*;

public class NewtonMethod {
    static double F1(double x, double y)
    {
        return sin(x - 0.6) - y - 1.6;
    }
    static double Derivative_F1_X(double x, double y)
    {
        return cos(0.6 - x);
    }
    static double Derivative_F1_Y(double x, double y)
    {
        return -1;
    }

    static double F2(double x, double y)
    {
        return 3*x - cos(y) - 0.9;
    }
    static double Derivative_F2_X(double x, double y)
    {
        return 3;
    }
    static double Derivative_F2_Y(double x, double y)
    {
        return sin(y);
    }

    static double[][] Inverse_Matrix(double[][] A)
    {
        double det = A[0][0] * A[1][1] - A[0][1] * A[1][0];
        double temp = A[0][0];

        A[0][0] = A[1][1] / det;
        A[1][1] = temp / det;

        A[0][1] = -A[0][1] / det;
        A[1][0] = -A[1][0] / det;

        return A;
    }

    static void SolveSystem(double x, double y, final double epsilon)
    {
        double[][] A = {
                    {0 , 0 },
                    {0 , 0 }
                };

        double[] B = new double[A.length];
        double z;

        do
        {
            A[0][0] = Derivative_F1_X(x, y);
            A[0][1] = Derivative_F1_Y(x, y);

            A[1][0] = Derivative_F2_X(x, y);
            A[1][1] = Derivative_F2_Y(x, y);

            Inverse_Matrix(A);

            double dx = -A[0][0] * F1(x, y) - A[0][1] * F2(x, y);
            double dy = -A[1][0] * F1(x, y) - A[1][1] * F2(x, y);

            x = x + dx;
            y = y + dy;

            B[0] = F1(x, y);
            B[1] = F2(x, y);

            z = sqrt(B[0] * B[0] + B[1] * B[1]);

        } while (z >= epsilon);

        System.out.println("x = " + x + "\n" + "y = " + y);
    }
}
