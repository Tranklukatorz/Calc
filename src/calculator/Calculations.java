package calculator;

public class Calculations {

     public static long calc(int a, String inStr, int b) {
        char operac = inStr.charAt(0);
        long z = 0;

        switch (operac) {
            case '+':
                z = a + b;
                break;
            case '-':
                z = a - b;
                break;
            case '*':
                z = (long)a * b;
                break;
            case '/':
                z = (long) a / b;
        }

        return z;
    }

}
