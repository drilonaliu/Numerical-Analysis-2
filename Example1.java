import numerical.*;

public class Example1 {
    public static void main(String[] args) {

        // Solving system of linear equations Ax = b
        double[][] A = { { 10, 1, 0 },
                { 1, 10, 2 },
                { 0, 2, 10, } };

        double[] X = { 0, 0, 0 };
        double[] B = { 9, 7, 6 };

        System.out.println("---Jacobi Iterative---");
        Solver.jacobiIterative(new Matrix(A), new Vector(B), new Vector(X), 50, 1E-4);
        System.out.println("--Gauss Seidel---");
        Solver.gaussSeidel(new Matrix(A), new Vector(B), new Vector(X), 50, 1E-4).print();
    }
}
