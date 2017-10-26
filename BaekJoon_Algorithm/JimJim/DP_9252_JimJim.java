import java.util.Scanner;

/**
 * Created by Jimin on 10/4/17.
 */
public class DP_9252_JimJim {
    static String[][] str_count;
    public static void main(String[] agrv) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();

        int length = lcs(str1, str2);
        System.out.println(length);
        System.out.println(str_count[str1.length()][str2.length()]);
    }

    public static int lcs(String str1, String str2) {
        int str1_len = str1.length();
        int str2_len = str2.length();

        int[][] count = new int[str1_len+1][str2_len+1];
        str_count = new String[str1_len+1][str2_len+1];

        for(int i=0; i<=str1_len; i++) {
            for (int j = 0; j <= str2_len; j++) {
                str_count[i][j] = "";
            }
        }
        for(int i=0; i<=str1_len; i++) {
            for(int j=0; j<=str2_len; j++) {
                if(i==0 || j==0) {
                    count[i][j] = 0;
                } else if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    str_count[i-1][j-1] += str1.charAt(i-1);
                    count[i][j] = count[i-1][j-1] + 1;
                    str_count[i][j] += str_count[i-1][j-1];
                } else {
                    count[i][j] = Math.max(count[i-1][j],count[i][j-1]);
                    if(count[i][j] == count[i-1][j]) {
                        str_count[i][j] += str_count[i-1][j];
                    } else {
                        str_count[i][j] = str_count[i][j-1];
                    }
                }
            }
        }

        return count[str1_len][str2_len];
    }
}
