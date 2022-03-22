package check;

import convert.Convert;

public class Check {
    private static final Character[] rim = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    private String resultChek;

    public Check(){
    }

    Check(String strIn) {
        setStrIn(strIn);
    }

    public String getResult(){
        return resultChek;
    }

    public void setStrIn(String strIn) {
        this.resultChek = mainCheck(strIn);
    }

    private String mainCheck(String str_in) {
        String strOut = "Unknow-err";
        String[] strCheck = str_in.split(" ");

        if (strCheck.length < 3 ){
            strOut = "mat-err-oper";
        }
        else if (strCheck.length > 3) {
            strOut = "oper-err-format";
        }
        else if (!(checkOperat(strCheck[1]))) {
            strOut = "oper-err";
        }
        else if (checkRim(strCheck[0]) && checkRim(strCheck[2])){
            if ( (Convert.convert(strCheck[0]) < 11 && Convert.convert(strCheck[0]) > 0) && (Convert.convert(strCheck[2]) < 11 && Convert.convert(strCheck[2]) > 0)){
                strOut = "rim";
            }
            else {
                strOut = "rim-range-err";
            }
        }
        else if (checkInt(strCheck[0]) && checkInt(strCheck[2])){
            if ( (Integer.parseInt(strCheck[0]) < 11 && Integer.parseInt(strCheck[0]) > 0) && (Integer.parseInt(strCheck[2]) < 11 && Integer.parseInt(strCheck[2]) > 0)){
                strOut = "int";
            }
            else {
                strOut = "Arab-range-err";
            }
        }
        else if ((checkInt(strCheck[0]) && checkRim(strCheck[2])) || (checkRim(strCheck[0]) && checkInt(strCheck[2]))){
            strOut = "int-rim-err";
        }
        else if (strCheck[0].length() != 0  && strCheck[2].length() != 0){
            strOut = "str-err";
        }

        return strOut;
    }


    private Boolean checkOperat(String str) {
        boolean flag = false;
        Character[] template = {'*', '/', '+', '-'};
        char temPlateChar = str.charAt(0);

        if (str.length() == 1) {
            for (Character i : template) {
                if (i.equals(temPlateChar)) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private Boolean checkInt(String str) {
        boolean flag = true;

        try {
            Integer.parseInt(str);
        }
        catch (Exception ex) {
            flag = false;
        }

        return flag;
    }

    private Boolean checkRim(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); ++i) {
            for (int j = 0; j < rim.length; ++j) {
                if (rim[j].equals(str.charAt(i))) {
                    count += 1;
                }
            }
        }

        return count == str.length();
    }


}