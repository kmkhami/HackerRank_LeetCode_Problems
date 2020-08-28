import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int full_repeats = (int)(n/s.length());
        int remainder = (int)(n%s.length());
        int a_count = 0;
        char[] word = s.toCharArray();
        List<Integer> aIndices = new ArrayList<>();
        for(int x=0;x<word.length;x++) {
            if(word[x]=='a') {
                aIndices.add(x);
            }
        }
        for(int x : aIndices) {
            if(x<=(remainder-1)) {
                a_count += full_repeats+1;
            }
            else {
                a_count += full_repeats;
            }
        }
        return a_count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
