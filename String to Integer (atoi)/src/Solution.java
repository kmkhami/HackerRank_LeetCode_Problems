public class Solution {
    public int myAtoi(String str) {
        StringBuilder holdNumber = new StringBuilder();
        int returnInt = 0;
        boolean onInt = false;
        final double INT_MIN = Math.pow(-2, 31);
        final double INT_MAX = Math.pow(2, 31);
        for(int i=0; i < str.length(); i++) {
            if(!onInt && str.charAt(i) != '-' && str.charAt(i) != '+' && str.charAt(i) != ' ' && !Character.isDigit(str.charAt(i))) {
                return 0;
            }
            else if(!onInt && i+1 < str.length() && str.charAt(i) == '+' && !Character.isDigit(str.charAt(i+1))) {
                return 0;
            }
            else if(!onInt && (str.charAt(i) == '-' || Character.isDigit(str.charAt(i)))) {
                onInt = true;
            }
            else if(onInt && !Character.isDigit(str.charAt(i))) {
                break;
            }
            if(onInt) {
                holdNumber.append(str.charAt(i));
            }
        }
        if(holdNumber.length() == 0 || (holdNumber.length() == 1 && holdNumber.toString().charAt(0) == '-'))
            return returnInt;
        double tempDouble = Double.parseDouble(holdNumber.toString());
        if(tempDouble <= INT_MIN)
            return  (int)(INT_MIN);
        else if(tempDouble >= INT_MAX)
            return (int)(INT_MAX);
        else
            return Integer.parseInt(holdNumber.toString());
    }
}
