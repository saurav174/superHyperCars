package com.superHyperCars.utils;

import java.util.Random;
import java.util.UUID;

public class PasswordUtility {

    private static final int PASSWORD_LENGTH = 8;
    private static  final String numbers= "0123456789";

    public static boolean isValidPassword(String password) {

        if (password.length() < PASSWORD_LENGTH) return false;

        int charCount = 0;
        int numCount = 0;
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (isNumeric(ch)) numCount++;
            else if (isLetter(ch)) charCount++;
            else return false;
        }


        return (charCount >= 2 && numCount >= 2);
    }

    public static boolean isLetter(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }


    public static boolean isNumeric(char ch) {

        return (ch >= '0' && ch <= '9');
    }

    public static char[] generateOTP(int len)
    {
        Random rndm_method = new Random();

        char[] otp = new char[len];

        for (int i = 0; i < len; i++)
        {

            otp[i] =
                    numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
        return otp;
    }

    public static String generateToken(String userID,String id)
    {
        return UUID.randomUUID().toString()+"|"+userID+"|"+id;
    }

}
