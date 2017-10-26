package JimJim;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Jimin on 10/23/17.
 */
public class DP_1463_JimJim {
    public static void main(String[] argv) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num+1];
        arr[1] = 0;
        if(num == 1) {
            System.out.println(0);
            return;
        }

        for(int i = 2; i <= num; i++) {
            int real = i;
            if (real % 3 == 0) {
                arr[real] = 1 + arr[real/3];
            } else if (real % 2 == 0) {
                arr[real] = 1 + arr[real/2];
            } else {
                System.out.println(num);
                System.out.println(real-1);
                arr[num] = 1 + arr[real-1];
            }
        }
        System.out.println(arr[num]);
    }
}


