import java.util.Scanner;

public class DP_2156_Bread {

	static int[] price;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int result = 0;
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		price = new int[num];
		for (int i = 0; i < num; i++)
			price[i] = sc.nextInt();
		String[] s = { "110", "011", "010" };

		if (num == 1)
			result = price[0];
		else if (num == 2)
			result = price[0] + price[1];
		else {
			for (int i = 0; i < 3; i++) {
				result = Math.max(result, getTotalSum(drinkMax(num, s[i])));
			}
		}
		System.out.println(result);
	}

	public static String drinkMax(int n, String s) {
		for (int i = 0; i < n - 3; i++) {
			int lastind = s.length() - 1;
			if (s.charAt(lastind - 1) == '1' && s.charAt(lastind) == '1')
				s = s+"0";
			else if (s.charAt(lastind - 1) == '1' && s.charAt(lastind) == '0')
				s = s+"1";
			else if (s.charAt(lastind - 1) == '0' && s.charAt(lastind) == '1')
				s = s+"1";
		}
		return s;
	}
	public static int getTotalSum(String s) {
		System.out.println("String : "+s);
		int sum=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='1')sum+=price[i];
		}
		return sum;
	}
}
