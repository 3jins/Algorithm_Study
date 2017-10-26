package JimJim;
import java.util.Scanner;

/**
 * Created by Jimin on 10/2/17.
 */
public class DFS_2606_JimJim {

    static int[][] matrix;
    static boolean[] check;
    static int node_num;
    static int count=0;

    public static void main(String[] agrv) {
        Scanner scan = new Scanner(System.in);
        node_num = scan.nextInt();
        int size = scan.nextInt();

        matrix = new int[node_num][node_num];
        check = new boolean[node_num];

        for(int i=0; i<size; i++) {
            int node1 = scan.nextInt();
            int node2 = scan.nextInt();
            matrix[node1-1][node2-1] = 1;
            matrix[node2-1][node1-1] = 1;
        }

        for(int i=0; i<node_num; i++) {
            check[i] = false;
        }
        dfs(1);
        System.out.print(count);
    }

    public static void dfs(int node) {
        check[node-1] = true;
        for(int i=0; i< node_num; i++){
            if(matrix[node-1][i]==1 && !check[i]) {
                count++;
                dfs(i+1);
            }

            if(matrix[i][node-1]==1 && !check[i]) {
                count++;
                dfs(i+1);
            }
        }
    }
}
