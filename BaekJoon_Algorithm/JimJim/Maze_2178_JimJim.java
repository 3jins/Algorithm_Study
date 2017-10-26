/**
 * Created by Jimin on 10/2/17.
 */
import java.util.LinkedList;
import java.util.Scanner;
public class Maze_2178_JimJim {

    static int[][] matrix;
    static boolean[][] matrix_check;
    static int m_row, m_col;
    static int count=0;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] argv) {
        Scanner scan = new Scanner(System.in);
        m_row = scan.nextInt();
        m_col = scan.nextInt();
        String[] matrix_st = new String[m_row];

        matrix = new int[m_row][m_col];
        matrix_check = new boolean[m_row][m_col];
        for(int i=0; i< m_row; i++) {
            matrix_st[i] = scan.next();
            System.out.println("hahah");
        }

        for(int i=0; i< m_row; i++) {
            for(int j=0; j< m_col; j++) {
                matrix[i][j] = matrix_st[i].charAt(j)-48;
                matrix_check[i][j] = false;
            }
        }

        bfs(0, 0, matrix_check, count);
        System.out.println(min);
    }

    public static void bfs(int node1, int node2, boolean[][] matrix_check2, int count2) {
        if(node1 == m_row -1 && node2 == m_col -1) {
            count2++;
            if (min > count2) {
                min = count2;
            }
            return;
        }

        if(node1+1<m_row && !matrix_check2[node1+1][node2] && matrix[node1+1][node2]==1) {
            count2++;
            matrix_check2[node1+1][node2] = true;
            bfs(node1+1, node2, matrix_check2, count2);
            matrix_check2[node1+1][node2] = false;
            count2--;
        }
        if(node2+1<m_col&&!matrix_check2[node1][node2+1] && matrix[node1][node2+1]==1 ) {
            count2++;
            matrix_check2[node1][node2+1] = true;
            bfs(node1, node2+1, matrix_check2, count2);
            matrix_check2[node1][node2+1] = false;
            count2--;
        }
        if(node1-1>=0 && !matrix_check2[node1-1][node2] && matrix[node1-1][node2]==1) {
            count2++;
            matrix_check2[node1-1][node2] = true;
            bfs(node1 - 1, node2, matrix_check2, count2);
            matrix_check2[node1-1][node2] = false;
            count2--;
        }
        if(node2-1>=0&&!matrix_check2[node1][node2-1] && matrix[node1][node2-1]==1 ) {
            count2++;
            matrix_check2[node1][node2-1] = true;
            bfs(node1, node2 - 1, matrix_check2, count2);
            matrix_check2[node1][node2-1] = false;
            count2--;
        }

        return;
    }

//    private static class Point {
//        int row, col, length;
//
//        public Point(int row, int col, int length) {
//            this.row = row;
//            this.col = col;
//            this.length = length;
//        }
//    }
}
