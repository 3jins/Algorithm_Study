import java.util.Scanner;
public class SAMSUNG_14501_2_Bread {

	static int result=0;
	static int days;
	static int[] p;
	static int[] t;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		days = sc.nextInt();
		t = new int[days];
		p = new int[days];
		for(int i=0;i<days;i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		for(int i=1;i<=days;i++) {
			makeTimeTable(0, i, i, new int[i], new int[days]);
		}
		System.out.println("result : "+result);
	}
	public static void makeTimeTable(int from, int sN, int n, int[] select, int[] schedule) {
		if(n==0) {
			int sum=0;
			for(int i=0;i<days;i++) {
				if(schedule[i]>1) 
					return;
			}
			for(int i=0;i<sN;i++)
				sum+=p[select[i]];
			result = Math.max(result, sum);
			return;
		}
		for(int i=from;i<days;i++) {
			if((i+t[i])<=days) {
				select[sN-n] = i;
				for(int j=i;j<i+t[i];j++) {
					schedule[j]++;
				}
				makeTimeTable(i+1, sN, n-1, select, schedule);
				for(int j=i;j<i+t[i];j++) {
					schedule[j]--;
				}
			}
		}
	}
}
