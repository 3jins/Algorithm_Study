import java.util.Scanner;

public class SAMSUNG_13460_Bread {

	static int mx;
	static int my;
	static char[][] map; 
	static int shortest;
	static char[] shortestpath;
	static P rp;
	static P bp;
	static P gp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		mx = sc.nextInt();
		my = sc.nextInt();
		map = new char[mx][my];
		sc.nextLine();
		for(int i=0;i<mx;i++) {	//initialize map
			String s = sc.nextLine();
			for(int j=0;j<my;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='R') rp = new P(i, j);
				else if(map[i][j]=='B') bp = new P(i, j);
				else if(map[i][j]=='O') gp = new P(i, j);
			}
		}
		int result=-1;
		shortest = mx*my;
		shortestpath = new char[mx*my];
		findGoal(rp.x, rp.y, bp.x, bp.y, new boolean[mx][my], new char[shortestpath.length], -1);
		if(shortest>0)
			result = howmanyDirChanged(shortestpath);
		if(result>0 && result<=10)
			System.out.println(result);
		else
			System.out.println("-1");
	}
	public static void findGoal(int rx, int ry, int bx, int by, boolean[][] isVisited, char dir[], int dirNum) {
		isVisited[rx][ry] = true;
		/*System.out.println("rx : "+rx+", ry : "+ry+"    bx: "+bx+", by : "+by);
		for(int i=0;i<dir.length;i++)System.out.print(dir[i]+" ");
		System.out.println();*/
		
		if(gp.x==bx && gp.y==by) {
			//System.out.println("Blue Goal!   dirNum : "+(dirNum+1));
			shortest=-1;
			return;
		}
		if(gp.x==rx && gp.y==ry) {
			System.out.println("Goal!   dirNum : "+(howmanyDirChanged(dir)));
			int temp = shortest;
			shortest = Math.min(shortest, (dirNum+1));
			if(temp!=shortest) {
				for(int i=0;dir[i]!=0;i++)shortestpath[i] = dir[i];
			}
			return;
		}
		
		if((map[rx-1][ry]=='.' ||map[rx-1][ry]=='O' || map[rx-1][ry]=='B' )&& map[bx-1][by]!='O' && !isVisited[rx-1][ry]   ) {
			dir[dirNum+1] = 'N';
			if(map[bx-1][by]=='.')
				findGoal(rx-1, ry, bx-1, by, isVisited, dir, dirNum+1);
			else if((rx-1)==bx && ry==by && map[bx-1][by]=='#') {	//2번 상황일떄
				dir[dirNum+2] = 'Q';
				dir[dirNum+3] = 'Z';
				if(map[bx][by-1]=='.') {
				findGoal(rx-1, ry, bx, by-1, isVisited, dir, dirNum+3);
				dir[dirNum+2] =0;
				dir[dirNum+3] =0;
				}
				if(map[bx][by+1]=='.') {
				findGoal(rx-1, ry, bx, by+1, isVisited, dir, dirNum+3);
				dir[dirNum+2] =0;
				dir[dirNum+3] =0;
				}
			}
			else
				findGoal(rx-1, ry, bx, by, isVisited, dir, dirNum+1);
			isVisited[rx-1][ry] = false;
			dir[dirNum+1] = 0;
		}
		if((map[rx+1][ry]=='.' ||map[rx+1][ry]=='O' ||map[rx+1][ry]=='B' )&& map[bx+1][by]!='O' && !isVisited[rx+1][ry]) {
			dir[dirNum+1] = 'S';
			if(map[bx+1][by]=='.')
				findGoal(rx+1, ry, bx+1, by, isVisited, dir, dirNum+1);
			else if((rx+1)==bx && ry==by && map[bx+1][by]=='#') {	//3번 상황일떄
				dir[dirNum+2] = 'Q';
				dir[dirNum+3] = 'Z';
				if(map[bx][by+1]=='.') {
				findGoal(rx+1, ry, bx, by+1, isVisited, dir, dirNum+3);
				dir[dirNum+2] =0;
				dir[dirNum+3] =0;
				}
				if(map[bx][by-1]=='.') {
				findGoal(rx+1, ry, bx, by-1, isVisited, dir, dirNum+3);
				dir[dirNum+2] =0;
				dir[dirNum+3] =0;}
			}
			else
				findGoal(rx+1, ry, bx, by, isVisited, dir, dirNum+1);
			isVisited[rx+1][ry] = false;
			dir[dirNum+1] = 0;
			
		}
		if((map[rx][ry-1]=='.' ||map[rx][ry-1]=='O'||map[rx][ry-1]=='B') && map[bx][by-1]!='O' && !isVisited[rx][ry-1]) {
			dir[dirNum+1] = 'W';
			if(map[bx][by-1]=='.')
				findGoal(rx, ry-1, bx, by-1, isVisited, dir, dirNum+1);
			else if((rx)==bx && (ry-1)==by && map[bx][by-1]=='#') {	//1번 상황일떄
				dir[dirNum+2] = 'Q';
				dir[dirNum+3] = 'Z';
				if(map[bx+1][by]=='.') {
				findGoal(rx, ry-1, bx+1, by, isVisited, dir, dirNum+3);
				dir[dirNum+2] =0;
				dir[dirNum+3] =0;
				}
				if(map[bx-1][by]=='.') {
				findGoal(rx, ry-1, bx-1, by, isVisited, dir, dirNum+3);
				dir[dirNum+2] =0;
				dir[dirNum+3] =0;
				}
			}
			else
				findGoal(rx, ry-1, bx, by, isVisited, dir, dirNum+1);
			isVisited[rx][ry-1] = false;
			dir[dirNum+1] = 0;
			
		}
		if((map[rx][ry+1]=='.' ||map[rx][ry+1]=='O'||map[rx][ry+1]=='B' )&& map[bx][by+1]!='O' && !isVisited[rx][ry+1]) {
			dir[dirNum+1] = 'E';
			if(map[bx][by+1]=='.')
				findGoal(rx, ry+1, bx, by+1, isVisited, dir, dirNum+1);
			else if((rx)==bx && (ry+1)==by && map[bx][by+1]=='#') {	//4번 상황일떄
				dir[dirNum+2] = 'Q';
				dir[dirNum+3] = 'Z';
				if(map[bx+1][by]=='.') {
				findGoal(rx, ry+1, bx+1, by, isVisited, dir, dirNum+3);
				dir[dirNum+2] =0;
				dir[dirNum+3] =0;
				}
				if(map[bx-1][by]=='.')
				findGoal(rx, ry+1, bx-1, by, isVisited, dir, dirNum+3);
				dir[dirNum+2] =0;
				dir[dirNum+3] =0;
			}
			else
				findGoal(rx, ry+1, bx, by, isVisited, dir, dirNum+1);
			isVisited[rx][ry+1] = false;
			dir[dirNum+1] = 0;
		}
	}
	public static int howmanyDirChanged(char[] dir) {
		int result =0;
		for(int i=0;i<dir.length-1;i++) {
//			for(int i=0;i<dir.length;i++)System.out.print(dir[i]+" ");
//			System.out.println();
			if(dir[i]!=dir[i+1]) {
				result++;
			}
		}
		return result;
	}
}

class P{
	int x;
	int y;
	public P(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

