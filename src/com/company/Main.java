package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String login = "";
        String RegOrLog = "";
        String password = "";
        String WriteLogin = "";
        String WritePassword = "";
        String newPass = "";
        String newLogin = "";


        System.out.print("1 - регистрация\n2 - вход\n");
        RegOrLog = in.next();
        switch (RegOrLog) {
            case "1": {
                System.out.print("Input login: ");
                login = in.next();
                System.out.print("Input password: ");
                password = in.next();

                newLogin = Coder.Encrypt(login, "3", EnumType.CipherType.Caesar);
                newPass = Coder.Encrypt(password, "3", EnumType.CipherType.Caesar);

                BufferedWriter bw = null;
                try {
                    bw = new BufferedWriter(new FileWriter("LogAndPass.txt"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    try {
                        bw.write("Login: " + newLogin + "\n");
                        bw.write("Password: " + newPass + "\n");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } finally {
                    try {
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
            case "2": {
                System.out.print("Input login: ");
                login = in.next();
                System.out.print("Input password: ");
                password = in.next();



                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader("LogAndPass.txt"));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                try {
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    try {
                        String ReadLogin = br.readLine();
                        ReadLogin = ReadLogin.substring(ReadLogin.indexOf(" ") + 1, ReadLogin.length());
                        String ReadPassword = br.readLine();
                        ReadPassword = ReadPassword.substring(ReadPassword.indexOf(" ") + 1, ReadPassword.length());
                        if(Coder.Encrypt(login, "3", EnumType.CipherType.Caesar).equals(ReadLogin)&& Coder.Encrypt(password, "3", EnumType.CipherType.Caesar).equals(ReadPassword)) {
                            System.out.println("Molodec!");
                        }
                        else
                        {
                            System.out.println("Za vami viehali!");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } finally {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
            default: {
                System.out.println("Error input!");
            }
        }
    }



}