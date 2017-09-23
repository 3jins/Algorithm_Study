import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NHN_1_Bread {

	public static void main(String[] args) {
		boolean flag = false;
		//Map<Integer, Boolean> p = new HashMap<Integer, Boolean>();
		ArrayList<Integer> p = new ArrayList<Integer>();
		boolean[] exist = new boolean[7];
		ArrayList<Integer> rm = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<9;i++) {
			int temp = sc.nextInt();
			if(p.size()<3) {
				p.add(temp);
				exist[temp] = true;
				for(int j=0;j<p.size();j++) {
					System.out.print(p.get(j)+" ");
				}System.out.println();
			}else {
				if(exist[temp]) {	//중복된게 있으면 주머니에 새로.동료
					p.remove(p.indexOf(temp));
					p.add(temp);
					for(int j=0;j<p.size();j++) {
						System.out.print(p.get(j)+" ");
					}System.out.println();
				}else{
					int last = p.get(0);
					p.remove(0);
					exist[last] = false;
					rm.add(last);
					
					p.add(temp);
					exist[temp] = true;
					for(int j=0;j<p.size();j++) {
						System.out.print(p.get(j)+" ");
					}System.out.println();
				}
			}
		}
		if(rm.size()==0)System.out.println("0");
		else{
			for(int i=0;i<rm.size();i++) {
			System.out.println(rm.get(i));
		}
		}
	}
	
}