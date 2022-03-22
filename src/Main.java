import check.Check;
import convert.Convert;
import java.util.Scanner;

import static calculator.Calculations.calc;
import static err.Err.err;

public class Main {

    public static void main(String[] args) {
        String stroka;
        String[] strCheck;
        int rez;
        Check test = new Check();
        java.util.Scanner in = new Scanner(System.in);
        System.out.println("Добро пожаловать в приложение калькулятор\n"+
                "Калькулятор работает с арабскими и римскими числами\n" +
                "Вводимые числа должны лежать в промежутке от 1 до 10\nИ от I до X для римских - " +
                "Римские числа - 'I'-1; 'V'-5;  'X'-10; 'L'-50; 'C'-100; 'D'-500; 'M'-1000");

        while (true) {

            stroka = in.nextLine().trim();
            strCheck = stroka.split(" ");
            test.setStrIn(stroka);

            if (!(test.getResult().equals("rim") || test.getResult().equals("int"))){
                err(test.getResult());
                break;
            }

            else if (test.getResult().equals("int")) {
                rez = calc(Integer.parseInt(strCheck[0]), strCheck[1], Integer.parseInt(strCheck[2]));
                System.out.println(rez);
            }

            else if (test.getResult().equals("rim")) {
                rez = calc (Convert.convert(strCheck[0]), strCheck[1], Convert.convert(strCheck[2]));
                if (rez > 0) {
                    System.out.println(Convert.convert(rez));
                }
                else {
                    err("throws Exception //т.к. в римской системе нет отрицательных чисел");
                    break;
                }
            }
        }
        in.close();
    }
}
