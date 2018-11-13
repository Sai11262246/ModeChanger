package com.vivartha.modechanger;

import java.util.regex.Pattern;

/**
 * @author vikas
 * This class contains all the utility functions.
 * which is used accross the application.
 * Modified by : sai teja, siri gogineni.
 */
public class MyUtils {



    public static boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email.matches(emailPattern))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

/**

 ^                 # start-of-string
 (?=.*[0-9])       # a digit must occur at least once
 (?=.*[a-z])       # a lower case letter must occur at least once
 (?=.*[A-Z])       # an upper case letter must occur at least once
 (?=.*[@#$%^&+=])  # a special character must occur at least once
 (?=\S+$)          # no whitespace allowed in the entire string
 .{8,}             # anything, at least eight places though
 $                 # end-of-string

 * **/
    public static boolean isPasswordValid(String password) {
       String password_pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
       if(password.matches(password_pattern)){
           return true;
       }else{
           return false;
       }

    }


    /**  Length >=3
     Valid characters: a-z, A-Z, 0-9 **/

    public static boolean isNameValid(String name) {
        String regex = "^[a-zA-Z0-9._-]{3,}$";
        if(name.matches(regex)){return  true;}else{return false;}

    }

    public static  boolean isPhoneValid(String phone) {
        boolean check=false;
        if(!Pattern.matches("[a-zA-Z]+", phone)) {
            if(phone.length() < 10 || phone.length() > 13) {
                // if(phone.length() != 10) {
                check = false;

            } else {
                check = true;
            }
        } else {
            check=false;
        }
        return check;
    }

}
