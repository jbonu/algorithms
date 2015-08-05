package edu.mum.cs.algorithms.dp;

public class Fibonacci {
	
	

	public static void main(String args[]){
		
		FibRecursive fibRecursive = new FibRecursive();
		System.out.println(fibRecursive.fib(30));
		
		FibMemoized fibMemoized = new FibMemoized();
		System.out.println(fibMemoized.fib(30));
		
		System.out.println("Recursive Calls count-->"+ FibRecursive.recursiveCall);
		System.out.println("Memoized  Calls count-->"+ FibMemoized.memoizedCall);
	}
}


/**
 *
 * @author 984417
 *
 */
class FibRecursive {
	public static int recursiveCall=0;
	public int fib(int n){
		recursiveCall++;
		if(n==0){
			return 0;
		}else if(n == 1){
			return 1;
		}else{
			return fib(n-2) +  fib(n-1);
		}
	}
	
}


/**
 * 
 * @author 984417
 *
 */
class FibMemoized {
	public static int memoizedCall=0;
	public static int[] F;
	public int fib(int n){
		F = new int[n+1];
		for (int i=0 ;i<F.length;i++) {
			F[i] = -1;
		}
		for (int i=0 ;i<F.length;i++) {
			System.out.print(F[i]+",");
		}
		return fibRecursive(n);
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public int fibRecursive(int n){
//		System.out.println(n+",");
		memoizedCall++;
//		System.out.print("F[n]->"+F[n]);
		if(F[n] < 0){
			if(n == 0 ){
				F[n] = 0;
			}else if(n == 1) {
				F[n] = 1;
			}else{
				F[n] = fibRecursive(n-2) + fibRecursive(n-1);
			}
		}
		return F[n];
	}
}

