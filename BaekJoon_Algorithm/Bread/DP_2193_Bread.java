import java.util.Scanner;

public class DP_2193_Bread {

	static long[] d;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		d = new long[91];
		long result = D(num);
		System.out.println(result);
	}
	public static long D(int n) {
		if(n==0) return 1;
		if(n==1) return 1;
		if(n==2) return 1;
		else {
			for(int i=0;i<=n-2;i++) {
				if(d[i]!=0)d[n]+=d[i];
				else d[n] += D(i);
			}
			return d[n];
		}
	}
}