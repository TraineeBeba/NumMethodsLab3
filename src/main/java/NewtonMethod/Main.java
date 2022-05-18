package NewtonMethod;

public class Main {
    public static void main(String[] args) {
        final double EPS = 0.001;
        double x = 1.25;
        double y = 0;

        NewtonMethod.SolveSystem(x, y, EPS);
    }
}
