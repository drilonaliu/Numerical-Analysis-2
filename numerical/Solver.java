package numerical;

public class Solver {

    public static Vector jacobiIterative(Matrix A, Vector B, Vector XO, int N0, double TOL) {
        int k = 1;
        int n = A.getPrimitive().length;
        double sum = 0;
        double x_i;
        Vector X = new Vector(n);
        while (k <= N0) {
            for (int i = 0; i < n; i++) {
                sum = 0;
                for (int j = 0; (j < n); j++) {
                    if (i != j) {
                        sum = sum + A.get(i, j) * XO.get(j);
                    }
                }
                x_i = (B.get(i) - sum) / A.get(i, i);
                X.set(i, x_i);
            }

            System.out.println("\nIteration: " + k);
            X.print();

            if ((X.subtract(XO)).infinityNorm() < TOL) {
                System.out.println("Method had success!");
                return X;
            } else {
                k = k + 1;
                XO = X.clone();
            }
        }
        throw new ArithmeticException("Maximal number of iteration exceeded!");
    }

    public static Vector gaussSeidel(Matrix A, Vector B, Vector XO, int N0, double TOL) {
        int k = 1;
        int n = A.getPrimitive().length;
        double sum1;
        double sum2;
        double x_i;
        Vector X = new Vector(n);

        while (k <= N0) {
            for (int i = 0; i < n; i++) {
                sum1 = 0;
                sum2 = 0;
                for (int j = 0; j < i; j++) {
                    sum1 = sum1 + A.get(i, j) * X.get(i);
                }
                for (int j = i + 1; j < n; j++) {
                    sum2 = sum2 + A.get(i, j) * XO.get(j);
                }
                x_i = (-sum1 - sum2 + B.get(i)) / A.get(i, i);
                X.set(i, x_i);
            }

            System.out.println("\nIteracion: " + k);
            X.print();

            if ((X.subtract(XO)).infinityNorm() < TOL) {
                System.out.println("Method had success!");
                return X;
            }
            k = k + 1;
            XO = X.clone();
        }
        throw new ArithmeticException("Maximal number of iteration exceeded!");
    }
}
