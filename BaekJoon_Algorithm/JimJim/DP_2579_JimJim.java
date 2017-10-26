import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Jimin on 10/25/17.
 */
public class DP_2579_JimJim {
    public static void main(String[] agr) throws IOException {
        DP_2579_JimJim main = new DP_2579_JimJim();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] matrix = new int[num];
        for(int i=0; i<num; i++) {
            matrix[i] = Integer.parseInt(br.readLine());
        }

        int[] answer = new int[num];
        answer[0] = matrix[0];
        if(num < 2) {
            System.out.println(answer[num-1]);
            return;
        }

        for(int i=1; i<3; i++) {
            if(i==1) {
                answer[i] = main.max(answer[i-1] + matrix[i], matrix[i]);
            } else {
                answer[i] = main.max(answer[i-2]+matrix[i], matrix[i-1] + matrix[i]);
            }
        }

        for(int i=3; i<num; i++) {
            answer[i] = main.max(answer[i-2] + matrix[i], answer[i-3] + matrix[i] + matrix[i-1]);
        }

        System.out.println(answer[num-1]);
    }

    public int max(int a, int b) {
        return a>b? a:b;
    }
}
