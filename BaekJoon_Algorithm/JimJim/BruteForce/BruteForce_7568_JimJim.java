package JimJim;
import java.util.Scanner;

/**
 * Created by Jimin on 10/3/17.
 */
public class BruteForce_7568_JimJim {
    public static void main(String[] agrv) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[][] matrix = new int[size][3];
        for(int i=0; i<size; i++) {
            matrix[i][0] = Integer.parseInt(scan.next());
            matrix[i][1] = Integer.parseInt(scan.next());
            matrix[i][2] = 1;
        }

        for(int i=0; i<size; i++) {
            for(int j=0; j<size ;j++) {
                if(matrix[i][0] < matrix[j][0]) {
                    if(matrix[i][1] < matrix[j][1]) {
                        matrix[i][2]++;
                    }
                }
            }
        }

        for(int i=0; i<size; i++) {
            System.out.println(matrix[i][2]);
        }
    }
}
