import java.util.Scanner;

public class SAMSUNG_12100_2_Bread {
	int n;
	int max=0;
	int[][] m;
	int[] dx = {1,-1,0,0};	//남,북,동,서
	int[] dy = {0,0,1,-1};
	public int start() {
		Scanner sc =  new Scanner(System.in);
		n = sc.nextInt();
		m = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				m[i][j] = sc.nextInt();
			}
		}
		move(5, m);
		return max;
	}
	public void move(int cnt, int[][] m) {
		if(cnt==0) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					max = Math.max(max, m[i][j]);
				}
			}return;
		}
		for(int k=0;k<4;k++) {	//0남n-1열 1북0열 2동n-1행 3서0행
			int[][] mc = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					mc[i][j] = m[i][j];
				}
			}
			if(k==0)
				{boolean[][] isPop = new boolean[n][n];
				//같은거 pop시키기
				for(int j=n-1;j>=0;j--) {
					for(int i=n-1;i>=0;i--) {
						if(mc[i][j]==0)continue;
						int cx = i-dx[k];
						int cy = j-dy[k];
						if(cx>=0 && cx<n && cy>=0 && cy<n) {//열이면 i, 행이면 j
							for(int q=i-dx[k];q>=0&&q<n;q=q-dx[k]) {
								if(m[i][j]!=m[q][j] && m[q][j]!=0)break;
								if(!isPop[i][j] && !isPop[q][j] && mc[i][j]==mc[q][j]) {
									mc[i][j]+=mc[q][j];
									mc[q][j] =0;
									isPop[i][j]=true;
									isPop[q][j]=true;
									break;
								}
							}
						}
					}
				}
				//빈공간 없애기 남
				for(int j=n-1;j>=0;j--) {
					for(int i=n-1;i>=1;i--) {
						if(mc[i][j]==0) {
							for(int t=i-1;t>=0;t--) {
								if(mc[t][j]!=0) {
									int temp = mc[t][j];
									mc[t][j] = mc[i][j];
									mc[i][j] = temp;
									break;
								}
							}
						}
					}
				}
				move(cnt-1, mc);}
			if(k==1)
				{boolean[][] isPop = new boolean[n][n];
				//같은거 pop시키기
				for(int j=0;j<n;j++) {
					for(int i=0;i<n;i++) {
						if(mc[i][j]==0)continue;
						int cx = i-dx[k];
						int cy = j-dy[k];
						if(cx>=0 && cx<n && cy>=0 && cy<n) {//열이면 i, 행이면 j
							for(int q=i-dx[k];q>=0&&q<n;q=q-dx[k]) {
								if(m[i][j]!=m[q][j] && m[q][j]!=0)break;
								if(!isPop[i][j] && !isPop[q][j] && mc[i][j]==mc[q][j]) {
									mc[i][j]+=mc[q][j];
									mc[q][j] =0;
									isPop[i][j]=true;
									isPop[q][j]=true;
									break;
								}
							}
						}
					}
				}//북
				for(int j=0;j<n;j++) {
					for(int i=0;i<n-1;i++) {
						if(mc[i][j]==0) {
							for(int t=i+1;t<n;t++) {
								if(mc[t][j]!=0) {
									int temp = mc[t][j];
									mc[t][j] = mc[i][j];
									mc[i][j] = temp;
									break;
								}
							}
						}
					}
				}
				move(cnt-1, mc);}
			if(k==2)
				{boolean[][] isPop = new boolean[n][n];
				//같은거 pop시키기
				for(int i=n-1;i>=0;i--) {
					for(int j=n-1;j>=0;j--) {
						if(mc[i][j]==0)continue;
						int cx = i-dx[k];
						int cy = j-dy[k];
						if(cx>=0 && cx<n && cy>=0 && cy<n) {//열이면 , 행이면 j
							for(int q=j-dy[k];q>=0&&q<n;q=q-dy[k]) {
								if(m[i][j]!=m[i][q] && m[i][q]!=0)break;
								if(!isPop[i][j] && !isPop[i][q] && mc[i][j]==mc[i][q]) {
									mc[i][j]+=mc[i][q];
									mc[i][q] =0;
									isPop[i][j]=true;
									isPop[i][q]=true;
									break;
								}
							}
						}
					}
				}//동
				for(int i=n-1;i>=0;i--) {
					for(int j=n-1;j>=1;j--) {
						if(mc[i][j]==0) {
							for(int t=j-1;t>=0;t--) {
								if(mc[i][t]!=0) {
									int temp = mc[i][t];
									mc[i][t] = mc[i][j];
									mc[i][j] = temp;
									break;
								}
							}
						}
					}
				}
				move(cnt-1, mc);}
			if(k==3)
				{boolean[][] isPop = new boolean[n][n];
				//같은거 pop시키기
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(mc[i][j]==0)continue;
						int cx = i-dx[k];
						int cy = j-dy[k];
						if(cx>=0 && cx<n && cy>=0 && cy<n) {//열이면 i, 행이면 j
							if(isPop[i][j] || isPop[cx][cy])continue;
							for(int q=j-dy[k];q>=0&&q<n;q=q-dy[k]) {
								if(m[i][j]!=m[i][q] && m[i][q]!=0)break;
								if(!isPop[i][j] && !isPop[i][q] && mc[i][j]==mc[i][q]) {
									mc[i][j]+=mc[i][q];
									mc[i][q] =0;
									isPop[i][j]=true;
									isPop[i][q]=true;
									break;
								}
							}
						}
					}
				}
				for(int i=0;i<n;i++) {
					for(int j=0;j<n-1;j++) {
						if(mc[i][j]==0) {
							for(int t=j+1;t<n;t++) {
								if(mc[i][t]!=0) {
									int temp = mc[i][t];
									mc[i][t] = mc[i][j];
									mc[i][j] = temp;
									break;
								}
							}
						}
					}
				}
				move(cnt-1, mc);}
			}
		}
	public static void main(String[] args) {
		SAMSUNG_12100_2_Bread s = new SAMSUNG_12100_2_Bread();
		System.out.println(s.start());
	}

}
