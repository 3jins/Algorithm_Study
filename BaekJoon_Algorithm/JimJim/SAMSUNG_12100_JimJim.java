import java.util.Scanner;

/**
 * Created by Jimin on 10/19/17.
 */

//성공
public class SAMSUNG_12100_JimJim {
    static int size;

    static int mmax;
    public static void main(String[] agrv) {
        SAMSUNG_12100_JimJim main = new SAMSUNG_12100_JimJim();

        Scanner scan = new Scanner(System.in);
        size = scan.nextInt();

        int[][] matrix = new int[size][size];
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        int count=0;
        main.solve(matrix, count);
        System.out.println(mmax);
    }

    public void solve(int[][] matrix, int here_C) {
        if(here_C == 5) {
            for(int i=0; i<size; i++) {
                for(int j=0; j<size; j++) {
                    if(mmax < matrix[i][j]) {
                        mmax = matrix[i][j];
                    }
                }
            }
            return;
        }

        int count=here_C;
        count++;

        moveRight(matrix, count);
        moveLeft(matrix, count);
        moveTop(matrix, count);
        moveDown(matrix, count);
    }

    public int[][] copy(int[][] matrix) {
        int[][] new_matrix = new int[size][size];
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                new_matrix[i][j] = matrix[i][j];
            }
        }
        return new_matrix;
    }

    public int[][] pushDown(int[][] matrix, int x, int y) {
        for(int i=x; i>0; i--) {
            matrix[i][y] = matrix[i-1][y];
        }
        matrix[0][y]=0;
        return matrix;
    }
    public void moveDown(int[][] mat, int count){
        int[][] matrix = copy(mat);
        matrix = shiftBottom(matrix);

        for(int i=size-2; i>=0; i--) {
            for(int j=0; j<size; j++) {
                if(matrix[i+1][j] != 0) {
                    if (matrix[i][j] == matrix[i + 1][j]) {
                        matrix[i+1][j] = matrix[i][j] * 2;
                        matrix = pushDown(matrix, i, j);
                    }
                }
            }
//            print(matrix);
        }
        solve(matrix, count);
    }

    public void moveTop(int[][] mat, int count){
        int[][] matrix = copy(mat);
        matrix = shiftTop(matrix);

        for(int i=1; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (matrix[i - 1][j] != 0) {
                    if (matrix[i][j] == matrix[i - 1][j]) {
                        matrix[i - 1][j] = matrix[i][j] * 2;
                        matrix[i][j] = 0;
                        matrix = shiftTop(matrix);
                    }
                }
            }
        }
        solve(matrix, count);
    }
    public void moveRight(int[][] mat, int count){
        int[][] matrix = copy(mat);
        matrix = shiftRight(matrix);

        for(int j=size-2; j>=0; j--) {
            for(int i=0; i< size; i++) {
                if(matrix[i][j+1] != 0) {
                    if (matrix[i][j] == matrix[i][j+1]) {
                        matrix[i][j+1] = matrix[i][j] * 2;
                        matrix[i][j] = 0;
                        matrix = shiftRight(matrix);
                    }
                }
            }
        }
        solve(matrix, count);

    }
    public void moveLeft(int[][] mat, int count){
        int[][] matrix = copy(mat);
        matrix = shiftLeft(matrix);

        for(int j=1; j<size; j++) {
            for(int i=0; i< size; i++) {
                if(matrix[i][j-1] != 0) {
                    if (matrix[i][j] == matrix[i][j-1]) {
                        matrix[i][j-1] = matrix[i][j] * 2;
                        matrix[i][j] = 0;
                        matrix = shiftLeft(matrix);
                    }
                }
            }
        }
        solve(matrix, count);
    }


    public int[][] shiftTop(int[][] mat) {
        int[][] matrix = copy(mat);
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                int num=1;
                if(matrix[i][j] == 0) {
                    while(i+num < size) {
                        if(matrix[i+num][j] != 0) {
                            matrix[i][j] = matrix[i+num][j];
                            matrix[i+num][j] = 0;
                            break;
                        }
                        num++;
                    }
                }
            }
        }
        return matrix;
    }
    public int[][] shiftBottom(int[][] mat) {
        int[][] matrix = copy(mat);
        for(int i=size-1; i>=0; i--) {
            for(int j=0; j<size; j++) {
                int num=-1;
                if(matrix[i][j] == 0) {
                    while(i+num >=0) {
                        if(matrix[i+num][j] != 0) {
                            matrix[i][j] = matrix[i+num][j];
                            matrix[i+num][j] = 0;
                            break;
                        }
                        num--;
                    }
                }
            }
        }
        return matrix;
    }
    public int[][] shiftRight(int[][] mat) {
        int[][] matrix = copy(mat);
        for(int i=0; i<size; i++) {
            for(int j=size-1; j>=0; j--) {
                int num=-1;
                if(matrix[i][j] == 0) {
                    while(j+num >=0) {
                        if(matrix[i][j+num] != 0) {
                            matrix[i][j] = matrix[i][j+num];
                            matrix[i][j+num] = 0;
                            break;
                        }
                        num--;
                    }
                }
            }
        }
        return matrix;
    }
    public int[][] shiftLeft(int[][] mat) {
        int[][] matrix = copy(mat);
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                int num=1;
                if(matrix[i][j] == 0) {
                    while(j+num < size) {
                        if(matrix[i][j+num] != 0) {
                            matrix[i][j] = matrix[i][j+num];
                            matrix[i][j+num] = 0;
                            break;
                        }
                        num++;
                    }
                }
            }
        }
        return matrix;
    }
    public void print(int[][] matrix) {
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++){
                System.out.print(matrix[i][j]+"      ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
