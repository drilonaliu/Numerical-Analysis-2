package numerical;

public class Vector {

    private double[] v;

    public Vector(int n) {
        v = new double[n];
    }

    public Vector(double[] v) {
        this.v = v;
    }

    public Vector(Vector vector) {
        v = vector.getPrimitive().clone();
    }

    public Vector add(Vector a) {
        double r[] = new double[v.length];
        double b[] = a.getPrimitive();
        for (int i = 0; i < r.length; i++) {
            r[i] = v[i] + b[i];
        }
        return new Vector(r);
    }

    public Vector subtract(Vector a) {
        double r[] = new double[v.length];
        double b[] = a.getPrimitive();
        for (int i = 0; i < r.length; i++) {
            r[i] = v[i] - b[i];
        }
        return new Vector(r);
    }

    public Vector multiply(double k) {
        double r[] = new double[v.length];
        for (int i = 0; i < r.length; i++) {
            r[i] = k * v[i];
        }
        return new Vector(r);
    }

    public Vector multiply(Matrix M) {
        double r[] = new double[v.length];
        double m[][] = M.getPrimitive();
        double sum = 0;
        for (int j = 0; j < v.length; j++) {
            for (int k = 0; k < v.length; k++) {
                sum = sum + v[k] * m[k][j];
            }
            r[j] = sum;
            sum = 0;
        }
        return new Vector(r);
    }

    public Vector divide(double k) {
        double r[] = new double[v.length];
        for (int i = 0; i < r.length; i++) {
            r[i] = v[i] / (k * 1.0);
        }
        return new Vector(r);
    }

    public Vector orthogonalVector() {
        double norm = infinityNorm();
        double r[] = new double[v.length];
        for (int i = 0; i < r.length; i++) {
            r[i] = v[i] / norm;
        }
        return new Vector(r);
    }

    public void print() {
        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i] + " ");
        }
    }

    public int length() {
        return v.length;
    }

    public int minIndexNorm() {
        int n = v.length;
        int p = 0;
        double norm = this.infinityNorm();
        for (int i = 0; i < n; i++) {
            if (Math.abs(v[i]) == norm) {
                p = i;
                i = n + 1;
                break;
            }
        }
        return p;
    }

    /**
     * Infinity norm
     * 
     * @returns maximum of absoulute value of elements of the vector
     */
    public double infinityNorm() {
        double max = 0;
        for (int i = 0; i < v.length; i++) {
            double z = Math.abs(v[i]);
            if (max < z) {
                max = z;
            }
        }
        return max;
    }

    public double euclidianNorm() {
        double sum = 0;
        for (int i = 0; i < v.length; i++) {
            sum = sum + v[i] * v[i];
        }
        return Math.sqrt(sum);
    }

    public void set(int i, double x) {
        v[i] = x;
    }

    public double get(int i) {
        return v[i];
    }

    public double[] getPrimitive() {
        return v;
    }

    public Vector clone() {
        return new Vector(v.clone());
    }

}
