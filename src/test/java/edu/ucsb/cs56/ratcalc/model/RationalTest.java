package edu.ucsb.cs56.ratcalc.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class RationalTest {

    private Rational r_5_15;
    private Rational r_24_6;
    private Rational r_3_7;
    private Rational r_13_4;
    private Rational r_20_25;
    private Rational r_25_20;
    private Rational r_0_1;
    private Rational r_m3_7;

    @Before
    public void setUp() {
        r_5_15 = new Rational(5, 15);
        r_24_6 = new Rational(24, 6);
        r_3_7 = new Rational(3, 7);
        r_13_4 = new Rational(13, 4);
        r_20_25 = new Rational(20, 25);
        r_0_1 = new Rational(0, 1);
	    r_m3_7 = new Rational(-3, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_denom_zero() {
        Rational r = new Rational(1, 0);
    }

    @Test
    public void test_getNumerator_20_25() {
        assertEquals(4, r_20_25.getNumerator());
    }

    @Test
    public void test_getNumerator_13_4() {
        assertEquals(13, r_13_4.getNumerator());
    }

    @Test
    public void test_getDenominator_20_25() {
        assertEquals(5, r_20_25.getDenominator());
    }

    @Test
    public void test_getDenominator_13_4() {
        assertEquals(4, r_13_4.getDenominator());
    }

    @Test
    public void test_toString_5_15() {
        assertEquals("1/3", r_5_15.toString());
    }

    @Test
    public void test_toString_24_6() {
        assertEquals("4", r_24_6.toString());
    }

    @Test
    public void test_toString_3_7() {
        assertEquals("3/7", r_3_7.toString());
    }

    @Test
    public void test_toString_20_25() {
        assertEquals("4/5", r_20_25.toString());
    }

    @Test
    public void test_toString_0_1() {
        assertEquals("0", r_0_1.toString());
    }

    @Test
    public void test_gcd_5_15() {
        assertEquals(5, Rational.gcd(5, 15));
    }

    @Test
    public void test_gcd_15_5() {
        assertEquals(5, Rational.gcd(15, 5));
    }

    @Test
    public void test_gcd_24_6() {
        assertEquals(6, Rational.gcd(24, 6));
    }

    @Test
    public void test_gcd_17_5() {
        assertEquals(1, Rational.gcd(17, 5));
    }

    @Test
    public void test_gcd_1_1() {
        assertEquals(1, Rational.gcd(1, 1));
    }

    @Test
    public void test_gcd_20_25() {
        assertEquals(5, Rational.gcd(20, 25));
    }

    @Test
    public void test_rational_m10_m5() {
        Rational r = new Rational(-10, -5);
        assertEquals("2", r.toString());
    }

    @Test
    public void test_rational_m5_6() {
        Rational r = new Rational(-5, 6);
        assertEquals("-5/6", r.toString());
    }

    @Test
    public void test_rational_7_m8() {
        Rational r = new Rational(7, -8);
        assertEquals("-7/8", r.toString());
    }

    @Test
    public void test_r_5_15_times_r_3_7() {
        Rational r = r_5_15.times(r_3_7);
        assertEquals("1/7", r.toString());
    }

    @Test
    public void test_r_3_7_times_r_13_4() {
        Rational r = r_3_7.times(r_13_4);
        assertEquals("39/28", r.toString());
    }

    @Test
    public void test_r_m3_1_times_1_m3() {
        Rational r_m3_1 = new Rational(-3, 1);
        Rational r_1_m3 = new Rational(1, -3);
        Rational r = r_m3_1.times(r_1_m3);
        assertEquals("1", r.toString());
    }

    @Test
    public void test_product_of_r_5_15_and_r_3_7() {
        Rational r = Rational.product(r_5_15, r_3_7);
        assertEquals("1/7", r.toString());
    }

    @Test
    public void test_product_of_r_3_7_and_r_13_4() {
        Rational r = Rational.product(r_3_7, r_13_4);
        assertEquals("39/28", r.toString());
    }

    @Test
    public void test_product_of_r_m3_1_and_1_m3() {
        Rational r_m3_1 = new Rational(-3, 1);
        Rational r_1_m3 = new Rational(1, -3);
        Rational r = Rational.product(r_m3_1, r_1_m3);
        assertEquals("1", r.toString());
    }


    /* 
     * Test LCM
     */

    @Test
    public void test_lcm_3_4(){
	    int result = Rational.lcm(3,4);
	    assertEquals(12, result);
    }

    @Test
    public void test_lcm_10_15(){
        int result = Rational.lcm(-10,15);
        assertEquals(30, result);
    }

    @Test
    public void test_lcm_7_13(){
        int result = Rational.lcm(-7,-13);
        assertEquals(-91, result);
    }


	
    /* 
    * Test plus
    */

    @Test
    public void test_plus_5_15__20_25(){
	    Rational result = r_5_15.plus(r_20_25); 
        assertEquals("17/15", result.toString());
    }

    @Test
    public void test_plus_24_6__0_1(){

        Rational result = r_24_6.plus(r_0_1);
        assertEquals("4", result.toString());
    }

    @Test
    public void test_plus_3_7__13_4(){

        Rational result = r_3_7.plus(r_13_4);
        assertEquals("103/28", result.toString());
    }




    /*
    * Test minus
    */

    @Test
    public void test_minus_5_15__20_25(){

        Rational result = r_5_15.minus(r_20_25);
        assertEquals("-7/15", result.toString());
    }

    @Test
    public void test_minus_24_6__0_1(){

        Rational result = r_24_6.minus(r_0_1);
        assertEquals("4", result.toString());
    }

    @Test
    public void test_minus_3_7__13_4(){

        Rational result = r_3_7.minus(r_13_4);
        assertEquals("-79/28", result.toString());
    }





    /*
    * Test divide
    */

    @Test
    public void divide_5_15__20_25(){

        Rational result = r_5_15.dividedBy(r_20_25);
        assertEquals("5/12", result.toString());
    }

    @Test
    public void test_divide_24_6__0_1(){

        Rational result = r_24_6.dividedBy(r_20_25);
        assertEquals("5", result.toString());
    }

    @Test
    public void test_divide_3_7__13_4(){

        Rational result = r_3_7.dividedBy(r_13_4);
        assertEquals("12/91", result.toString());
    }




    /*
    * Test sum
    */

    @Test
    public void test_sum_5_15__20_25(){

        Rational result = Rational.sum(r_5_15,r_20_25);
        assertEquals("17/15", result.toString());
    }

    @Test
    public void test_sum_24_6__0_1(){

        Rational result = Rational.sum(r_24_6,r_0_1);
        assertEquals("4", result.toString());
    }

    @Test
    public void test_sum_3_7__13_4(){

        Rational result = Rational.sum(r_3_7,r_13_4);
        assertEquals("103/28", result.toString());
    }



    /*
    * Test difference
    */

    @Test
    public void test_difference_5_15__20_25(){

        Rational result = Rational.difference(r_5_15,r_20_25);
        assertEquals("-7/15", result.toString());
    }

    @Test
    public void test_difference_24_6__0_1(){

        Rational result = Rational.difference(r_24_6,r_0_1);
        assertEquals("4", result.toString());
    }

    @Test
    public void test_difference_3_7__13_4(){

        Rational result = Rational.difference(r_3_7,r_13_4);
        assertEquals("-79/28", result.toString());
    }



    /*
    * Test quotient
    */

    @Test
    public void quotient_5_15__20_25(){

        Rational result = Rational.quotient(r_5_15,r_20_25);
        assertEquals("5/12", result.toString());
    }

    @Test
    public void test_quotient_24_6__0_1(){

        Rational result = Rational.quotient(r_24_6,r_20_25);
        assertEquals("5", result.toString());
    }

    @Test
    public void test_quotient_3_7__13_4(){

        Rational result = Rational.quotient(r_3_7,r_13_4);
        assertEquals("12/91", result.toString());
    }


    /*
     * test ReciprocalOf()
     */

    @Test
    public void test_reciprocal_5_15(){

        Rational result = r_5_15.reciprocalOf();
        assertEquals("3", result.toString());
    }

    @Test
    public void test_reciprocal_24_6(){

        Rational result = r_24_6.reciprocalOf();
        assertEquals("1/4", result.toString());
    }

    @Test
    public void test_reciprocal_m3_7(){

        Rational result = r_m3_7.reciprocalOf();
        assertEquals("-7/3", result.toString());
    }






}
