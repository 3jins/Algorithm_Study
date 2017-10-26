
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MAZE_2187_Bread {

	static int mx;
	static int my;
	static int result;
	static ArrayList<Integer> sum = new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		mx = sc.nextInt();
		my = sc.nextInt();
		int[][] map = new int[mx][my];
		boolean[][] isVisited = new boolean[mx][my];
		sc.nextLine();
		for(int i=0;i<mx;i++) {
			String temp = sc.nextLine();
			for(int j=0;j<my;j++) {
				map[i][j] = (temp.charAt(j)-48);
			}
		}searchMap(0,0,map,1, isVisited);
		Collections.sort(sum);
		System.out.println(sum.get(0));
	}
	public static void searchMap(int cx, int cy, int[][] map, int totalNum, boolean[][] isVisited) {
		isVisited[cx][cy] = true;
		boolean[][] temp = new boolean[mx][my];
		for(int i=0;i<mx;i++) {	//duplicate ordinary isVisited
			for(int j=0;j<my;j++) {
				temp[i][j] = isVisited[i][j];
			}
		}
		if(cx==mx-1&&cy==my-1) {	//When reaching Goal
			sum.add(totalNum);
		}
		if(cx+1<mx && (!isVisited[cx+1][cy]) && map[cx+1][cy]==1)searchMap(cx+1, cy, map, totalNum+1, temp);
		if(cy+1<my && (!isVisited[cx][cy+1]) && map[cx][cy+1]==1)searchMap(cx, cy+1, map, totalNum+1, temp);
		if(cx-1>=0 && (!isVisited[cx-1][cy]) && map[cx-1][cy]==1)searchMap(cx-1, cy, map, totalNum+1, temp);
		if(cy-1>=0 && (!isVisited[cx][cy-1]) && map[cx][cy-1]==1)searchMap(cx, cy-1, map, totalNum+1, temp);
	}
	public static void printMap(int[][] map, int mx, int my) {
		for(int i=0;i<mx;i++) {
			for(int j=0;j<my;j++) {
				System.out.print(map[i][j]+"");
			}System.out.println();
		}
	}
}
