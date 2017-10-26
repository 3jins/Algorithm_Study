import java.util.Scanner;

public class SAMSUNG_14501_2_Bread {
	int[][] tt;
	int max=0;
	int dn;
	public int start() {
		Scanner sc = new Scanner(System.in);
		dn = sc.nextInt();
		tt = new int[dn][2];
		for(int i=0;i<dn;i++) {
			tt[i][0] = sc.nextInt();
			tt[i][1] = sc.nextInt();
		}
		for(int i=1;i<=dn;i++) 
			schedule(i, 0, new int[i]);
		return max;
	}
	public void schedule(int num, int from, int[] select) {
		if(num==0) {
			int[] sch = new int[dn];
			for(int i=0;i<select.length;i++) {
				if(select[i]+tt[select[i]][0]>dn) return;
				for(int j=select[i];j<select[i]+tt[select[i]][0];j++) {
					sch[j]++;
					if(sch[j]>1)return;
				}
			}
			int result =0;
			for(int i=0;i<select.length;i++) {
				result+=tt[select[i]][1];
			}
			max = Math.max(result, max);
			return;
		}
		for(int i=from;i<dn;i++) {
			select[select.length-num] = i;
			schedule(num-1,i+1,select);
		}
	}
	public static void main(String[] args) {
		SAMSUNG_14501_2_Bread s = new SAMSUNG_14501_2_Bread();
		System.out.println(s.start());
	}
}
