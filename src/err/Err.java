package err;

public class Err {

    public static void err(String strErr){
        switch (strErr){
            case("mat-err-oper"):
                try {
                    throw new RuntimeException("");
                }
                catch (Exception ex) {
                    System.out.println("throws Exception //т.к. строка не является математической операцией ");
                }
                break;
            case("oper-err-format"):
                try {
                    throw new RuntimeException("");
                }
                catch (Exception ex) {
                    System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                }
                break;
            case("oper-err"):
                try {
                    throw new RuntimeException("");
                }
                catch (Exception ex) {
                    System.out.println("throws Exception //т.к. Не корректный оператор (+, -, /, *)");
                }
                break;
            case("rim-range-err"):
                try {
                    throw new RuntimeException("");
                }
                catch (Exception ex) {
                    System.out.println("throws Exception //т.к. Римские цифры должны быть в диапазоне от I до X");
                }
                break;
            case("int-rim-err"):
                try {
                    throw new RuntimeException("");
                }
                catch (Exception ex) {
                    System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
                }
                break;
            case("Arab-range-err"):
                try {
                    throw new RuntimeException("");
                }
                catch (Exception ex) {
                    System.out.println("throws Exception //т.к. Римские цифры должны быть в диапазоне от 1 до 9");
                }
                break;
            case("str-err"):
                try {
                    throw new RuntimeException("");
                }
                catch (Exception ex) {
                    System.out.println("throws Exception //т.к. Математические операции доступны только для целых Римских и Арабских цифр");
                }
                break;
            default:
                try {
                    throw new RuntimeException("");
                }
                catch (Exception ex) {
                    System.out.println(strErr);
                }


        }
    }
}

