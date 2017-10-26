import java.util.Scanner;

public class DP_2156_2_Bread {
	public static void main(String[] args) {
		int result = 0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n+1];
		int[] D = new int[n+1];
		for (int i = 1; i <=n; i++)
			A[i] = sc.nextInt();
		D[0] = 0;
		D[1] = A[1];
		D[2] = A[1]+A[2];
		for(int i=3;i<=n;i++) {
			D[i] = Math.max(D[i-1], D[i-2]+A[i]);
			D[i] = Math.max(D[i], D[i-3]+A[i]+A[i-1]);
		}
		System.out.println(D[n]);
	}
}
