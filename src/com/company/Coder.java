package com.company;

public class Coder {

    static String Encrypt(String text, String key, EnumType.CipherType type) {
        String newLogin = "";
        for (int i = 0; i < text.length(); i++)
            newLogin += (char) (text.charAt(i) + (int)(key.charAt(0)));
        return newLogin;
    }

    static String Decrypt(String text, String key, EnumType.CipherType type) {
        String newLogin = "";
        for (int i = 0; i < text.length(); i++)
            newLogin += (char) (text.charAt(i) - (int)(key.charAt(0)));
        return newLogin;
    }

}
