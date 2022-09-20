package numerical;

public class ComplexMatrix {
    private Complex[][] CM;
    private int rows;
    private int columns;

    public ComplexMatrix(Complex[][] CM) {
        this.CM = CM;
        rows = CM.length;
        columns = CM[0].length;
    }

    public ComplexMatrix(int n) {
        CM = new Complex[n][n];
    }

    public ComplexMatrix(int n, int m) {
        CM = new Complex[n][m];
    }

    ComplexMatrix(Matrix M) {
        for (int i = 0; i < CM.length; i++) {
            for (int j = 0; j < CM.length; j++) {
                CM[i][j] = new Complex(M.get(i, j), 0);
            }
        }
    }

    public ComplexMatrix add(ComplexMatrix A) {
        Complex[][] R = new Complex[rows][columns];
        Complex[][] B = A.getPrimitive();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                R[i][j] = CM[i][j].add(B[i][j]);
            }
        }
        return new ComplexMatrix(R);
    }

    public ComplexMatrix subtract(ComplexMatrix A) {
        Complex[][] R = new Complex[rows][columns];
        Complex[][] B = A.getPrimitive();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                R[i][j] = CM[i][j].subtract(B[i][j]);
            }
        }
        return new ComplexMatrix(R);
    }

    public ComplexMatrix multiply(double k) {
        Complex[][] R = new Complex[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                R[i][j] = CM[i][j].multiply(k);
            }
        }
        return new ComplexMatrix(R);
    }

    public ComplexVector multiply(Vector v) {
        return multiply(new ComplexVector(v));
    }

    public ComplexVector multiply(ComplexVector V) {
        Complex[] r = new Complex[V.getPrimitive().length];
        Complex[] b = V.getPrimitive();
        Complex sum = new Complex(0, 0);
        for (int i = 0; i < CM.length; i++) {
            for (int k = 0; k < CM.length; k++) {
                sum = sum.add(CM[i][k].multiply(b[k]));
            }
            r[i] = sum;
            sum = new Complex(0, 0);
        }

        return new ComplexVector(r);
    }

    public ComplexMatrix multiply(Matrix A) {
        Complex[][] R = new Complex[rows][columns];
        double B[][] = A.getPrimitive();
        Complex sum = new Complex(0, 0);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < rows; k++) {
                    sum = sum.add(CM[i][k].multiply(B[k][j]));
                }
                R[i][j] = sum.clone();
                sum = new Complex(0, 0);
            }
        }
        return new ComplexMatrix(R);
    }

    public Complex[][] getPrimitive() {
        return CM;
    }

    public Complex get(int i, int j) {
        return CM[i][j];
    }

    public Matrix expandToReal() {
        int n = rows;
        double[][] M = new double[2 * n][2 * n];
        for (int i = 0; i < CM.length; i++) {
            for (int j = 0; j < CM.length; j++) {
                Complex Z = this.get(i, j);
                double a = Z.getReal();
                double b = Z.getImaginary();
                M[2 * i][2 * j] = a;
                M[2 * i + 1][2 * j] = b;
                M[2 * i][2 * j + 1] = -1.0 * b;
                M[2 * i + 1][2 * j + 1] = a;
            }
        }
        return new Matrix(M);
    }
}
