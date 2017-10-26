import java.util.Scanner;

public class SAMSUNG_13460_JimJim {
    static int row;
    static int col;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SAMSUNG_13460_JimJim main = new SAMSUNG_13460_JimJim();

        Scanner scan = new Scanner(System.in);
        row = scan.nextInt();
        col = scan.nextInt();
        String[] shape = new String[row];
        for (int i = 0; i < row; i++) {
            shape[i] = scan.next();
        }

        int[][] matrix = new int[row][col];
        int start_ax=0, start_ay=0;
        int start_bx=0, start_by=0;
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col ; j++) {
                char shap = shape[i].charAt(j);
                switch (shap) {
                    case '#':
                        matrix[i][j] = 0;
                        break;
                    case '.':
                        matrix[i][j] = 1;
                        break;
                    case 'O':
                        matrix[i][j] = 9;
                        break;
                    case 'R':
                        matrix[i][j] = 3;
                        start_ax=i;
                        start_ay=j;
                        break;
                    case 'B':
                        matrix[i][j] = 4;
                        start_bx=i;
                        start_by=j;
                        break;
                    default:
                        break;
                }
            }
        }

        int count=0;
        main.dfs(matrix, start_ax, start_ay, start_bx, start_by, count);
        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
        scan.close();
    }

    public void print(int[][] matrix) {
        for(int i=0; i< row; i++) {
            for(int j=0; j<col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void dfs(int[][] matrix, int ax, int ay, int bx, int by, int count) {
        if(count == 10) {
            return;
        }
        int index=count;
        index++;
        moveBottom(matrix, ax, ay, bx, by, index);
        moveTop(matrix, ax, ay, bx, by, index);
        moveRight(matrix, ax, ay, bx, by, index);
        moveLeft(matrix, ax, ay, bx, by, index);
    }

    public void moveBottom(int[][] mat,int ax, int ay, int bx, int by, int count) {
        int[][] matrix = copy(mat);

        if(ax+1 >= row) {
            return;
        }
        int check = matrix[ax+1][ay];
        if(check == 0) {
            matrix = shiftBottom(matrix, bx, by);
            if (matrix[0][0] == -1) {
                return;
            }
        } else {
            if(ax <= bx) {
                matrix = shiftBottom(matrix, bx, by);
                if(matrix[0][0] == 8) {
                    return;
                }
                matrix = shiftBottom(matrix, ax, ay);
            } else {
                matrix = shiftBottom(matrix, ax, ay);
                if(matrix[0][0] == 7) {
                    matrix = shiftBottom(matrix, bx, by);
                    if(matrix[0][0] != 8) {
                        if(findMin(count, min)==count) {
                            min = count;
                        }
                    }
                    return;
                }
                matrix = shiftBottom(matrix, bx, by);
            }
        }

        if(matrix[0][0] == 8) {
            return;
        } else if(matrix[0][0] == 7) {
            if(findMin(count, min)==count) {
                min = count;
            }
            return;
        } else {
            int[] point = getPoint(matrix);
            ax = point[0];
            ay = point[1];
            bx = point[2];
            by = point[3];

            matrix[0][0] = 0;
            dfs(matrix, ax, ay, bx, by, count);
            return;
        }
    }

    public int[][] shiftBottom(int[][] mat,int ball_x, int ball_y) {
        int[][] matrix = copy(mat);
        matrix[0][0] = 0;
        boolean flag = false;
        for(int i=ball_x; i<row; i++) {
            int check = matrix[i+1][ball_y];
            switch(check) {
                case 0 :
                    if(!flag) {
                        matrix[0][0] = -1;
                    }
                    return matrix;
                case 1 :
                    matrix[i + 1][ball_y] = matrix[i][ball_y];
                    matrix[i][ball_y] = 1;
                    flag = true;
                    break;
                case 3: // red ball
                    if(!flag) {
                        matrix[0][0] = -1;
                    }
                    return matrix;
                case 4: // blue ball
                    if(!flag) {
                        matrix[0][0] = -1;
                    }
                    return matrix;
                case 9:
                    if(matrix[i][ball_y] == 3) {
                        matrix[0][0] = 7;
                    } else if(matrix[i][ball_y] ==4) {
                        matrix[0][0] = 8;
                    }
                    matrix[i][ball_y] = 1;
                    return matrix;
            }
        }
        return matrix;
    }

    public int[][] shiftTop(int[][] mat,int ball_x, int ball_y) {
        int[][] matrix = copy(mat);
        matrix[0][0] = 0;
        boolean flag = false;
        for(int i=ball_x; i>0; i--) {
            int check = matrix[i-1][ball_y];
            switch(check) {
                case 0 :
                    if(!flag) {
                        matrix[0][0] = -1;
                    }
                    return matrix;
                case 1 :
                    matrix[i - 1][ball_y] = matrix[i][ball_y];
                    matrix[i][ball_y] = 1;
                    flag = true;
                    break;
                case 3: // red ball
                    if(!flag) {
                        matrix[0][0] = -1;
                    }
                    return matrix;
                case 4: // blue ball
                    if(!flag) {
                        matrix[0][0] = -1;
                    }
                    return matrix;
                case 9:
                    if(matrix[i][ball_y] == 3) {
                        matrix[0][0] = 7;
                    } else if(matrix[i][ball_y] ==4) {
                        matrix[0][0] = 8;
                    }
                    matrix[i][ball_y] = 1;
                    return matrix;
            }
        }
        return matrix;
    }

    public void moveTop(int[][] mat,int ax, int ay, int bx, int by, int count) {
        int[][] matrix = copy(mat);
        if(ax-1 <0) {
            return;
        }

        int check = matrix[ax-1][ay];
        if(check == 0) {
            matrix = shiftTop(matrix, bx, by);
            if(matrix[0][0] == -1) {
                return;
            }
        } else {
            if(ax >= bx) {
                matrix = shiftTop(matrix, bx, by);
                if(matrix[0][0] == 8) {
                    return;
                }
                matrix = shiftTop(matrix, ax, ay);
            } else {
                matrix = shiftTop(matrix, ax, ay);
                if(matrix[0][0] == 7) {
                    matrix = shiftTop(matrix, bx, by);
                    if(matrix[0][0] != 8) {
                        if(findMin(count, min)==count) {
                            min = count;
                        }
                    }
                    return;
                }
                matrix = shiftTop(matrix, bx, by);
            }
        }

        if(matrix[0][0] == 8) {
            return;
        } else if(matrix[0][0] == 7) {
            if(findMin(count, min)==count) {
                min = count;
            }
            return;
        } else {
            int[] point = getPoint(matrix);
            ax = point[0];
            ay = point[1];
            bx = point[2];
            by = point[3];
            matrix[0][0] = 0;
            dfs(matrix, ax, ay, bx, by, count);
            return;
        }
    }

    public int[][] shiftRight(int[][] mat,int ball_x, int ball_y) {
        int[][] matrix = copy(mat);
        boolean flag = false;
        matrix[0][0] = 0;

        for(int i=ball_y; i<col; i++) {
            int check = matrix[ball_x][i+1];
            switch(check) {
                case 0 :
                    if(!flag) {
                        matrix[0][0] = -1;
                    }
                    return matrix;
                case 1 :
                    matrix[ball_x][i+1] = matrix[ball_x][i];
                    matrix[ball_x][i] = 1;
                    flag = true;
                    break;
                case 3: // red ball
                    if(!flag) {
                        matrix[0][0] = -1;
                    }
                    return matrix;
                case 4: // blue ball
                    if(!flag) {
                        matrix[0][0] = -1;
                    }
                    return matrix;
                case 9:
                    if(matrix[ball_x][i] == 3) {
                        matrix[0][0] = 7;
                    } else if(matrix[ball_x][i] ==4) {
                        matrix[0][0] = 8;
                    }
                    matrix[ball_x][i] = 1;
                    return matrix;
            }
        }

        return matrix;
    }

    public void moveRight(int[][] mat,int ax, int ay, int bx, int by, int count) {
        int[][] matrix = copy(mat);

        if(ay+1 >= col) {
            return;
        }

        int check = matrix[ax][ay+1];
        if(check == 0) {
            matrix = shiftRight(matrix, bx, by);
            if(matrix[0][0] == -1) {
                return;
            }
        } else {
            if(ay <= by) {
                matrix = shiftRight(matrix, bx, by);
                if(matrix[0][0] == 8) {
                    return;
                }
                matrix = shiftRight(matrix, ax, ay);
            } else {
                matrix = shiftRight(matrix, ax, ay);
                if(matrix[0][0] == 7) {
                    matrix = shiftRight(matrix, bx, by);
                    if(matrix[0][0] != 8) {
                        if(findMin(count, min)==count) {
                            min = count;
                        }
                    }
                    return;
                }
                matrix = shiftRight(matrix, bx, by);
            }
        }

        if(matrix[0][0] == 8) {
            return;
        }  else if(matrix[0][0] == 7) {
            if(findMin(count, min)==count) {
                min = count;
            }
            return;
        }  else {
            int[] point = getPoint(matrix);
            ax = point[0];
            ay = point[1];
            bx = point[2];
            by = point[3];
            matrix[0][0] = 0;
            dfs(matrix, ax, ay, bx, by, count);
            return;
        }
    }

    public int[][] shiftLeft(int[][] mat,int ball_x, int ball_y) {
        int[][] matrix = copy(mat);
        matrix[0][0] = 0;
        boolean flag = false;
        for(int i=ball_y; i>0; i--) {
            int check = matrix[ball_x][i-1];
            switch(check) {
                case 0 :
                    if(!flag) {
                        matrix[0][0] = -1;
                    }
                    return matrix;
                case 1 :
                    matrix[ball_x][i-1] = matrix[ball_x][i];
                    matrix[ball_x][i] = 1;
                    flag = true;
                    break;
                case 3: // red ball
                    if(!flag) {
                        matrix[0][0] = -1;
                    }
                    return matrix;
                case 4: // blue ball
                    if(!flag) {
                        matrix[0][0] = -1;
                    }
                    return matrix;
                case 9:
                    if(matrix[ball_x][i] == 3) {
                        matrix[0][0] = 7;
                    } else if(matrix[ball_x][i] ==4) {
                        matrix[0][0] = 8;
                    }
                    matrix[ball_x][i] = 1;
                    return matrix;
                default:
                    break;
            }
        }

        return matrix;
    }

    public void moveLeft(int[][] mat,int ax, int ay, int bx, int by, int count) {
        int[][] matrix = copy(mat);
        if(ay-1 <0) {
            return;
        }
        int check = matrix[ax][ay-1];
        if(check == 0) {
            matrix = shiftLeft(matrix, bx, by);
            if(matrix[0][0] == -1) {
                return;
            }
        } else {
            if(ay >= by) {
                matrix = shiftLeft(matrix, bx, by);
                if(matrix[0][0] == 8) {
                    return;
                }
                matrix = shiftLeft(matrix, ax, ay);
            } else {
                matrix = shiftLeft(matrix, ax, ay);
                if(matrix[0][0] == 7) {
                    matrix = shiftLeft(matrix, bx, by);
                    if(matrix[0][0] != 8) {
                        if(findMin(count, min)==count) {
                            min = count;
                        }
                    }
                    return;
                }
                matrix = shiftLeft(matrix, bx, by);
            }
        }


        if(matrix[0][0] == 8) {
            return;
        } else if(matrix[0][0] == 7) {
            if (findMin(count, min) == count) {
                min = count;
            }
            return;
        } else {
            int[] point = getPoint(matrix);
            ax = point[0];
            ay = point[1];
            bx = point[2];
            by = point[3];
            matrix[0][0] = 0;
            dfs(matrix, ax, ay, bx, by, count);
            return;
        }
    }

    public int findMin(int a, int b) {
        return a<b?a:b;
    }

    public int[][] copy(int[][] matrix) {
        int[][] new_arr = new int[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                new_arr[i][j] = matrix[i][j];
            }
        }
        return new_arr;
    }

    public int[] getPoint(int[][] mat) {
        int[] point = {0,0,0,0};
        for(int i=0; i<row; i++) {
            for(int j=0;j<col; j++) {
                if(mat[i][j] == 3) {
                    point[0] = i;
                    point[1] = j;
                } else if (mat[i][j] == 4) {
                    point[2] = i;
                    point[3] = j;
                }
            }
        }
        return point;
    }
}
