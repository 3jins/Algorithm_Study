import java.util.ArrayList;
import java.util.Scanner;

public class SAMSUNG_14502_2_Bread {
	int n, m;
	int map[][];
	int max=0;
	int[] dx = {1,-1,0,0};
	int[] dy = {0,0,1,-1};
	boolean[][] isVisited;
	ArrayList<Point> e = new ArrayList<Point>();
	ArrayList<Point> v = new ArrayList<Point>();
	int wallNum=0;
	
	public int start() {
		int answer = 0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==0)e.add(new Point(i, j));
				else if(map[i][j]==2)v.add(new Point(i,j));
				else if(map[i][j]==1)wallNum++;
			}
		}
		threeChosenMap(3, 0, new Point[3]);
		answer = max;
		return answer;
	}
	public void threeChosenMap(int num, int from, Point[] s) {
		if(num==0) {
			int[][] cmap = new int[n][m];	//원래 맵 복제
			for(int i=0;i<n;i++) {	
				for(int j=0;j<m;j++) {
					cmap[i][j] = map[i][j];
				}
			}
			for(int i=0;i<3;i++)cmap[s[i].x][s[i].y] = 1;	//벽 세우고
			isVisited = new boolean[n][m];
			for(int i=0;i<v.size();i++) 
				dfs(v.get(i),cmap);	//바이러스 퍼트리고
			int vc=0;
			for(int i=0;i<n;i++) {	//퍼진 바이러스 갯수 세고
				for(int j=0;j<m;j++) {
					if(isVisited[i][j])vc++;
				}
			}
			max = Math.max((n*m)-vc-wallNum-3, max);	//최대 크기 비교
			return;
		}
		for(int i=from;i<e.size();i++) {
			s[3-num] = e.get(i);
			threeChosenMap(num-1, i+1, s);
		}
		
	}
	public void dfs(Point v, int[][] cmap) {
		isVisited[v.x][v.y]=true;
		cmap[v.x][v.y] = 2;
		for(int i=0;i<4;i++) {
			int nx = v.x+dx[i];
			int ny = v.y+dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny<m) {
				if(!isVisited[nx][ny] && cmap[nx][ny]==0) {
					dfs(new Point(nx, ny), cmap);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SAMSUNG_14502_2_Bread s = new SAMSUNG_14502_2_Bread();
		System.out.println(s.start());
	}
}
class Point{
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
