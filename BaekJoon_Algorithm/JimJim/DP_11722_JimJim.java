import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jimin on 10/5/17.
 */
public class DP_11722_JimJim {
    public static void main(String[] argv) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] matrix = new int[size];
        for(int i=0; i<size; i++) {
            matrix[i] = scan.nextInt();
        }
        int anw = func(size, matrix);

        System.out.println(anw);
    }

    public static int func(int size, int[] matrix) {
        int count=0;
        ArrayList<Integer>[] list = (ArrayList<Integer>[])new ArrayList[size];
        for(int i=0; i<size; i++) {
            list[i] = new ArrayList<Integer>();
            list[i].add(matrix[i]);
            for(int j=i+1; j<size; j++) {
//                System.out.println(matrix[i]+" "+ matrix[j]);
                if(matrix[i] > matrix[j]) {
                    int len = list[i].size();
                    System.out.println(len);
                    if(list[i].get(len-1) > matrix[j]) {
                        list[i].add(matrix[j]);
                        System.out.print(j + " ");
                        System.out.println(list[i].get(len-1)+" "+matrix[j]);
                    }
                }
            }

            if(count < list[i].size()) {
                count = list[i].size();
            }
        }
        return count;
    }
}
