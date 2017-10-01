import java.util.Scanner;

public class VIRUS_2606_Bread {

	static int cNum;
	static int cPairNum;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		cNum = sc.nextInt();
		cPairNum = sc.nextInt();
		int[][] pair = new int[cNum+1][cNum+1];
		for(int i=1;i<=cPairNum;i++) {	//init
				int p1 = sc.nextInt();
				int p2 = sc.nextInt();
				pair[p1][p2] = 1;
				pair[p2][p1] = 1;
		}
		boolean[] isVisited = new boolean[cNum+1];
		howManyVirus(1, pair, isVisited);
		int result =0;
		for(int i=1;i<cNum+1;i++) {
			if(i!=1 && isVisited[i])result++;
		}
		System.out.println(result);
	}

	public static void howManyVirus(int com, int[][] pair, boolean[] isVisited) {
		isVisited[com] = true;
		for(int i=1;i<=cNum;i++) {
			if(pair[com][i]==1 && !isVisited[i]) {
				howManyVirus(i, pair, isVisited);
			}
		}
	}
}
