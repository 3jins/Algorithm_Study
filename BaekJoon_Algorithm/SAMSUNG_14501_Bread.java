package Retirement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SAMSUNG_14501_Bread {

	static int dayNum;
	static ArrayList<Integer> tablePrice = new ArrayList<Integer>();
	static int[] counselTable;
	static int[] counselPrice;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dayNum = sc.nextInt();
		counselTable = new int[dayNum];
		counselPrice = new int[dayNum];
		for(int i=0;i<dayNum;i++) {	//Initializing
			counselTable[i] = sc.nextInt();
			counselPrice[i] = sc.nextInt();
		}
		makeTimeTable(dayNum, 0, initArr(new int[dayNum], -1), new boolean[dayNum]);
		Collections.sort(tablePrice);
		Collections.reverse(tablePrice);
		System.out.print(tablePrice.get(0));
	}
	public static void makeTimeTable(int n, int from, int[] selected, boolean[] isScheduled) {	//num은 추가 가능한 날짜 후보
		n--;
		for(int i=from;i<dayNum;i++) {
			int prevN=n;
			if(!isScheduled[i] && (i+counselTable[i]<=dayNum)) {
				for(int j=i;j<i+counselTable[i];j++) {
					isScheduled[j] = true;
					if(j!=i)n--;
				}
				selected[selectedSize(selected)] = i;
				makeTimeTable(n, i+counselTable[i], selected, isScheduled);
				selected[selectedSize(selected)-1] = -1;
				for(int x=i;x<i+counselTable[i];x++) {
					isScheduled[x] = false;
				}
				n = prevN-1;
			}
		}
		if(n<=0) {
			int totalP=0;
			for(int x=0;x<selected.length;x++) 
				if(selected[x]!=-1) 
					totalP+=counselPrice[selected[x]];
			tablePrice.add(totalP);
			return;
		}
	}
	public static int[] initArr(int[] n, int init) {
		for(int i=0;i<n.length;i++) n[i] = init;
		return n;
	}
	public static int selectedSize(int[] selected) {
		int result=0;
		for(int i=0;i<selected.length;i++) {
			if(selected[i]!=-1)result++;
		}
		return result;
	}
}
