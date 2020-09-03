import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String convert(String s, int numRows) {
        int columns = 0;
        boolean goingDown = true;
        StringBuilder returnString = new StringBuilder();
        List<StringBuilder> twoDList = new ArrayList<StringBuilder>(numRows);
        for(int i = 0; i < numRows; i++) {
            twoDList.add(new StringBuilder());
        }
        if(s.length() == 1) {
            return s;
        }

        int currSIndex = 0;
        while (currSIndex < s.length()) {
            if (goingDown) {
                for (int r = 0; r < numRows && currSIndex < s.length(); r++) {
                    if(r == 0 && currSIndex != 0) r++;
                    twoDList.get(r).append(s.charAt(currSIndex));
                    currSIndex++;
                }
                goingDown = false;
            } else {
                for (int r = numRows - 2; r >= 0 && currSIndex < s.length(); r--) {
                    twoDList.get(r).append(s.charAt(currSIndex));
                    currSIndex++;
                }
                goingDown = true;
            }
        }

        for (StringBuilder stringBuilder : twoDList) {
            System.out.println(stringBuilder.toString());
            returnString.append(stringBuilder.toString());
        }

        return returnString.toString();
    }

    public static void main(String[] args) {
        convert("PAYPALISHIRING", 4);
    }
}
