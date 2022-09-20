import java.text.DecimalFormat;
import numerical.*;

public class Example4 {
    public static void main(String[] args) {

        /*
         * 4) Let matrix A be:
         * 1 0 2
         * 0 -1 -1
         * -1 1 1
         * 
         * An eiguen value of A is 1+ isqrt(3).
         * Matrix cm is cm = A - (1+isqrt(3))*I, where I is a unit matrix.
         * This matrix should be expanded to a matrix with only real coefficients.
         */

        Complex[][] cm = 
                { { c(0, -Math.sqrt(3)), c(0, 0), c(2, 0) },
                { c(0, 0), c(0, -Math.sqrt(3)), c(-1, 0) },
                { c(-1, 0), c(1, 0), c(0, -Math.sqrt(3)) } };

        printMatrix(new ComplexMatrix(cm).expandToReal().getPrimitive());

    }

    public static void printMatrix(double A[][]) {
        String s = "#.##";
        DecimalFormat formatter = new DecimalFormat(s);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                System.out.printf(formatter.format(A[i][j]) + "               ");
            }
            System.out.println("\n");
        }
    }

    private static Complex c(double a, double b) {
        return new Complex(a, b);
    }

}
