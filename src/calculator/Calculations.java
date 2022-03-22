package calculator;

public class Calculations {

     public static int calc(int a, String inStr, int b) {
        char operac = inStr.charAt(0);
        int z = 0;

        switch (operac) {
            case '+':
                z = a + b;
                break;
            case '-':
                z = a - b;
                break;
            case '*':
                z = a * b;
                break;
            case '/':
                z = (int) (a / b);
        }

        return z;
    }

}
