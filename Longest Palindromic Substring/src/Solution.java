import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        String longestString = "";
        for(int i = 0; i < s.length(); i++) {
            int l1 = moveFromCenter(s, i, i);
            int l2 = moveFromCenter(s, i, i+1);
            int longest = Math.max(l1, l2);
            if(longest > end - start) {
                start = i - (longest - 1) / 2;
                end = i + longest/2;
                longestString = s.substring(start, end + 1);
            }
        }
        return longestString; 
    }

    public static int moveFromCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            R++;
            L--;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}