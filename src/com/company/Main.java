package com.company;

import java.util.Scanner;

public class Main {
    static boolean isRome = false;
    static boolean isGraterThan10 = false;
    public static void main(String[] args) {
        int result;
        boolean isOneFormat = true;
        boolean isOneFormatA = true;
        boolean isOneFormatB = true;
        Scanner in = new Scanner(System.in);
        String a = in.next(), operation = in.next(), b = in.next();

        result = calc(toArab(a), operation, toArab(b));

        try{
            Integer.parseInt(a);
        }catch (NumberFormatException e){
            isOneFormatA = false;
        }
        try{
            Integer.parseInt(b);
        }catch (NumberFormatException e){
            isOneFormatB = false;
        }

        if((isOneFormatA && !isOneFormatB) || (!isOneFormatA && isOneFormatB)){
            isOneFormat = false;
        }else{
            isOneFormat = true;
        }

        if(isOneFormat){
            if(toArab(a)==0 || toArab(b)==0){
                System.out.println("Numbers grater than 10!");
            }else{
                if(isRome) {
                    System.out.println(toRome(result));
                }else{
                    if (!isGraterThan10){
                        System.out.println(result);
                    }
                }
            }
        }else{
            System.out.println("Numbers are not in one format!");
        }

    }

    public static int calc(int a, String operation, int b){
        int result = 0;
            switch (operation) {
                case "+":
                    result = a + b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "/":
                    result = a / b;
                    break;
                default:
                    System.out.println("This is not an operation!");
                    break;
            }
        return result;
    }

    public static String toRome (int a){
        String result = "";

        while (a >= 1000) {
            result += "M";
            a -= 1000;        }
        while (a >= 900) {
            result += "CM";
            a -= 900;
        }
        while (a >= 500) {
            result += "D";
            a -= 500;
        }
        while (a >= 400) {
            result += "CD";
            a -= 400;
        }
        while (a >= 100) {
            result += "C";
            a -= 100;
        }
        while (a >= 90) {
            result += "XC";
            a -= 90;
        }
        while (a >= 50) {
            result += "L";
            a -= 50;
        }
        while (a >= 40) {
            result += "XL";
            a -= 40;
        }
        while (a >= 10) {
            result += "X";
            a -= 10;
        }
        while (a >= 9) {
            result += "IX";
            a -= 9;
        }
        while (a >= 5) {
            result += "V";
            a -= 5;
        }
        while (a >= 4) {
            result += "IV";
            a -= 4;
        }
        while (a >= 1) {
            result += "I";
            a -= 1;
        }

        return result;
    }

    public static int toArab(String a){
        int result = 0;
        try{
            switch (a){
                case "I":
                    result = 1;
                    isRome = true;
                    break;
                case "II":
                    result = 2;
                    isRome = true;
                    break;
                case "III":
                    result = 3;
                    isRome = true;
                    break;
                case "IV":
                    result = 4;
                    isRome = true;
                    break;
                case "V":
                    result = 5;
                    isRome = true;
                    break;
                case "VI":
                    result = 6;
                    isRome = true;
                    break;
                case "VII":
                    result = 7;
                    isRome = true;
                    break;
                case "VIII":
                    result = 8;
                    isRome = true;
                    break;
                case "IX":
                    result = 9;
                    isRome = true;
                    break;
                case "X":
                    result = 10;
                    isRome = true;
                    break;
                default:
                    break;
            }
            if (!isRome && Integer.parseInt(a)>10){
                isGraterThan10 = true;
            }
            if(isRome){
                return result;
            }else{
                if (!isGraterThan10){
                    return Integer.parseInt(a);
                }else{
                    return 0;
                }
            }
        }catch (NumberFormatException e){
        }
        return result;
    }

}
