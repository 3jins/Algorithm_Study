import java.util.Scanner;

public class SAMSUNG_14503_2_Bread {

	int dx[] = {0,1,0,-1};
	int dy[] = {-1,0,1,0};
	int backx[] = {1,0,-1,0};
	int backy[] = {0,1,0,-1};
	int m,n;
	int map[][];
	public int start() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int rx = sc.nextInt();
		int ry = sc.nextInt();
		int dir = sc.nextInt();
		if(dir==1) 
			dir = 3;
		else if(dir==3) 
			dir = 1;
		map = new int[n][m];
		for(int i=0;i<n;i++) 
			for(int j=0;j<m;j++) 
				map[i][j]  =sc.nextInt();
		boolean[][] clean = new boolean[n][m];
		robotClean(rx, ry, dir, clean);
		int result=0;
		for(int i=0;i<n;i++) 
			for(int j=0;j<m;j++) 
				if(clean[i][j]) 
					result++;
		
		return result;
	}
	public void robotClean(int rx, int ry, int dir, boolean[][] isC) {
		isC[rx][ry] = true;	//���� ��ġ û��.
		boolean flag = false;
		for(int i=0;i<4;i++) {
			int nx = rx+dx[dir];
			int ny = ry+dy[dir];
			if(nx>=1 && nx<n-1 && ny>=1 && ny<m-1) {
				if(map[nx][ny]==0 && !isC[nx][ny]) {	//���� û�Ҿ������� �� �ƴϸ�.
					dir = (dir+1)%4;
					robotClean(nx, ny, dir, isC);
					flag = true;
					break;
				}else 	//���� û�ҵǾ��־�����
					dir = (dir+1)%4;
			}else 	//���� ���̸�
				dir = (dir+1)%4;
		}	//�� ���� ��� �˻����� ��.
		if(!flag) {
			int bx = rx+backx[dir];	//���� ��ǥ
			int by = ry+backy[dir];
			if(bx>=1 && bx<n-1 && by>=1 && by<m-1) {	
				if(map[bx][by]==0)
					robotClean(bx, by, dir, isC);
			}else 
				return;
		}
	}
	
	public static void main(String[] args) {
		SAMSUNG_14503_2_Bread s = new SAMSUNG_14503_2_Bread();
		System.out.println(s.start());
	}
}
