package edu.mum.cs.algorithms.dp;

public class Fibonacci {
	
	

	public static void main(String args[]){
		
		FibRecursive fibRecursive = new FibRecursive();
		System.out.println(fibRecursive.Fib(50));
		
		FibMemoized fibMemoized = new FibMemoized();
		System.out.println(fibMemoized.fib(50));
		
		System.out.println("Recursive Calls count-->"+ FibRecursive.recursiveCall);
		System.out.println("Memoized  Calls count-->"+ FibMemoized.memoizedCall);
	}
}


/**
 * Algorithm Fib( n ):
	Input: integer n ≥ 0
	Output: the n-th Fibonacci number
	if n=0 then
	return 0
	else if n=1 then
	return 1
	else
	return Fib(n - 2) + Fib( n - 1)
 * @author 984417
 *
 */
class FibRecursive {
	public static int recursiveCall=0;
	public int Fib(int n){
		recursiveCall++;
//		System.out.print(n+",");
		if(n==0){
			return 0;
		}else if(n == 1){
			return 1;
		}else{
			int x = Fib(n-2);
			int y = Fib(n-1);
			if(y==2){
//				System.out.println("Now it starts");
			}
			return x + y;
		}
	}
	
}


/**
 * Algorithm memoizedFib(n):
	Input: integer n ≥ 0
	Output: the n-th Fibonacci number
	F ← new array of size n+1
	for i ← 0 to n do
	F[i] ← -1
	return RecursiveFib(n)
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
//			System.out.print(F[i]+",");
		}
		return fibRecursive(n);
	}
	
	/**
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

