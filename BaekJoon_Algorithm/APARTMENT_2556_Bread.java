package Apart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class APARTMENT_2556_Bread {
	static ArrayList<Integer> aptNum = new ArrayList<Integer>();
	static ArrayList<Integer> maxAptNum = new ArrayList<Integer>();
	static Map<Integer, boolean[][]> m = new HashMap<>();
	static boolean[][] areaSelected;
	static int mapSize;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		mapSize = sc.nextInt();
		int[][] map = new int[mapSize][mapSize];
		areaSelected = new boolean[mapSize][mapSize];
		sc.nextLine();
		for(int i=0;i<mapSize;i++) {
			String temp = sc.nextLine();
			for(int j=0;j<mapSize;j++) {
				map[i][j] = temp.charAt(j)-48;
			}
		}
		for(int i=0;i<mapSize;i++) {
			for(int j=0;j<mapSize;j++) {
				if(map[i][j]!=0 && !areaSelected[i][j]) {
					countAptNum(i,j, map, new boolean[mapSize][mapSize]);
					if(aptNum.size()!=0) {
						Collections.sort(aptNum);
						Collections.reverse(aptNum);
						int temp = aptNum.get(0);
						updateSelectedAreaList(m.get(temp));
						aptNum.clear();
						maxAptNum.add(temp);
					}	
				}	
			}
		}
		System.out.println(maxAptNum.size());
		Collections.sort(maxAptNum);
		for(int i=0;i<maxAptNum.size();i++) {
			System.out.println(maxAptNum.get(i));
		}
	}
	public static void countAptNum(int cx, int cy, int map[][], boolean[][] isVisited) {
		isVisited[cx][cy] = true;
		if(cx-1>=0 && !isVisited[cx-1][cy] && map[cx-1][cy]==1)countAptNum(cx-1, cy, map, isVisited);
		if(cy-1>=0 && !isVisited[cx][cy-1] && map[cx][cy-1]==1)countAptNum(cx, cy-1, map, isVisited);
		if(cx+1<mapSize && !isVisited[cx+1][cy] && map[cx+1][cy]==1)countAptNum(cx+1, cy, map, isVisited);
		if(cy+1<mapSize && !isVisited[cx][cy+1] && map[cx][cy+1]==1)countAptNum(cx, cy+1, map, isVisited);
		else{
			int visitNum=0;
			for(int i=0;i<mapSize;i++) {
				for(int j=0;j<mapSize;j++) {
					if(isVisited[i][j])visitNum++;
				}
			}
			m.put(visitNum, isVisited);
			aptNum.add(visitNum);
		}
	}
	public static void updateSelectedAreaList(boolean[][] area) {
		for(int i=0;i<mapSize;i++) {
			for(int j=0;j<mapSize;j++) {
				if(area[i][j]) 
					areaSelected[i][j] = area[i][j];
			}
		}
	}
}
class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
