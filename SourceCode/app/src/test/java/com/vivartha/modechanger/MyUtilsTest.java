package com.vivartha.modechanger;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyUtilsTest {

    @Test
    public void isEmailValidEmail1() {
        boolean expected =  true;
        boolean output;
        MyUtils myUtils = new MyUtils();
        output = myUtils.isEmailValid("saikrishna.andydev@gmail.com");
        assertEquals(expected, output);
    }

    @Test
    public void isEmailValidEmail2() {
        boolean expected =  true;
        boolean output;
        MyUtils myUtils = new MyUtils();
        output = myUtils.isEmailValid("saikrishnaandydev@gmail.com");
        assertEquals(expected, output);

    }

    @Test
    public void isEmailValidEmail3() {
        boolean expected =  false;
        boolean output;

        MyUtils myUtils = new MyUtils();
        output = myUtils.isEmailValid("saikrishnaandydevgmail.com");//no @
        assertEquals(expected, output);

    }


    @Test
    public void isEmailValidEmail4() {
        boolean expected =  false;
        boolean output;

        MyUtils myUtils = new MyUtils();
        output = myUtils.isEmailValid("saikrishnaandydev@gmailcom");//no .com
        assertEquals(expected, output);

    }



    @Test
    public void isEmailValidEmail5() {
        boolean expected =  true;
        boolean output;

        MyUtils myUtils = new MyUtils();
        output = myUtils.isEmailValid("saikrishnaandydev@gmail.in");// .in
        assertEquals(expected, output);

    }

    @Test
    public void isEmailValidEmail6() {
        boolean expected =  true;
        boolean output;

        MyUtils myUtils = new MyUtils();
        output = myUtils.isEmailValid("krishna@gmail.com");// small length
        assertEquals(expected, output);

    }


    @Test
    public void isPasswordValid() {

        boolean expected = true;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isPasswordValid("Saikrishna@123");
        assertEquals(expected, output);

    }

    @Test
    public void isPasswordVali2() {

        boolean expected = true;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isPasswordValid("sAikrishna@123");
        assertEquals(expected, output);

    }


    @Test
    public void isPasswordVali3() {

        boolean expected = true;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isPasswordValid("saikrishnA#123");
        assertEquals(expected, output);

    }
    @Test
    public void isPasswordVali4() {

        boolean expected = true;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isPasswordValid("saiKrishna#0");
        assertEquals(expected, output);

    }

    @Test
    public void isPasswordVali5() {

        boolean expected = false;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isPasswordValid("");
        assertEquals(expected, output);

    }
    @Test
    public void isPasswordVali6() {

        boolean expected = false;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isPasswordValid("saikrishna");
        assertEquals(expected, output);

    }

    @Test
    public void isPasswordVali7() {

        boolean expected = false;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isPasswordValid("123456789");
        assertEquals(expected, output);

    }

    @Test
    public void isPasswordVali8() {

        boolean expected = false;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isPasswordValid("MSDHONI#123");
        assertEquals(expected, output);

    }


    @Test
    public void isPasswordVali9() {

        boolean expected = true;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isPasswordValid("MsDhoni#123");
        assertEquals(expected, output);

    }

    // Registration


    @Test
    public void isNameValid1(){
        boolean expected = true;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isNameValid("SaiKrishna");
        assertEquals(expected, output);
    }

    @Test
    public void isNameValid2(){
        boolean expected = false;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isNameValid("");
        assertEquals(expected, output);
    }


    @Test
    public void isNameValid3(){
        boolean expected = false;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isNameValid("SK");
        assertEquals(expected, output);
    }



    @Test
    public void isNameValid4(){
        boolean expected = true;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isNameValid("SaiKrishna12");
        assertEquals(expected, output);
    }


    @Test
    public void isNameValid5(){
        boolean expected = true;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isNameValid("Sai");
        assertEquals(expected, output);
    }


    @Test
    public void isNameValid6(){
        boolean expected = true;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isNameValid("SaiK");
        assertEquals(expected, output);
    }


    @Test
    public void isNameValid7(){
        boolean expected = false;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isNameValid("S");
        assertEquals(expected, output);
    }

    @Test
    public void isValidPhoneNumber(){
        boolean expected = false;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isPhoneValid(" ");
        assertEquals(expected, output);
    }

    @Test
    public void isValidPhoneNumber1(){
        boolean expected = false;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isPhoneValid("123");
        assertEquals(expected, output);
    }

    @Test
    public void isValidPhoneNumber2(){
        boolean expected = true;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isPhoneValid("9848022338");
        assertEquals(expected, output);
    }

    @Test
    public void isValidPhoneNumber3(){
        boolean expected = false;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isPhoneValid("784569321");
        assertEquals(expected, output);
    }

    @Test
    public void isValidPhoneNumber4(){
        boolean expected = false;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isPhoneValid("00000000");
        assertEquals(expected, output);
    }

    @Test
    public void isValidPhoneNumber5(){
        boolean expected = false;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isPhoneValid("1234567");
        assertEquals(expected, output);
    }

    @Test
    public void isValidPhoneNumber6(){
        boolean expected = false;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isPhoneValid("12345");
        assertEquals(expected, output);
    }

    @Test
    public void isValidPhoneNumber7(){
        boolean expected = true;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isPhoneValid("9985785724");
        assertEquals(expected, output);
    }

    @Test
    public void isValidPhoneNumber8(){
        boolean expected = true;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isPhoneValid("998-578-5724");
        assertEquals(expected, output);
    }

    @Test
    public void isValidPhoneNumber9(){
        boolean expected = true;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isPhoneValid("998 578 5724");
        assertEquals(expected, output);
    }

    @Test
    public void isValidPhoneNumber10(){
        boolean expected = false;
        MyUtils myUtils = new MyUtils();
        boolean output = myUtils.isPhoneValid("143143");
        assertEquals(expected, output);
    }

}