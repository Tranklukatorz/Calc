package check;

public class Check {
    private static final Character rim[] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
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
        String strOut = "Unknw-err";
        String strCheck[] = str_in.split(" ");

        if (strCheck.length != 3) {
            strOut = "oper-err";
        }
        else if (!(checkOperat(strCheck[1]))) {
            strOut = "oper-err";
        }
        else if (checkInt(strCheck[0]) && checkInt(strCheck[2])){
            strOut = "int";
        }
        else if (checkRim(strCheck[0]) && checkRim(strCheck[2])){
            strOut = "rim";
        }

        return strOut;
    }

    private Boolean checkOperat(String str) {
        boolean flag = false;
        Character[] template = {'*', '/', '+', '-'};
        char temPlateChar = str.charAt(0);

        if (str.length() != 1) {
            flag = false;
        }
        else {
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
        } catch (Exception ex) {
            flag = false;
        }

        return flag;
    }

    private Boolean checkRim(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); ++i) {
            for (int j = 0; j < rim.length; ++j) {
                if (rim[j].equals(str.charAt(i))) count += 1;
            }
        }

        return count == str.length();
    }


}
