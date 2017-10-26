/**
 * Created by Jimin on 9/20/17.
 * https://www.acmicpc.net/problem/11403
 */

import java.util.Scanner;
import java.util.Stack;

public class DFS_11403_JimJim {

    public static Stack<Integer> dfs(int[][] matrix, boolean[] check, int v, boolean flag) {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        stack.push(v);

        while (!stack.isEmpty()) {
            int start = stack.peek();
            flag = false;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[start][i] == 1 && !check[i]) {
                    stack.push(i);
                    stack2.push(i);
                    check[i] = true;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                stack.pop();
            }
        }
        return stack2;
    }

    public static void main(String[] argv) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[][] matrix = new int[size][size];
        int[][] ans_matrix = new int[size][size];

        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                matrix[i][j] = scan.nextInt();
                ans_matrix[i][j] = 0;
            }
        }

        for(int i=0; i<size; i++) {
            boolean flag = false;
            boolean[] check = new boolean[size];
            for(int x=0; x<size; x++) {
                check[x] = false;
            }
            Stack<Integer> stack = dfs(matrix, check, i,flag);
            while(!stack.isEmpty()){
                ans_matrix[i][stack.pop()] = 1;
            }
        }

        for(int i = 0 ;i<size; i++) {
            for(int j=0; j<size; j++) {
                System.out.print(ans_matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
}



