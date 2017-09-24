import java.util.Scanner;
import java.util.Stack;

public class DFS_14503_Bread {	//로봇청소기 문제
	static int[][] map;
	static boolean[][] isCleaned;
/*	실행예시 :답 57
11 10
7 4 0
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 1 1 1 1 0 1
1 0 0 1 1 0 0 0 0 1
1 0 1 1 0 0 0 0 0 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 0 0 0 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int mx = sc.nextInt();	//세로크기 - 행 수
		int my = sc.nextInt();	//가로크기 - 열 수
		sc.nextLine();
		String rob = sc.nextLine();
		String rb[] = rob.split(" ");

		map = new int[mx][my];
		isCleaned = new boolean[mx][my];

		for (int i = 0; i < mx; i++) {
			String ms = sc.nextLine();
			String[] mss = ms.split(" ");
			for (int j = 0; j < my; j++) {
				map[i][j] = Integer.parseInt(mss[j]);
			}
		}
		//printMap(mx, my);
		System.out.println(clean(mx,my,Integer.parseInt(rb[0]), Integer.parseInt(rb[1]), Integer.parseInt(rb[2])));
	}

	public static void printMap(int mx, int my) {
		for (int i = 0; i < mx; i++) {
			for (int j = 0; j < my; j++) {
				if (j != 0)
					System.out.print(" " + map[i][j]);
				else
					System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	public static int clean(int mx, int my, int rx, int ry, int dir) {
		Stack<Point> ind = new Stack<Point>();
		int c=0;
		ind.push(new Point(rx, ry, dir));
		isCleaned[rx][ry] = true;
		boolean flag;
		while (!ind.isEmpty()) {
			flag = false;
			//System.out.println("x:" + ind.peek().x + " y:" + ind.peek().y+" dir:"+ind.peek().dir);
			for (int i = 0; i < 4; i++) {
				Point t = turnLeftandGo(ind.peek());
					if (!isCleaned[t.x][t.y] && map[t.x][t.y] != 1) {	//앞으로 갈 곳이 청소안된곳인지? 안막혀있는지?
						ind.push(turnLeftandGo(ind.peek()));	//왼쪽 회전해 한칸 옮긴거 push
						flag = true;	//이동했으면 flag true
						isCleaned[t.x][t.y]=true;	//청소한 칸 표시
						break;
					} else {	//청소되있는곳이었거나 막혀있었으면
						ind.push(turnLeft(ind.pop()));	//있던거 빼서 왼쪽으로 돌리고 다시 집어넣음.
					}
			}
			if (!flag && canGoBack(ind.peek())) {	//왼쪽으로 회전 4번 해도 못갔고 & 뒤에 벽 없고 & 뒤에 청소한곳도 없다?
				ind.push(goBackOnce(ind.peek()));	//뒤로 빽함
				isCleaned[ind.peek().x][ind.peek().y]=true;	//뒤로 간 곳 새로 청소.
				flag = true;	//이동했으니까 true
			} else if (!flag && !canGoBack(ind.peek())) {	//못 움직였고 & 뒤에 벽 있거나 청소한곳 있다?
				int answer = 0;
				for (int i = 0; i < mx; i++) {
					for (int j = 0; j < my; j++) {
						if (isCleaned[i][j]) answer++;
					}
				}
				return answer;
			}
			if (!flag) {
				System.out.println("pop");
				ind.pop();
			}
		}
		int answer = 0;
		for (int i = 0; i < mx; i++) {
			for (int j = 0; j < my; j++) {
				if (isCleaned[i][j]) answer++;
			}
		}
		return answer;
	}
	//내일 행,열로 바꿔볼것.
	public static Point turnLeft(Point cur) {
		if (cur.dir == 0)
			return new Point(cur.x, cur.y, 3);
		else if (cur.dir == 1)
			return new Point(cur.x, cur.y, 0);
		else if (cur.dir == 2)
			return new Point(cur.x, cur.y, 1);
		else if (cur.dir == 3)
			return new Point(cur.x, cur.y, 2);
		else
			return null;
	}
	public static Point turnLeftandGo(Point cur) {
		if (cur.dir == 0)
			return new Point(cur.x, cur.y-1, 3);
		else if (cur.dir == 1)
			return new Point(cur.x-1, cur.y, 0);
		else if (cur.dir == 2)
			return new Point(cur.x, cur.y+1, 1);
		else if (cur.dir == 3)
			return new Point(cur.x+1, cur.y, 2);
		else
			return null;
	}
	public static Point goStraight(Point cur) {
		if (cur.dir == 0)
			return new Point(cur.x-1, cur.y, 0);
		else if (cur.dir == 1)
			return new Point(cur.x, cur.y+1, 1);
		else if (cur.dir == 2)
			return new Point(cur.x+1, cur.y, 2);
		else if (cur.dir == 3)
			return new Point(cur.x, cur.y-1, 3);
		else
			return new Point(-1, -1, -1);
	}
	public static Point goBackOnce(Point cur) {
		if (cur.dir == 0 )
			return new Point(cur.x+1, cur.y, 0);
		else if (cur.dir == 1)
			return new Point(cur.x, cur.y-1, 1);
		else if (cur.dir == 2)
			return new Point(cur.x-1, cur.y, 2);
		else if (cur.dir == 3)
			return new Point(cur.x, cur.y+1, 3);
		else
			return null;
	}
	public static boolean canGoBack(Point cur) {
		if (cur.dir == 0)
			return map[cur.x+1][cur.y] != 1;
		else if (cur.dir == 1)
			return map[cur.x][cur.y-1] != 1;
		else if (cur.dir == 2)
			return map[cur.x-1][cur.y] != 1;
		else if (cur.dir == 3)
			return map[cur.x][cur.y+1] != 1;
		else
			return false;
	}
}
class Point {
	int x;
	int y;
	int dir;
	public Point(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}
