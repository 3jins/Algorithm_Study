package JimJim;
import java.util.*;

/**
 * Created by Jimin on 9/25/17.
 */

//success
public class DFSBFS_1260_JimJim {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int e_size = scan.nextInt();
        int v_size = scan.nextInt();
        int start = scan.nextInt();

        boolean[] check_matrix = new boolean[e_size];
        boolean[] order = new boolean[e_size];
        int[][] matrix = new int[e_size][e_size];

        for (int i = 0; i < e_size; i++) {
            check_matrix[i] = false;
            order[i] = false;
            for (int j = 0; j < e_size; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < v_size; i++) {
            int node1 = scan.nextInt();
            int node2 = scan.nextInt();
            matrix[node1 - 1][node2 - 1] = 1;
            matrix[node2 - 1][node1 - 1] = 1;
        }
        dfs(start - 1, e_size, matrix, check_matrix, order);
        System.out.println("");
        for (int i = 0; i < e_size; i++) {
            check_matrix[i] = false;
            order[i] = false;
        }
        bfs(start-1, e_size, matrix, check_matrix, order);
    }

    public static void bfs(int start, int e_size, int[][] matrix,
                           boolean[] check_matrix, boolean[] order) {

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        check_matrix[start] = true;
        boolean flag = false;

        while(!queue.isEmpty()) {
            flag = false;
            //int new_start = queue.peek();
            int new_start= queue.poll();
            System.out.print(new_start+1 + " ");
            for(int i=0; i<e_size; i++) {
                if(matrix[new_start][i] == 1 && !check_matrix[i]) {
                    queue.offer(i);
                    check_matrix[i] = true;
                    flag=true;

                }
            }
//			if(!flag) {
//				System.out.print(queue.poll()+1 + " ");
//			}
        }

    }

    public static void dfs(int start, int e_size, int[][] matrix,
                           boolean[] check_matrix, boolean[] order ) {

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(start);
        check_matrix[start] = true;
        boolean flag = false;


        while(!stack.isEmpty()) {
            flag = false;
            int new_start = stack.peek();
            if(!order[new_start]) {
                System.out.print((new_start+1) + " ");
                order[new_start] = true;
            }
            for(int i=0; i<e_size; i++) {
                if(matrix[new_start][i] == 1 && !check_matrix[i]) {
                    stack.push(i);
                    check_matrix[i] = true;
                    flag=true;
                    break;
                }
            }
            if(!flag) {
                stack.pop();
            }
        }
    }
}
