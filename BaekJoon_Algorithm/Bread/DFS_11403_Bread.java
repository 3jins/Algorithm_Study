import java.util.Scanner;
import java.util.Stack;

public class DFS_11403_Bread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int[][] a = new int[num][num];
		//System.out.println();
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				a[i][j] = sc.nextInt();
				//System.out.print(a[i][j]+" ");
			}
		}
		
		DFS b = new DFS(num, a);
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				if(j!=0)
					System.out.print(" "+b.search(i, j));
				else
					System.out.print(b.search(i, j));
				
			}
			System.out.println();
		}
		System.exit(0);
	}
		
		static class DFS {

			int num;
			boolean[] visited;
			boolean flag;
			int[][] a = null;
			public DFS(int num,int[][] a) {
				this.num = num;
				this.a = a;
			}
			public int search(int i, int j) {
				Stack<Integer> s = new Stack<Integer>();
				visited = new boolean[num];
				
				//visited[i] = true;
				s.push(i);
				
				while(!s.isEmpty()) {
					int v = s.peek();	//0, 1
					//if(v==j)return 1;
					flag = false;
					for(int x=0; x<a.length;x++) {
						if(a[v][x]==1&&(!visited[x])) {
							s.push(x);
							visited[x] = true;
							flag = true;
							break;
						}
					}
					if(!flag) {
						s.pop();
					}
				}
				if(visited[j]==true)
					return 1;
				else if(visited[j]==false)
					return 0;
				else
					return -1;
				
			}
		}
		
	}
