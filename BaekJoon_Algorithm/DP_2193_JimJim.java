import java.util.Scanner;

/**
 * Created by Jimin on 10/2/17.
 */
public class DP_2193_JimJim {

    public static void main(String[] argv) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        long[][] matrix = new long[num][2];
        matrix[0][0]=1;
        matrix[0][1]=1;

        for(int i=1; i<num; i++) {
            matrix[i][0] = matrix[i-1][0] + matrix[i-1][1];
            matrix[i][1] = matrix[i-1][0];
        }
        System.out.print(matrix[num-1][1]);
    }
}
