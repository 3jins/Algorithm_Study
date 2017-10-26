package JimJim;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Jimin on 10/25/17.
 */
public class DP_1149_JimJim {
    public static void main(String[] agr) throws IOException {
        DP_1149_JimJim main = new DP_1149_JimJim();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] matrix = new int[num][num];

        for(int i=0; i<num; i++) {
            String str = br.readLine();
            matrix[i][0] = Integer.parseInt(str.split(" ")[0]);
            matrix[i][1] = Integer.parseInt(str.split(" ")[1]);
            matrix[i][2] = Integer.parseInt(str.split(" ")[2]);
        }

        int[][] answer = new int[num][num];
        answer[0][0] = matrix[0][0];
        answer[0][1] = matrix[0][1];
        answer[0][2] = matrix[0][2];

        for(int i=1; i<num; i++) {
            answer[i][0] = main.min(answer[i-1][1], answer[i-1][2]) + matrix[i][0];
            answer[i][1] = main.min(answer[i-1][0], answer[i-1][2]) + matrix[i][1];
            answer[i][2] = main.min(answer[i-1][0], answer[i-1][1]) + matrix[i][2];
        }

        if(answer[num-1][0] < answer[num-1][1]) {
            if(answer[num-1][0] < answer[num-1][2]) {
                System.out.println(answer[num-1][0]);
            } else {
                System.out.println(answer[num-1][2]);
            }
        } else {
            if(answer[num-1][1] < answer[num-1][2]) {
                System.out.println(answer[num-1][1]);
            } else {
                System.out.println(answer[num-1][2]);
            }
        }
    }

    public int min(int a, int b){
        return a<b ? a:b;
    }
}
