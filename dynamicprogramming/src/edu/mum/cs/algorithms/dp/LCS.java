package edu.mum.cs.algorithms.dp;

public class LCS {

	public static String s1 = "cababc";
	public static String s2 = "abdcb";
	
	public static void main(String args[]){
		
		LCMRecursive lcmRecursive = new LCMRecursive();
		System.out.println(lcmRecursive.lcs(s1, s2, s1.length()-1, s2.length()-1));
		
//		LCMIterativeMemoize lcmIterativeMemoize = new LCMIterativeMemoize();
//		lcmIterativeMemoize.lcs(s1, s2);
	}
	
	
}


class LCMRecursive {
	
	public int lcs(String s1, String s2, int m, int n){
		if (n == 0){
			return 0;
		} else if(m == 0) {
			return 0;
		} else if(s1.charAt(m) == s2.charAt(n)){
			return lcs(s1, s2, m -1, n -1) + 1;
		} else {
				return max(lcs(s1, s2, m, n -1), lcs(s1, s2, m -1, n));
		}
	}
		
	private int max(int a, int b){
		return a>b?a:b;
	}
}

/**
 * Algorithm LCS(S1, S2, m, n):
 *	Input: Strings S1 and S2 with at least m and n elements, respectively
 *	Output: Length of the LCS of S1[1..m] and S2[1..n]
 *	if n = 0 then return 0
 *	else if m = 0 then return 0
 *	else if S1[ m ] = S2[ n ] then return LCS(S1, S2, m -1, n -1) + 1
 *	else return max { LCS(S1, S2, m, n -1), LCS(S1, S2, m -1, n) }
 * 
 * @author 984417
 *
 */
class LCMIterativeMemoize {
	
	public String s1 = "cababc";
	public String s2 = "abdcb";
	
	public void lcs(String s1, String s2){
		
		int s1length = s1.length();
		int s2length = s2.length();
		
		int[][] L = new int[s1length][s2length];
		for(int i=0;i< s1length ;i++){
			L[i][0]=0;
		}
		
		for(int j=0;j< s2length ;j++){
			L[0][j]=0;
		}
		
		for(int i=0;i< s1length ;i++){
			for(int j=0;j< s2length ;j++){
				if(s1.charAt(i)==s2.charAt(j)){
					L[i][j] = L[i-1][j-1] + 1;
				} else {
					L[i][j] = max(L[i-1][j], L[i][j-1]);
				}
			}
		}
		
		for(int i=0;i< s1length ;i++){
			for(int j=0;j< s2length ;j++){
				 System.out.print(L[i][j]+"\t");
			}
			System.out.println("");
		}
		
	}
	
	private int max(int a, int b){
		return a>b?a:b;
	}
	
}
