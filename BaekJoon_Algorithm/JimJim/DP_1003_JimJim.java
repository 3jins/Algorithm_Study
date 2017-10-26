package JimJim;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Jimin on 10/23/17.
 */
public class DP_1003_JimJim {
    public static void main(String[] argv) throws IOException {
        int[][] arr = new int[41][2];
        arr[0][0] = arr[1][1] = 1;
        arr[1][0] = arr[0][1] = 0;

        for(int j=2; j<41; j++) {
            arr[j][0] = arr[j-1][0] + arr[j-2][0];
            arr[j][1] = arr[j-1][1] + arr[j-2][1];
        }

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int total_size = Integer.parseInt(br.readLine());
        for(int i= 0; i<total_size; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(arr[num][0] + " "+ arr[num][1]);
        }
    }
}
