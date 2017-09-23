package d;

import java.util.ArrayList;
import java.util.Scanner;

class NHN_2_Bread {
	  public static void main(String[] args) {
		  //-97
			Scanner sc = new Scanner(System.in);
			String temp = sc.nextLine();
			String[] msg = temp.split(" ");	
			char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
			ArrayList<Character> a = new ArrayList<Character>();
			//encrypt secretword 3 helloworld
			if(msg[0].equals("encrypt")){
				for(int i=0;i<msg[1].length();i++) {
					int t = msg[1].charAt(i)+msg[3].charAt(i)-97-97;
					if(t>25)t=t-25-1;
					a.add(alpha[t]);
				}
				for(int j=0;j<Integer.parseInt(msg[2]);j++) {
					for(int i=0;i<a.size();i++) {
						System.out.print(a.get(i));
					}System.out.println();
					char t = a.remove(0);
					a.add(a.size(), t);
				}
			//decrypt secretword 3 cspkfcgzin
			}else if(msg[0].equals("decrypt")){
				for(int j=0;j<msg[3].length();j++) {	//msg[3]->arraylist
					a.add(msg[3].charAt(j));
				}
				for(int j=0;j<Integer.parseInt(msg[2]);j++) {	//rotate string to make ordinary msg
					char t = a.remove(a.size()-1);
					a.add(0, t);
				}
				for(int i=0;i<msg[1].length();i++) {	//decrypt msg
					int t = a.get(i)-msg[1].charAt(i);
					if(t<0)t=t+25+1;
					System.out.println(t);
					a.add(alpha[t]);
					
				}
				for(int i=0;i<msg[1].length();i++) {	//delete undecrypt msg
					a.remove(0);
				}
			}
			for(int i=0;i<a.size();i++) {
				System.out.print(a.get(i));
			}System.out.println();
			System.exit(0);
	  }
	}