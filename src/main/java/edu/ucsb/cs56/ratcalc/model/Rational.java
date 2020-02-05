/**
 * A class to represent a rational number with a numerator and denominator
 *
 * @author P. Conrad for CS56 F16
 *
 */

package edu.ucsb.cs56.ratcalc.model;

public class Rational {

    private int num;
    private int denom;

    /**
     * greatest common divisor of a and b
     *
     * @param a first number
     * @param b second number
     * @return gcd of a and b
     */
    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        else if (b == 0)
            return a;
        else
            return gcd(b % a, a);
    }

    public Rational() {
        this.num = 1;
        this.denom = 1;
    }

    public Rational(int num, int denom) {
        if (denom == 0) {
            throw new IllegalArgumentException("denominator may not be zero");
        }
        this.num = num;
        this.denom = denom;
        if (num != 0) {
            int gcd = Rational.gcd(num, denom);
            this.num /= gcd;
            this.denom /= gcd;
        }


	if (this.denom < 0){
		this.num *= -1;
		this.denom *= -1;
	}
    }

    public String toString() {
        if (denom == 1 || num == 0)
            return "" + num;
        return num + "/" + denom;
    }

    public int getNumerator() {
        return this.num;
    }

    public int getDenominator() {
        return this.denom;
    }

    public Rational times(Rational r) {
        return new Rational(this.num * r.num, this.denom * r.denom);
    }

    public static Rational product(Rational a, Rational b) {
        return new Rational(a.num * b.num, a.denom * b.denom);
    }



    public static int lcm(int a, int b){
    	
	return Math.abs(a*b)/gcd(a,b);
    }

    public Rational plus(Rational r){
	
	int res_denom = Rational.lcm(this.denom, r.denom);

	int num1 = (res_denom/this.denom) * this.num;
	int num2 = (res_denom/r.denom) * r.num;
	int res_num = num1 + num2;

	Rational result = new Rational(res_num, res_denom);
	return result;
    }

    public static Rational sum(Rational a, Rational b){
	
	int res_denom = Rational.lcm(a.denom, b.denom);

        int num1 = (res_denom/a.denom) * a.num;
        int num2 = (res_denom/b.denom) * b.num;
        int res_num = num1 + num2;

        Rational result = new Rational(res_num, res_denom);
        return result;
    }

    public Rational minus(Rational r){
    	
	Rational neg = new Rational(-1,1);
        return this.plus(r.times(neg));	
    }

    public static Rational difference(Rational a, Rational b){
	Rational neg = new Rational(-1,1);
	return Rational.sum(a,b.times(neg));
    }

    public Rational reciprocalOf(){
	
	if (this.num == 0) throw new ArithmeticException("numerator can not be 0");

	int res_num = this.denom;
	int res_denom = this.num;

	Rational result = new Rational(res_num, res_denom);

	return result;
    }

    public Rational dividedBy(Rational r){

	return this.times(r.reciprocalOf());

    }

    public static Rational quotient(Rational a, Rational b){
	
	return Rational.product(a, b.reciprocalOf());
    }





    /**
     * For testing getters.
     *
     * @param args unused
     */

    public static void main(String[] args) {
        Rational r = new Rational(5, 7);
        System.out.println("r.getNumerator()=" + r.getNumerator());
        System.out.println("r.getDenominator()=" + r.getDenominator());
    }

}
