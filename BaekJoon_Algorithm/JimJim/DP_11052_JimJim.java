import java.util.*;

/**
 * Created by Jimin on 10/2/17.
 */
public class DP_11052_JimJim {
    static int num=0;
    static int[] save;
    static int count=0;
    public static void main(String[] agrv) {
        Scanner scan = new Scanner(System.in);
        num = scan.nextInt();
        int[] num_array = new int[num];
        save = new int[num];
        for(int i=0; i<num; i++) {
            num_array[i] = Integer.parseInt(scan.next());
        }
        fish(num, 2);
        System.out.println(count);
    }
    public static int fish(int size, int index) {
        if(size==index || index==0) {
            System.out.println(size + " "+ index);
            count++;
            return 1;
        }
        return fish(size-1,index-1) + fish(size-1, index);
    }
}
