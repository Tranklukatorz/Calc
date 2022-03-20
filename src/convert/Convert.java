package convert;

import java.util.HashMap;

public class Convert {
    private static final String[][] templateRim = new String[][]{
            {"I", "IV", "V", "IX"},
            {"X", "XL", "L", "XC"},
            {"C", "CD", "D", "CM"},
            {"M", "M", "M", "M"},
    };

    private static final HashMap<Character, Integer> rimToArab = new HashMap<Character, Integer>();
    static {
        rimToArab.put('I', 1);
        rimToArab.put('V', 5);
        rimToArab.put('X', 10);
        rimToArab.put('L', 50);
        rimToArab.put('C', 100);
        rimToArab.put('D', 500);
        rimToArab.put('M', 1000);
    }
    public static String convert(long cifra) {
        return convertToRim(cifra);
    }

    public static int convert(String str) {
        return convertToArb(str);
    }

    private static String convertToRim(long number) {
        int index;
        int rank;
        int digit;
        String rez = "";
        String numbStr = Long.toString(number);

        for (int i = numbStr.length(); 0 < i; --i) {
            rank = i - 1;
            index = numbStr.length() - i;
            digit = Character.getNumericValue(numbStr.charAt(index));
            rez += oneNumberToRim(digit, rank);
        }

        return rez;
    }

    private static String oneNumberToRim(int digit, int razr) {
        String result = "";

        if (digit == 0) {
            return result;
        }
        else if (razr == 3) {
            result += repeatStr(templateRim[razr][0], (digit % 5));
        }
        else if (digit % 10 > 5) {
            if (digit % 5 > 3) {
                result += templateRim[razr][3];
            }
            else result += templateRim[razr][2] + repeatStr(templateRim[razr][0], (digit % 5));
        }
        else if (digit % 5 == 0) {
            result += templateRim[razr][2];
        }
        else if (digit % 5 > 3) {
            result += templateRim[razr][1];
        }
        else {
            result += repeatStr(templateRim[razr][0], (digit % 5));
        }

        return result;
    }

    private static String repeatStr(String str, int val) {
        String tmp = str;
        for (int i = 1; i < val; ++i) {
            str += tmp;
        }

        return str;
    }

    private static int convertToArb(String strIn) {
        char[] str = strIn.toCharArray();
        boolean flag = true;
        int itog = 0;

        for (int i = str.length - 1; i > -1; --i) {
            if (flag) {
                if (i > 0) {
                    if (rimToArab.get(str[i]) <= rimToArab.get(str[i - 1])) {
                        itog += rimToArab.get(str[i]);
                    } else {
                        flag = false;
                        itog += rimToArab.get(str[i]);
                    }
                } else itog += rimToArab.get(str[i]);
            } else {
                itog -= rimToArab.get(str[i]);
                flag = true;
            }
        }

        return itog;
    }
}
