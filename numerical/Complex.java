package numerical;

public class Complex {
    private double a;
    private double b;

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Complex add(Complex w) {
        double c = w.getReal();
        double d = w.getImaginary();
        return new Complex(a + c, b + d);
    }

    public Complex subtract(Complex w) {
        double c = w.getReal();
        double d = w.getImaginary();
        return new Complex(a + c, b + d);
    }

    public Complex multiply(double k) {
        return new Complex(a * k, b * k);
    }

    public Complex multiply(Complex w) {
        double c = w.getReal();
        double d = w.getImaginary();
        return new Complex(a * c - b * d, a * d + b * c);
    }

    public Complex divide(Complex w) {
        double c = w.getReal();
        double d = w.getImaginary();
        double denominator = c * c + d * d;
        double num1 = a * c + b * d;
        double num2 = b * c - a * d;
        return new Complex(num1 / denominator, num2 / denominator);
    }

    public Complex conjugate() {
        return new Complex(a, -b);
    }

    public double module() {
        return Math.sqrt(a * a + b * b);
    }

    public double getReal() {
        return a;
    }

    public double getImaginary() {
        return b;
    }

    public Complex clone() {
        return new Complex(a, b);
    }

    @Override
    public String toString() {
        String str;
        if (b >= 0) {
            str = a + "+i" + b;
        } else {
            str = a + "i" + b;
        }

        return str;
    }
}
