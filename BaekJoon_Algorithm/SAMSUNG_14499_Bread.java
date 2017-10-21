import java.util.Scanner;

public class SAMSUNG_14499_Bread {

	int n;
	int m;
	int num;
	int[][] map;
	int[] cmd;
	public void start() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		int x = sc.nextInt();
		int y = sc.nextInt();
		num = sc.nextInt();
		cmd = new int[num];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<num;i++) {
			cmd[i] = sc.nextInt();
		}
		int[][] dice = new int[4][3];
		for(int i=0;i<num;i++) {
			if(cmd[i]==1 && y+1<m) {	//µ¿
				y++;
				dice = movedice(dice,cmd[i]);
			}else if(cmd[i]==2 && y-1>=0){	//¼­
				y--;
				dice = movedice(dice,cmd[i]);
			}else if(cmd[i]==3 && x-1>=0){	//ºÏ
				x--;
				dice = movedice(dice,cmd[i]);
			}else if(cmd[i]==4 && x+1<n){	//³²
				x++;
				dice = movedice(dice,cmd[i]);
			}else {
				continue;
			}
			if(map[x][y]==0) {
				map[x][y] = dice[3][1];
			}else {
				dice[3][1] = map[x][y];
				map[x][y] = 0;
			}
			System.out.println(dice[1][1]);
			
			//´ÙÀ½±¼¸®±â.
		}
	}
	public int[][] movedice(int[][] oldD, int dir){
		int[][] newD = new int[4][3];
		if(dir==1) {	//µ¿				 new old
			newD[0][1] = oldD[0][1];	//2  2 
			newD[1][0] = oldD[3][1];	//6  4
			newD[1][1] = oldD[1][0];	//4  1
			newD[1][2] = oldD[1][1];	//1  3
			newD[2][1] = oldD[2][1];	//5  5
			newD[3][1] = oldD[1][2];	//3  6
		}else if(dir==2) {	//¼­
			newD[0][1] = oldD[0][1];	
			newD[1][0] = oldD[1][1];	
			newD[1][1] = oldD[1][2];
			newD[1][2] = oldD[3][1];
			newD[2][1] = oldD[2][1];
			newD[3][1] = oldD[1][0];
		}else if(dir==3) {	//ºÏ
			newD[0][1] = oldD[1][1];	
			newD[1][0] = oldD[1][0];	
			newD[1][1] = oldD[2][1];
			newD[1][2] = oldD[1][2];
			newD[2][1] = oldD[3][1];
			newD[3][1] = oldD[0][1];
		}else if(dir==4) {	//³²
			newD[0][1] = oldD[3][1];	
			newD[1][0] = oldD[1][0];	
			newD[1][1] = oldD[0][1];
			newD[1][2] = oldD[1][2];
			newD[2][1] = oldD[1][1];
			newD[3][1] = oldD[2][1];
		}else {
			return null;
		}
		return newD;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SAMSUNG_14499_Bread s = new SAMSUNG_14499_Bread();
		s.start();
	}

}
