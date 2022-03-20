import check.Check;
import convert.Convert;
import java.util.Scanner;

import static calculator.Calculations.calc;

public class Main {

    public static void main(String[] args) {
        String stroka;
        String[] strCheck;
        long rez;
        Check test = new Check();
        java.util.Scanner in = new Scanner(System.in);

        while (true) {

            stroka = in.nextLine().trim();
            strCheck = stroka.split(" ");
            test.setStrIn(stroka);

            if (test.getResult().equals("Unknw-err")) {
                throw new RuntimeException("\nОперанды должны быть целыми числами одной системы исчесления, и быть в диапазоне от -2,147,483,648 до 2,147,483,647 для арабских чисел. " +
                        " И от I до MMM для римских");
            }

            else if (test.getResult().equals("oper-err")) {
                throw new RuntimeException("Не корректный формат ввода. Корректный - 'A (+ - / *) B' где в место скобок указывается 1 оператор");
            }

            else if (test.getResult().equals("int")) {
                    rez = calc(Integer.parseInt(strCheck[0]), strCheck[1], Integer.parseInt(strCheck[2]));
                    if (Integer.MIN_VALUE < rez && rez < Integer.MAX_VALUE) {
                        System.out.println(rez);
                    }
                    else throw new RuntimeException("Результат вычеслений должен лежать в диапазоне от -2,147,483,648 до 2,147,483,647");
            }

            else if (test.getResult().equals("rim")) {
                    rez = calc (Convert.convert(strCheck[0]), strCheck[1], Convert.convert(strCheck[2]));
                    if (rez > 0 && rez <= 3000) {
                        System.out.println(Convert.convert(rez));
                    }
                    else throw new RuntimeException("Для римских чисел результат вычеслений не может быть отрицательным и не должен привышать MMM(3000)");
            }
        }
    }
}
