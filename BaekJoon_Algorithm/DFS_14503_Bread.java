import java.util.Scanner;
import java.util.Stack;

public class DFS_14503_Bread {	//�κ�û�ұ� ����
	static int[][] map;
	static boolean[][] isCleaned;
/*	���࿹�� :�� 57
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
		int mx = sc.nextInt();	//����ũ�� - �� ��
		int my = sc.nextInt();	//����ũ�� - �� ��
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
					if (!isCleaned[t.x][t.y] && map[t.x][t.y] != 1) {	//������ �� ���� û�ҾȵȰ�����? �ȸ����ִ���?
						ind.push(turnLeftandGo(ind.peek()));	//���� ȸ���� ��ĭ �ű�� push
						flag = true;	//�̵������� flag true
						isCleaned[t.x][t.y]=true;	//û���� ĭ ǥ��
						break;
					} else {	//û�ҵ��ִ°��̾��ų� �����־�����
						ind.push(turnLeft(ind.pop()));	//�ִ��� ���� �������� ������ �ٽ� �������.
					}
			}
			if (!flag && canGoBack(ind.peek())) {	//�������� ȸ�� 4�� �ص� ������ & �ڿ� �� ���� & �ڿ� û���Ѱ��� ����?
				ind.push(goBackOnce(ind.peek()));	//�ڷ� ����
				isCleaned[ind.peek().x][ind.peek().y]=true;	//�ڷ� �� �� ���� û��.
				flag = true;	//�̵������ϱ� true
			} else if (!flag && !canGoBack(ind.peek())) {	//�� �������� & �ڿ� �� �ְų� û���Ѱ� �ִ�?
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
	//���� ��,���� �ٲ㺼��.
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
