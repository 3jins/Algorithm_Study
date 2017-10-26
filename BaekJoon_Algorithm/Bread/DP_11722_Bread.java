import java.util.Scanner;
import java.util.Stack;

public class DP_11722_Bread {

	static int n;
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		int result =0;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++)
			result = Math.max(result, d(i));
		System.out.println(result);
	}
	public static int d(int from) {
		Stack<Integer> s = new Stack<Integer>();
		int init = arr[from];
		s.push(init);
		for(int i=from;i<n-1;i++) {
			if(s.peek()>arr[i+1]) {
				s.push(arr[i+1]);
			}else if(s.peek()<=arr[i+1] && init>arr[i+1]){
				s.pop();
				s.push(arr[i+1]);
			}else if(s.peek()<=arr[i+1] && init<arr[i+1]){
				break;
			}
		}
		for(int i=0;i<s.size();i++) {
			System.out.print(s.get(i)+" ");
		}System.out.println();
		return s.size();
	}
}
