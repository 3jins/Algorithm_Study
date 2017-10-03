import java.util.Arrays;
import java.util.Scanner;

public class BruteForce_2309_Bread {

	static int[] answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] d = new int[9];
		answer = new int[7];
		for(int i=0;i<9;i++)
			d[i] = sc.nextInt();
		selectDwarf(0, 7, d, new int[7]);
		Arrays.sort(answer);
		for(int i=0;i<7;i++)
			System.out.println(answer[i]);
	}
	public static void selectDwarf(int from, int n, int[] d, int[] select) {
		if(n==0) {
			int sum=0;
			for(int i=0;i<7;i++)
				sum+=select[i];
			if(sum==100){
				for(int i=0;i<7;i++)
					answer[i] = select[i];
			}
			return;
		}
		else {
			for(int i=from;i<9;i++) {
				select[7-n] = d[i];
				selectDwarf(i+1, n-1, d, select);
			}
		}
	}

}
