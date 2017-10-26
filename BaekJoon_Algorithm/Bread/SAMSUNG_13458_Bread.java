import java.util.Scanner;

public class SAMSUNG_13458_Bread {

	int n;
	int[] p;
	int b;
	int c;
	long min;

	public long start() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}
		b = sc.nextInt();
		c = sc.nextInt();
		System.out.println("n : "+n);
		long bNum = 0;
		for (int i = 0; i < n; i++) {
			if(p[i]-b<=0)continue;
			bNum += (p[i]-b)/c;
			if((p[i]-b)%c!=0)bNum++;
		}
		min = bNum + n;
		System.out.println("min : "+min);
		System.out.println("bNum : "+bNum);
		System.out.println("n : "+n);
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SAMSUNG_13458_Bread s = new SAMSUNG_13458_Bread();
		System.out.println(s.start());
		System.exit(0);
	}

}
