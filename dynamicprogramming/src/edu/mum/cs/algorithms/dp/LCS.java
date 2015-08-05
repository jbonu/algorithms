package edu.mum.cs.algorithms.dp;

public class LCS {

	public static String s1 = "GAATTCAGTTA";
	public static String s2 = "GGATCGA";
	
	public static void main(String args[]){
		
		LCMRecursive lcmRecursive = new LCMRecursive();
		System.out.println(lcmRecursive.lcs(s1, s2, s1.length()-1, s2.length()-1));
		
		LCSMemoize lcsMemoize = new LCSMemoize();
		lcsMemoize.lcs(s1, s2);
		
		System.out.println("BruteForce Counter"+LCMRecursive.bruteForceCounter);
		System.out.println("Memoize Counter"+LCSMemoize.memoizeCounter);
	}
	
	
}


class LCMRecursive {
	
	public static int bruteForceCounter = 0;
	
	public int lcs(String s1, String s2, int m, int n){
		bruteForceCounter++;
		if (n == 0){
			return 0;
		} else if(m == 0) {
			return 0;
		} else if(s1.charAt(m) == s2.charAt(n)){
			return lcs(s1, s2, m -1, n -1) + 1;
		} else {
			int x = max(lcs(s1, s2, m, n -1), lcs(s1, s2, m -1, n));
			return x;
		}
	}
		
	private int max(int a, int b){
		return a>b?a:b;
	}
}


class LCSMemoize {
	
	public static int memoizeCounter = 0;
	public String s1 = "GAATTCAGTTA";
	public String s2 = "GGATCGA";
	public static int[][] L;
	public int lcs(String s1, String s2){
		int m=0,n=0;
		L = new int[s1.length()+1][s2.length()+1];
		m = s1.length();
		n = s2.length();
		for(int i=0;i<= m ;i++){
			for(int j=0;j<= n ;j++){
				L[i][j]=-1;
			}
		}
		
		return lcs(s1,s2,m,n);
	}
		
	public int lcs(String s1, String s2, int m, int n){
		memoizeCounter++;
		if(L[m][n]<0){
			if(n==0) {
				L[m][0]= 0;
			} else if(m==0) {
				L[0][n]=0;
			} else if(s1.charAt(m-1)==s2.charAt(n-1)){
				L[m][n]=lcs(s1,s2,m-1,n-1)+1;
			} else {
				L[m][n]=max(lcs(s1,s2,m,n-1),lcs(s1,s2,m-1,n));
			}
		}
		return L[m][n];
	}
	
	private int max(int a, int b){
		return a>b?a:b;
	}
		
}




