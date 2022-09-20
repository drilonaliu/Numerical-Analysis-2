package numerical;

public class ComplexVector {

    private Complex[] cv;

    public ComplexVector(int n) {
        cv = new Complex[n];
    }

    public ComplexVector(Complex[] cv) {
        this.cv = cv;
    }

    public ComplexVector(Vector v) {
        cv = new Complex[v.length()];
        for (int i = 0; i < cv.length; i++) {
            cv[i] = new Complex(v.get(i), 0);
        }
    }

    public ComplexVector(ComplexVector complexVector) {
        cv = complexVector.getPrimitive().clone();
    }

    public ComplexVector add(Vector v) {
        return add(new ComplexVector(v));
    }

    public ComplexVector add(ComplexVector a) {
        Complex r[] = new Complex[cv.length];
        Complex b[] = a.getPrimitive();
        for (int i = 0; i < r.length; i++) {
            r[i] = cv[i].add(b[i]);
        }
        return new ComplexVector(r);
    }

    public ComplexVector subtract(Vector v) {
        return subtract(new Vector(v));
    }

    public ComplexVector subtract(ComplexVector a) {
        Complex r[] = new Complex[cv.length];
        Complex b[] = a.getPrimitive();
        for (int i = 0; i < r.length; i++) {
            r[i] = cv[i].subtract(b[i]);
        }
        return new ComplexVector(r);
    }

    public ComplexVector multiply(double k) {
        Complex w = new Complex(k, 0);
        return multiply(w);
    }

    public ComplexVector multiply(Complex k) {
        Complex r[] = new Complex[cv.length];
        for (int i = 0; i < r.length; i++) {
            r[i] = cv[i].multiply(k);
        }
        return new ComplexVector(r);
    }

    public ComplexVector multiply(ComplexMatrix CM) {
        Complex r[] = new Complex[cv.length];
        Complex m[][] = CM.getPrimitive();
        Complex sum = new Complex(0, 0);
        for (int j = 0; j < cv.length; j++) {
            for (int k = 0; k < cv.length; k++) {
                sum = sum.add(cv[k].multiply(m[k][j]));
            }
            r[j] = sum.clone();
            sum = new Complex(0, 0);
        }
        return new ComplexVector(r);
    }

    public ComplexVector divide(Complex k) {
        Complex r[] = new Complex[cv.length];
        for (int i = 0; i < r.length; i++) {
            r[i] = cv[i].divide(k);
        }
        return new ComplexVector(r);
    }

    public Complex[] getPrimitive() {
        return cv;
    }

}
