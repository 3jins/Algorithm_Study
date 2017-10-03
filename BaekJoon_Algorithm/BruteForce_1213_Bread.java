import java.util.Arrays;
import java.util.Scanner;

public class BruteForce_1213_Bread {

	static int n;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=  new Scanner(System.in);
		char[] name = sc.nextLine().toCharArray();
		n = name.length;
		char[] arr = new char[n];
		char[] samearr = new char[n/2];
		int ind= 0;
		char dif = 0;
		int difNum=0;
	
		for(int i=0;i<n;i++) {
			boolean flag = false;
			for(int j=i+1;j<n;j++) {
				if(name[i]==name[j] &&ind<samearr.length) {
					samearr[ind++] = name[i];
					name[i] = 0;
					name[j] = 0;
					flag = true;
					break;
				}
			}
			if(!flag && name[i]>0) {
				difNum++;
				dif = name[i];
				System.out.println("dif : "+dif);
			}
			
		}
		Arrays.sort(samearr);
		if(difNum==0) {
			for(int i=0;i<n/2;i++) {
				arr[i] = samearr[i];
				arr[n-1-i] = samearr[i];
			}
		}
		if(difNum==1) {
			arr[n/2] = dif;
			for(int i=0;i<n/2;i++) {
				arr[i] = samearr[i];
				arr[n-1-i] = samearr[i];
			}
		}
		if(difNum!=0 && difNum!=1) {
			System.out.println("I'm Sorry Hansoo");
		}
		for(int i=0;i<n;i++)
			System.out.print(arr[i]);
	}

}
