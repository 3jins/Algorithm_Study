import java.util.Scanner;

public class SAMSUNG_12100_Bread {
	static int n;
	static int max;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		n= sc.nextInt();
	
		int[][] m = new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				m[i][j] = sc.nextInt();
		move(m, 5);
		System.out.println(max);
	}
	public static void move(int[][] m, int num) {
		if(num==0) {
			return;
		}
		for(int i=0;i<4;i++) {
			int[][] mc = new int[n][n];
			for(int x=0;x<n;x++) {
				for(int y=0;y<n;y++) {
					mc[x][y] = m[x][y];
				}
			}
			if(i==0) {
				mc= rmEmptyPlace(mc, i);
				for(int y=0;y<n;y++) {
					for(int x=0;x<n;x++) {
						if(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]>=0 && y+dy[i]<n) {	//경계검사
							if(mc[x][y]==mc[x+dx[i]][y+dy[i]]) {
								mc[x+dx[i]][y+dy[i]]+=mc[x][y];
								mc[x][y]=0;
								max = Math.max(max, mc[x+dx[i]][y+dy[i]]);
							}
						}
					}
				}
				mc= rmEmptyPlace(mc, i);
				move(mc, num-1);
			}
			if(i==3) {	//서쪽
				mc= rmEmptyPlace(mc, i);
				for(int x=0;x<n;x++) {
					for(int y=0;y<n;y++) {
						if(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]>=0 && y+dy[i]<n) {	//경계검사
							if(mc[x][y]==mc[x+dx[i]][y+dy[i]]) {
									mc[x+dx[i]][y+dy[i]]+=mc[x][y];
									mc[x][y]=0;
									max = Math.max(max, mc[x+dx[i]][y+dy[i]]);
							}
						}
					}
				}
				mc= rmEmptyPlace(mc, i);
				move(mc, num-1);
			}if(i==2) {	//동쪽
				mc= rmEmptyPlace(mc, i);
				for(int x=n-1;x>=0;x--) {
					for(int y=n-1;y>=0;y--) {
						if(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]>=0 && y+dy[i]<n) {	//경계검사
							if(mc[x][y]==mc[x+dx[i]][y+dy[i]]) {
									mc[x+dx[i]][y+dy[i]]+=mc[x][y];
									mc[x][y] =0;
									max = Math.max(max, mc[x+dx[i]][y+dy[i]]);
							}
						}
					}
				}
				mc= rmEmptyPlace(mc, i);
				move(mc, num-1);
			}
			if(i==1) {
				mc= rmEmptyPlace(mc, i);
				for(int y=n-1;y>=0;y--) {
					for(int x=n-1;x>=0;x--) {
						if(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]>=0 && y+dy[i]<n) {	//경계검사
							if(mc[x][y]==mc[x+dx[i]][y+dy[i]]) {
									mc[x+dx[i]][y+dy[i]]+=mc[x][y];
									mc[x][y] =0;
									max = Math.max(max, mc[x+dx[i]][y+dy[i]]);
								}
							}
						}
				}
				mc= rmEmptyPlace(mc, i);
				move(mc, num-1);
			}
		}
	}
	public static int[][] rmEmptyPlace(int[][] m, int d){
		if(d==0) {	//북
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int temp = i-1;
					int pasttemp = i;
					while (temp >-1 && m[temp][j]==0) {
						m[temp][j] = m[pasttemp][j];
						m[pasttemp][j] = 0;
						pasttemp = temp;
						temp--;
					}
				}
			}
		}else if(d==1) {	//남
			for (int i = n-1; i > 0; i--) {
				for (int j = n-1; j > -1; j--) {
					int temp =  i;
					int pasttemp = i-1;
					while (temp < n && m[temp][j] == 0) {
						m[temp][j] = m[pasttemp][j];
						m[pasttemp][j] = 0;
						pasttemp = temp;
						temp++;
					}
				}
			}
		}else if(d==2) {	//동
			for (int i = n - 1; i >= 0; i--) {
				for (int j = n - 1; j > 0; j--) {
					int temp = j;
					int pasttemp = j-1;
					while (temp < n && m[i][temp] == 0) {
						m[i][temp] = m[i][pasttemp];
						m[i][pasttemp] = 0;
						pasttemp = temp;
						temp++;
					}
				}
			}
		}else if(d==3) {	//서
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int temp = j - 1;
					int pasttemp = j;
					while (temp >-1 && m[i][temp] == 0) {
						m[i][temp] = m[i][pasttemp];
						m[i][pasttemp] = 0;
						pasttemp = temp;
						temp--;
					}
				}
			}
		}
		return m;
	}
}
