import java.util.ArrayList;
import java.util.List;

public class Edit {
	static int[][] opt;
	static int[][] move; //table of moves, 1=change,2=delete,3=add
	static String a;
	static String b;
	static void editDist(int al, int bl) {

		if(move[al-1][bl-1] == 0) editDist(al-1, bl-1);
		if(move[al-1][bl] == 0) editDist(al-1, bl);
		if(move[al][bl-1] == 0) editDist(al,bl-1);

		int ch = opt[al-1][bl-1];
		if (a.charAt(al-1)!=b.charAt(bl-1)) {
			ch += 0.5;
		}
		int de = opt[al-1][bl] + 1;
		int ad = opt[al][bl-1] + 1;
		if(ch<de && ch<ad){
			opt[al][bl] = ch;
			move[al][bl] = 1;
		}else if(de<ad && de<ch){
			opt[al][bl] = de;
			move[al][bl] = 2;
		}else{
			opt[al][bl] = ad;
			move[al][bl] = 3;
		}
	}
	
	public static void run(String str1, String str2) {
		int aL = str1.length();
		int bL = str2.length();
		opt = new int[aL+1][bL+1];
		move = new int[aL+1][bL+1];
		a = str1;
		b = str2;
		for (int i = 0; i<=aL;i++) {
			opt[i][0] = i*1;
			move[i][0] = 2;
		}
		for (int j = 0; j<=bL;j++) {
			opt[0][j] = j*1;
			move[0][j] = 3;
		}
		editDist(aL,bL);
	}
	
	public static List<String> bestSequence(String str1, String str2) {
		run(str1, str2);
		
		String temp = a;
		int i = a.length();
		int j = b.length();
		ArrayList<String> best = new ArrayList<String>();
		best.add(temp);
		System.out.println(temp);
		while(i != 0 || j != 0) {
			
			System.out.println(
					"i = " + i 
				+	" j = " + j
				+ 	" m = " + move[i][j]);
				
			if(move[i][j]==1) {
				if(i==1) {
					temp = b.charAt(j-1)
							+ temp.substring(i,temp.length());
				} else if (i==temp.length()) {
					temp = temp.substring(0,i-1) 
							+ b.charAt(j-1);
				} else {
					temp = temp.substring(0,i-1) 
						+ b.charAt(j-1)
						+ temp.substring(i,temp.length());
				}
				i--;
				j--;
				if(b.charAt(j)==a.charAt(i)) continue;
			} else if (move[i][j]==2) {
				if(i==1) {
					temp = temp.substring(1);
				} else if (i==temp.length()) {
					temp = temp.substring(0,i-1);
				} else {
					temp = temp.substring(0,i-1)
						+ temp.substring(i,temp.length());
				}
				i--;
			} else if (move[i][j]==3) {
				if(i==1) {
					temp = b.charAt(j-1)
							+ temp;
				} else if (i==temp.length()) {
					temp = temp
							+ b.charAt(j-1);
				} else {
					temp = temp.substring(0,i) 
						+ b.charAt(j-1)
						+ temp.substring(i,temp.length());
				}
				j--;
			}
			best.add(temp);
			System.out.println(temp);
		}
		
		return best;
	}
	
	public static void print(List<String> list) {
		for(String s: list) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		String str1 = args[0];
		String str2 = args[1];
		List<String> moveSeq = bestSequence(str1, str2);
		print(moveSeq);
	}
}
