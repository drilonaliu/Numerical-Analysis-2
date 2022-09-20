import numerical.Matrix;
import numerical.Vector;

public class Example3 {
    public static void main(String[] args) {

        // Finding the eigenvalue and eigenvector of A with the power method
        double[][] A = {
                { -4, 14, 0 },
                { -5, 13, 0 },
                { -1, 0, 2 } };

        double[] x = { 1, 1, 1 };

        Matrix M = new Matrix(A);
        M.powerMethod(new Vector(x.clone()), 1e-3, 13);

    }
}
