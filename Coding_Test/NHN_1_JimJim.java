import java.lang.reflect.Array;
import java.util.*;


//NHN 모의테스트 1
public class NHN_1_JimJim {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String total_num = scan.nextLine();
        String[] num_st = total_num.split(" ");
        double temp_x, temp_y;
        double[][] num = new double[num_st.length][2];

        for(int i=0; i<num_st.length; i++) {
            num[i][0] = Integer.parseInt(num_st[i]);
            if((int)num[i][0]/10 != 0){
                num[i][0] = num[i][0]/10;
                num[i][1] = 1;
            } else {
                num[i][1] = 0;
            }
        }

        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length - 1 - i; j++) {

                if((int)num[j][0] == (int)num[j + 1][0]) {
                    if (num[j][1] == 1) {
                        if (num[j + 1][1] == 0) {
                            if ((num[j][0] * 10) % 10 > num[j + 1][0]) {
                                temp_x = num[j][0];
                                num[j][0] = num[j + 1][0];
                                num[j + 1][0] = temp_x;

                                temp_y = num[j][1];
                                num[j][1] = num[j + 1][1];
                                num[j + 1][1] = temp_y;
                                break;
                            }
                        }
                    } else {
                        if(num[j+1][1] == 1) {
                            if (num[j][0] > (num[j + 1][0]*10)%(10)) {
                                temp_x = num[j][0];
                                num[j][0] = num[j + 1][0];
                                num[j + 1][0] = temp_x;

                                temp_y = num[j][1];
                                num[j][1] = num[j + 1][1];
                                num[j + 1][1] = temp_y;
                                break;
                            }
                        }
                    }
                }
                if (num[j][0] > num[j + 1][0]) {
                    temp_x = num[j][0];
                    num[j][0] = num[j + 1][0];
                    num[j + 1][0] = temp_x;

                    temp_y = num[j][1];
                    num[j][1] = num[j + 1][1];
                    num[j + 1][1] = temp_y;
                }

            }
        }

        String min_num = "";
        String max_num = "";
        int min_num_int;
        int max_num_int;

        for(int i=0; i<num.length; i++) {
            if(num[i][1] == 1){
                min_num += (int)(num[i][0]*10);
            } else {
                min_num += (int)num[i][0];
            }

            if(num[num.length-i-1][1] == 1) {
                max_num += (int)(num[num.length-i-1][0]*10);
            } else {
                max_num += (int)num[num.length-i-1][0];
            }
        }
        min_num_int = Integer.parseInt(min_num);
        max_num_int = Integer.parseInt(max_num);
        System.out.println(max_num_int +min_num_int);
    }
}
