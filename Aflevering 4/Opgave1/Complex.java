
// Object for storing and calculating with complex numbers
public class Complex {

    private double re;
    private double im;

    public Complex() {
        this.re = 0.0;
        this.im = 0.0;
    }

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public Complex(Complex z) {
        this.re = z.getRe();
        this.im = z.getIm();
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public double abs() {
        return Math.sqrt(Math.pow(this.re, 2) + Math.pow(this.im, 2));
    }

    public Complex plus(Complex other) {
        double newRe = this.re + other.getRe();
        double newIm = this.im + other.getIm();
        return new Complex(newRe, newIm);
    }

    public Complex times(Complex other) {
        double newRe = (this.re * other.re) - (this.im * other.im);
        double newIm = (this.im * other.re) + (this.re * other.im);
        return new Complex(newRe, newIm);
    }

    public String toString() {
        if (this.im >= 0) {
            return String.valueOf(this.re) + " + " + String.valueOf(this.im) + "i";
        } else {
            return String.valueOf(this.re) + " - " + String.valueOf(Math.abs(this.im)) + "i";
        }
    }

}
