import java.util.Scanner;

/**
 * Created by Jimin on 10/13/17.
 */
public class BFS_7576_JimJim {
    static int row;
    static int col;
    static int full;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        col = scan.nextInt();
        row = scan.nextInt();

        int[][] matrix = new int[row][col];
        int ones = 0;
        int minus = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int one = scan.nextInt();
                matrix[i][j] = one;
                if (one == 1) {
                    ones++;
                }
                if (one == -1) {
                    minus++;
                }
            }
        }
        int end = 0;
        full = row * col - ones - minus;
        if (ones == 0) {
            System.out.println("-1");
            return;
        }

        dfs(matrix, end, 0);
    }

    public static void dfs(int[][] matrix, int end, int count) {
        if (end == full) {
            System.out.println(count);
            return;
        } else {
            if(count==full) {
                System.out.println("-1");
                return;
            }
            System.out.println(count);
            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println("");
            }
            System.out.println("\n\n");
        }

        for (int i = 0; i < row; i++) {
            boolean[] flag = {false, false, false, false};
            int ch = 0;
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    if (i + 1 < row && matrix[i + 1][j] == 0) {
                        flag[0] = true;
                        end++;
                        ch++;
                    }
                    if (j + 1 < col && matrix[i][j + 1] == 0) {
                        flag[1] = true;
                        end++;
                        ch++;
                    }
                    if (i - 1 >= 0 && matrix[i - 1][j] == 0) {
                        flag[2] = true;
                        end++;
                        ch++;
                    }
                    if (j - 1 >= 0 && matrix[i][j - 1] == 0) {
                        flag[3] = true;
                        end++;
                        ch++;
                    }


                    if(flag[0]) {
                        matrix[i + 1][j] = 1;
                    }
                    if(flag[1]) {
                        matrix[i][j+1] = 1;
                    }
                    if(flag[2]) {
                        matrix[i - 1][j] = 1;
                    }
                    if(flag[3]) {
                        matrix[i][j - 1] = 1;
                    }
                }
                if(flag[0] || flag[1] || flag[2] || flag[3] ) {
                    flag[0] = false;
                    flag[1] = false;
                    flag[2] = false;
                    flag[3] = false;
                    if(ch <=    1) {
                        break;
                    }
                    //break;
                }
            }

        }
        count++;
        dfs(matrix, end, count);
    }
}

