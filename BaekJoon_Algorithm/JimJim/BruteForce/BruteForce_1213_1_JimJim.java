package JimJim;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jimin on 10/3/17.
 */
public class BruteForce_1213_1_JimJim {
    public static void main(String argv[]) {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        int length = name.length();

        int check = 0;
        int[] name_int = new int[name.length()];
        char[] aws = new char[name.length()];
        int count=0;

        for(int i=0; i<length; i++) {
            name_int[i] = (int)name.charAt(i);
        }
        Arrays.sort(name_int);

        char middle=' ';
        for(int i=0; i<length; i++) {
            if(i+1<length) {
                if(name_int[i] != name_int[i+1]) {
                    if(check != 0) {
                        System.out.println("I\'m Sorry Hansoo");
                        return;
                    } else {
                        middle = (char)name_int[i];
                        check = name_int[i];
                    }
                } else {
                    if(count<length/2) {
                        aws[count] = (char)name_int[i];
                        aws[length - count-1] = (char)name_int[i];
                        count++;
                    }
                    i++;
                }
            } else {
                if(check!=0 && check!= name_int[i]) {
                    System.out.println("I\'m Sorry Hansoo");
                    return;
                } else {
                    middle = (char)name_int[i];
                }
            }
            if(length%2 == 1) {
                aws[length / 2 ] = middle;
            }
        }

        for(int i=0; i<length; i++) {
            System.out.print(aws[i]);
        }
    }
}
