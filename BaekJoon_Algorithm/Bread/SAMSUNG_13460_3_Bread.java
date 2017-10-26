import java.util.Scanner;

public class SAMSUNG_13460_3_Bread {
	int n, m;
	int min=10000;
	int gx, gy;
	char[][] map;
	int[] dx= {1,0,-1,0};
	int[] dy = {0,1,0,-1};
	
	public int start() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[n][m];
		int rx=0,ry=0,bx=0,by=0;
		sc.nextLine();
		for(int i=0;i<n;i++) {
			String s = sc.nextLine();
			for(int j=0;j<m;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='R') {rx=i;ry=j;}
				else if(map[i][j]=='B') {bx=i;by=j;}
				else if(map[i][j]=='O') {gx=i;gy=j;}
			}
		}
		move(10 ,map, new Ball(rx, ry, bx, by), 0);
		if(min==10000)min=-1;
		return min;
	}
	public void move(int cnt, char[][] map, Ball v, int prevDir) {
		if(cnt==0) {
			return;
		}
		for(int k=0;k<4;k++) {
			//파란거 굴리기.
			if(k==(4-prevDir))continue;
			boolean redGoal = false;
			boolean blueGoal = false;
			char[][] cmap = new char[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					cmap[i][j] = map[i][j];
				}
			}
			//파란처리
			int bxt=v.bx+dx[k];
			int byt=v.by+dy[k];
			
			while(true) {
				if(map[bxt][byt]=='#') {	//벽나오면 벽 전
					bxt=bxt-dx[k];
					byt=byt-dy[k];
					break;
				}else if(cmap[bxt][byt]=='O') {
					blueGoal = true;
					break;
				}
				bxt+=dx[k];
				byt+=dy[k];
			}
			cmap[v.bx][v.by] = '.';
			
			if(cmap[bxt][byt]=='O')cmap[bxt][byt] = 'O';
			else cmap[bxt][byt] = 'B';
			
			//빨간처리
			int rxt=v.rx+dx[k];
			int ryt=v.ry+dy[k];
			while(true) {
				if(map[rxt][ryt]=='#') {	//벽나오면 벽 전
					rxt=rxt-dx[k];
					ryt=ryt-dy[k];
					break;
				}else if(cmap[rxt][ryt]=='O') {
					redGoal = true;
					break;
				}
				rxt+=dx[k];
				ryt+=dy[k];
			}
			cmap[v.rx][v.ry] = '.';
			if(cmap[rxt][ryt]=='O')cmap[rxt][ryt] = 'O';
			else cmap[rxt][ryt] = 'R';

			if(rxt==bxt &&ryt==byt) {	//겹쳐있을때 떼어놓기.
				if(v.bx*dx[k]>=v.rx*dx[k] && v.by*dy[k]>=v.ry*dy[k]) {	//B먼저
					rxt-=dx[k];
					ryt-=dy[k];
					cmap[rxt][ryt] = 'R';
					cmap[bxt][byt] = 'B';
					
				}else{	//A먼저
					bxt-=dx[k];
					byt-=dy[k];
					cmap[bxt][byt] = 'B';
					cmap[rxt][ryt] = 'R';
				}
			}
			if(rxt==gx&&ryt==gy)cmap[rxt][ryt] = 'O';
			if(bxt==gx&&byt==gy)cmap[bxt][byt] = 'O';
			if(redGoal&&blueGoal) {
				min = Math.min(min, 10000);
			}else if(redGoal) {
				min = Math.min(min, 10-(cnt-1));
			}else if(blueGoal) {
				continue;
			}
			move(cnt-1,cmap,new Ball(rxt,ryt,bxt,byt), k);
		}
	}
	public static void main(String[] args) {
		SAMSUNG_13460_3_Bread s = new SAMSUNG_13460_3_Bread();
		System.out.println(s.start());
	}
	class Ball{
		int rx, ry, bx, by;
		public Ball(int rx, int ry, int bx, int by) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
		}
	}
}

