import java.util.Scanner;

public class DP_11052_Bread {
	static int bNum;
	static int[] d;
	static int[] p;
	static int result=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		bNum = sc.nextInt();
		p = new int[bNum+1];
		d = new int[bNum+1];
		for(int i=1;i<=bNum;i++) {
			p[i] = sc.nextInt();
		}
		for(int i=1;i<=bNum;i++) {
			for(int j=1;j<=i;j++) {
				d[i] = Math.max(d[i],d[i-j]+p[j]);
			}
		}
		System.out.println(d[bNum]);
	}
}
