import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        List<Integer> totals = new ArrayList<>();
        for(int r=0;r<(arr.length-3);r++) {
            for(int c=0;c<(arr[r].length-3);c++) {
                int first_three = arr[r][c] + arr[r][c+1] + arr[r][c+2];
                int middle = arr[r+1][c+1];
                int last_three = arr[r+2][c] + arr[r+2][c+1] +arr[r+2][c+2];
                int total = first_three + middle + last_three;
                totals.add(total);
            }
        }
        return Collections.max(totals);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
