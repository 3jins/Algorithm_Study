import java.util.Scanner;

public class BF_7568_Bread {
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n= sc.nextInt();
		Person[] p = new Person[n];
		for(int i=0;i<n;i++) {
			p[i] = new Person(i, sc.nextInt(), sc.nextInt());
		}
		for(int i=0;i<n;i++) {
			int cnt=1;
			for(int j=0;j<n;j++) {
				if(p[i].w<p[j].w && p[i].h<p[j].h) {
					cnt++;
				}
			}
			if(i==0)System.out.print(cnt);
			else System.out.print(" "+cnt);
		}
	}
}
class Person{
	int name;
	int w;
	int h;
	int grade;
	public Person(int name, int w, int h) {
		this.name = name;
		this.w = w;
		this.h = h;
	}
}