package JimJim;
import java.util.Scanner;

/**
 * Created by Jimin on 10/2/17.
 */
public class DP_2156_JimJim {
    static int max = Integer.MIN_VALUE;
    static int[] sum;
    public static void main(String[] agrv) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] arr = new int[size];
        sum = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = 0;
            sum[i] = scan.nextInt();
        }

        for(int i=0; i<size; i++) {
            combination(arr, 0, size, i, 0);
        }
        System.out.println(max);
    }

    public static void combination(int[] arr, int index, int n, int r, int target) {
        if (r == 0) {
            print(arr,index);
        } else if (target == n) {
            return;
        } else {
            arr[index] = target;
            combination(arr, index + 1, n, r - 1, target + 1);
            combination(arr, index, n, r, target + 1);
        }
    }

    public static void print(int[] arr, int length) {
        for (int i = 0; i < length; i++)
            System.out.print(arr[i]);
        System.out.println("");
    }
}
