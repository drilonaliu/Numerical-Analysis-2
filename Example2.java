import numerical.*;
public class Example2 {
    public static void main(String[] args) {

        /* Does the matrix converge
         * 
         * 
         * 1/2 0 
         * 1/4 1/2
         */
        double[][] A = { { 0.5, 0 },
                { 0.25, 0.5 } };

        boolean converge = new Matrix(A).converges(1E-4, 30);
        System.out.println("Does A converge? " + converge);
    }
}
