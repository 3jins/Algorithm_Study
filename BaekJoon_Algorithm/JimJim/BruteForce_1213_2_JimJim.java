import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jimin on 10/3/17.
 */
public class BruteForce_1213_2_JimJim {
    public static void main(String argv[]) {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        int length = name.length();
        char middle=' ';

        int check = 0;
        int[] name_int = new int[26];
        char[] aws = new char[name.length()];
        int count=0;
        for(int i=0; i<26;i++) {
            name_int[i] = 0;
        }
        for(int i=0; i<length; i++) {
            name_int[(int)name.charAt(i)-65]++;
        }

        for(int i=0; i<length; i++) {
            if (name_int[(int) name.charAt(i) - 65] % 2 == 1) {
                if (check == 0) {
                    check = (int) name.charAt(i);
                } else {
                    System.out.println("I\'m Sorry Hansoo");
                    return;
                }
            }
        }

        for(int i=0; i<26; i++) {
            if(count<length/2 && name_int[i]!=0) {
                aws[count] = (char)name_int[i];
                aws[length-count-1] = (char)name_int[i];
                count++;
                if(name_int[(int)name.charAt(i)-65]%2 == 1) {
                    aws[length/2] = middle;
                    System.out.println(middle);
                }
            }
        }

        for(int i=0; i<length; i++) {
            System.out.print(aws[i]);
        }
    }
}
