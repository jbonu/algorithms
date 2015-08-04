package edu.mum.cs.algorithms.dp;


/******************************************************************************
 *  Compilation:  javac Knapsack.java
 *  Execution:    java Knapsack N W
 *
 *  Generates an instance of the 0/1 knapsack problem with N items
 *  and maximum weight W and solves it in time and space proportional
 *  to N * W using dynamic programming.
 *
 *  For testing, the inputs are generated at random with weights between 0
 *  and W, and profits between 0 and 1000.
 *
 *  %  java Knapsack 6 2000 
 *  item    profit  weight  take
 *  1       874     580     true
 *  2       620     1616    false
 *  3       345     1906    false
 *  4       369     1942    false
 *  5       360     50      true
 *  6       470     294     true
 *
 ******************************************************************************/

public class Knapsack {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);   // number of items
        int W = Integer.parseInt(args[1]);   // maximum weight of knapsack

//        int[] profit = new int[N+1];
//        int[] weight = new int[N+1];
//
//        // generate random instance, items 1..N
//        for (int n = 1; n <= N; n++) {
//            profit[n] = (int) (Math.random() * 1000);
//            weight[n] = (int) (Math.random() * W);
//        }
        //a:(12,4), b:(10,6), c:(8,5), d:(11,7), e:(14,3), f:(7,1), g:(9,6). 									
        N = 7;
        W = 18;
       
        
        int[] profit = new int[N+1];
        int[] weight = new int[N+1];

        profit[0]=0;
        profit[1]=12;
        profit[2]=10;
        profit[3]=8;
        profit[4]=11;
        profit[5]=14;
        profit[6]=7;
        profit[7]=9;

        weight[0]=0;
        weight[1]=4;
        weight[2]=6;
        weight[3]=5;
        weight[4]=7;
        weight[5]=3;
        weight[6]=1;
        weight[7]=6;
        

        // opt[n][w] = max profit of packing items 1..n with weight limit w
        // sol[n][w] = does opt solution to pack items 1..n with weight limit w include item n?
        int[][] opt = new int[N+1][W+1];
        boolean[][] sol = new boolean[N+1][W+1];

        for (int n = 1; n <= N; n++) {
        	System.out.print("n="+n+"\t");
            for (int w = 1; w <= W; w++) {
//            	System.out.print("w="+w+"\t");
                // don't take item n
                int option1 = opt[n-1][w];

                // take item n
                int option2 = Integer.MIN_VALUE;
                if (weight[n] <= w) option2 = profit[n] + opt[n-1][w-weight[n]];

                // select better of two options
                opt[n][w] = Math.max(option1, option2);
                sol[n][w] = (option2 > option1);
                System.out.print(opt[n][w]+"\t");
            }
            System.out.println("");
        }

        // determine which items to take
        boolean[] take = new boolean[N+1];
        for (int n = N, w = W; n > 0; n--) {
            if (sol[n][w]) { take[n] = true;  w = w - weight[n]; }
            else           { take[n] = false;                    }
        }

        // print results
        System.out.println("item" + "\t" + "profit" + "\t" + "weight" + "\t" + "take");
        for (int n = 1; n <= N; n++) {
            System.out.println(n + "\t" + profit[n] + "\t" + weight[n] + "\t" + take[n]);
        }
    }
}

