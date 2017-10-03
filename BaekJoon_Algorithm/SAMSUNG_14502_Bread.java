import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/*
4 6
0 0 0 0 0 0
1 0 0 0 0 2
1 1 1 0 0 2
0 0 0 0 0 2

답 : 9*/
public class SAMSUNG_14502_Bread {
	
	static int[][] map;
	static int mx;
	static int my;
	static ArrayList<Point> zeroA = new ArrayList<Point>();
	static ArrayList<Point> virus = new ArrayList<Point>();
	static ArrayList<Point[]> threeWalls;
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		mx = sc.nextInt();
		my = sc.nextInt();
		sc.nextLine();
		map = new int[mx][my];
		for(int i=0;i<mx;i++) {
			for(int j=0;j<my;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int walln = getAreaList();
		threeWalls = new ArrayList<Point[]>();
		getThreeWallsComb(3, 0, new int[3]);
		
		int max=0;
		for(int i=0;i<threeWalls.size();i++) {
			Point[] w = threeWalls.get(i);
			int temp = makeWallsAndDFS(i, w);
			if(max<temp)max = temp;
		}
		System.out.println(max);
	}
	//n=3
	public static int makeWallsAndDFS(int n, Point[] w) {
		int safeA=0;
		int[][] mapIF = new int[mx][my];
		for(int i=0;i<mx;i++) {
			for(int j=0;j<my;j++) {
				mapIF[i][j]  = map[i][j];
			}
		}		
		for(int j=0;j<3;j++) {	//벽만들어서
			mapIF[w[j].x][w[j].y] = 1;	//벽만들기.
		}//벽 3개 추가함.
		for(int k=0;k<virus.size();k++) {	//순회시키고
			mapIF = virusDFS(virus.get(k).x, virus.get(k).y, mapIF, new boolean[mx][my]);
		}
		for(int i=0;i<mx;i++) {	//0영역 세서
			for(int j=0;j<my;j++) {
				if(mapIF[i][j]==0)safeA++;
			}
		}
		return safeA;	//리턴!
	}
	public static void getThreeWallsComb(int n, int from, int[] selected) {	//성공
		Point[] temp = new Point[3];
		if(n==0) {
			for(int i=0;i<selected.length;i++) {
				temp[i] = zeroA.get(selected[i]);	
			}
			threeWalls.add(temp);
			return;
		}
		for(int i=from;i<zeroA.size();i++) {
			selected[selected.length-n] = i;
			getThreeWallsComb(n-1, i+1, selected);
		}
	}
	
	public static int getAreaList() {	//성공
		int wallNum=0;
		for(int i=0;i<mx;i++) {
			for(int j=0;j<my;j++) {
				if(map[i][j]==0) {
					wallNum++;
					zeroA.add(new Point(i,j));
				}else if(map[i][j]==2) {
					virus.add(new Point(i,j));
				}
			}
		}
		return wallNum;
	}
	
	public static int[][] virusDFS(int x, int y, int[][] mapIF, boolean[][] isVisited) {	//여기가 문제.
		isVisited[x][y] = true;
		mapIF[x][y] =2;
		if(x+1<mx && !isVisited[x+1][y] && (mapIF[x+1][y]!=1))virusDFS(x+1, y, mapIF, isVisited);
		if(y+1<my && !isVisited[x][y+1] && (mapIF[x][y+1]!=1))virusDFS(x, y+1, mapIF, isVisited);
		if(x-1>-1 && !isVisited[x-1][y] && (mapIF[x-1][y]!=1))virusDFS(x-1, y, mapIF, isVisited);
		if(y-1>-1 && !isVisited[x][y-1] && (mapIF[x][y-1]!=1))virusDFS(x, y-1, mapIF, isVisited);
		return mapIF;
	}
}
class Point{
	int x;
	int y;
	boolean isVisited;
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}