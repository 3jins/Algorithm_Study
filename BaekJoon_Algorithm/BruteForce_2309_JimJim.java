import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jimin on 10/3/17.
 */
public class BruteForce_2309_JimJim {

    static int[] small;
    static boolean check = false;
    public static void main(String[] agrv) {
        Scanner scan = new Scanner(System.in);
        small = new int[9];
        int[] arr = new int[9];
        for(int i=0; i<9; i++) {
            small[i] = scan.nextInt();
        }
        Arrays.sort(small);

        combination(arr, 0, 2, 0);
    }

    public static void combination(int[] arr, int index, int left, int num) {
        if(left == 0) {
            print(arr);
        } else if(num == 9) {
            return;
        } else {
            arr[index] = num;
            combination(arr, index + 1, left - 1, num + 1);
            combination(arr, index, left, num + 1);
        }
    }

    public static void print(int[] arr) {
        int sum = 0;
        for(int i=0; i<9 ;i++) {
            if(i != arr[0] && i != arr[1]) {
                sum += small[i];
            }
        }
        if(sum == 100) {
            for(int i=0; i<9 ;i++) {
                if(!check && i != arr[0] && i != arr[1]) {
                    System.out.println(small[i]);
                }
            }
            check = true;
        }
    }
}
