package edu.mum.cs.algorithms.dp;

public class Fibonacci {
	
	

	public static void main(String args[]){
		FibRecursive fibRecursive = new FibRecursive();
		System.out.println(fibRecursive.Fib(10));
		
		FibMemoized fibMemoized = new FibMemoized();
		System.out.println(fibMemoized.fib(10));
		
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
		System.out.print(n+",");
		if(n==0){
			return 0;
		}else if(n == 1){
			return 1;
		}else{
			int x = Fib(n-2);
			int y = Fib(n-1);
			if(y==2){
				System.out.println("Now it starts");
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
		System.out.println(n+"n");
		F = new int[100];
		for (int i : F) {
			F[i] = -1;
		}
		return fibRecursive(F[n]);
	}
	
	/**
	 * Algorithm RecursiveFib(n):
		Input: integer n ≥ 0
		Output: the n-th Fibonacci number
		if F[n] < 0 then // If Fib(n) has not been computed?
		if n=0 then F[n] ← 0
		else if n=1 then F[n] ← 1
		else F[n] ← RecursiveFib(n-2) + RecursiveFib(n-1)
		return F[n]
	 * @param n
	 * @return
	 */
	public int fibRecursive(int n){
		memoizedCall++;
		if(F[n] == 0 ){
			F[n] = 0;
		}else if(F[n] == 1) {
			F[n] = 1;
		}else{
			F[n] = fibRecursive(F[n-2]) + fibRecursive(F[n-1]);
		}
		return n;
	}
}

