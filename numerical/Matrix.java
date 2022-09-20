package numerical;

public class Matrix {

    private double[][] M;
    private int rows;
    private int columns;

    public Matrix(double[][] M) {
        this.M = M;
        rows = M.length;
        columns = M[0].length;
    }

    public Matrix(int n, int m) {
        M = new double[n][m];
    }

    public Matrix(int n) {
        M = new double[n][n];
    }

    public Matrix add(Matrix A) {
        double R[][] = new double[rows][columns];
        double B[][] = A.getPrimitive();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                R[i][j] = M[i][j] + B[i][j];
            }
        }
        return new Matrix(R);
    }

    public Matrix subtract(Matrix A) {
        double R[][] = new double[rows][columns];
        double B[][] = A.getPrimitive();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                R[i][j] = M[i][j] - B[i][j];
            }
        }
        return new Matrix(R);
    }

    public Matrix multiply(double k) {
        double R[][] = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                R[i][j] = k * M[i][j];
            }
        }
        return new Matrix(R);
    }

    public Vector multiply(Vector V) {
        double[] r = new double[V.getPrimitive().length];
        double[] b = V.getPrimitive();
        double sum = 0;
        for (int i = 0; i < M.length; i++) {
            for (int k = 0; k < M.length; k++) {
                sum = sum + M[i][k] * b[k];
            }
            r[i] = sum;
            sum = 0;
        }

        return new Vector(r);
    }

    public Matrix multiply(Matrix A) {
        double R[][] = new double[rows][columns];
        double B[][] = A.getPrimitive();
        double sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < rows; k++) {
                    sum = sum + M[i][k] * B[k][j];
                }
                R[i][j] = sum;
                sum = 0;
            }
        }
        return new Matrix(R);
    }

    public boolean converges(double tol, int max) {
        Matrix M1 = new Matrix(M);
        double[][] A;
        boolean found = false;
        int k = 1;
        while (k <= max && !found) {
            M1 = M1.multiply(this);
            A = M1.getPrimitive();
            boolean converge = true;
            for (int i = 0; i < rows && converge; i++) {
                for (int j = 0; j < columns; j++) {
                    if (A[i][j] > tol) {
                        converge = false;
                        break;
                    }
                }
            }
            if (converge) {
                found = true;
            }
            k = k + 1;
        }
        return found;
    }

    public double infinityNorm() {
        double row_sum = 0;
        double max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                row_sum = row_sum + Math.abs(M[i][j]);
            }
            if (max < row_sum) {
                max = row_sum;
            }
            row_sum = 0;
        }
        return max;
    }

    public double frobeniusNorm() {
        double sum = 0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                sum = sum + M[i][j] * M[i][j];
            }
        }
        return Math.sqrt(sum);
    }

    public EiugenVector powerMethod(Vector X, double TOL, int N) {
        int k = 1;
        int p = 0;
        int p2 = 0;
        double u;
        double ERR;
        Vector Y;
        EiugenVector ev;

        Y = new Vector(X.length());
        p = X.minIndexNorm();

        while (k <= N) {
            Y = new Vector(this.multiply(X));
            u = Y.get(p);
            p2 = Y.minIndexNorm();

            if (Y.get(p2) == 0) {
                throw new ArithmeticException(" Matrix has eigunvalue 0, select new vector x and restart");
            } else {
                Vector Z = new Vector(Y.divide(Y.get(p)));
                ERR = X.subtract(Z).infinityNorm();
                X = new Vector(Z);
                if (ERR < TOL) {
                    ev = new EiugenVector(X, u);
                    System.out.println("Success!");
                    ev.print();
                    return ev;
                }
                k = k + 1;
            }
        }
        throw new ArithmeticException("Maximum of number exceeted, process failed");
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public boolean equals(Matrix A) {
        boolean equal = true;
        double M2[][] = A.getPrimitive();
        for (int i = 0; i < M.length && equal; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] != M2[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        return equal;
    }

    @Override
    protected Matrix clone() throws CloneNotSupportedException {
        return new Matrix(M.clone());
    }

    public double get(int i, int j) {
        return M[i][j];
    }

    public double[][] getPrimitive() {
        return M;
    }

}
