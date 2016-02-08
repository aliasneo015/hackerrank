import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        List<Integer> nums = new ArrayList<Integer>();
        while (sc.hasNext()) {
            int i = sc.nextInt();
            nums.add(i);
            //String line = sc.nextLine();            
        }
        Long result = solve(N, M, nums);
        System.out.println(result);
    }
    
    public static Long solve(int N, int M, List<Integer> nums) {
        Long[][] A = new Long[M][N+1];
        

        for (int i=0; i<M ; ++i) {
            for (int j=0; j<=N; ++j) {
                if (j==0) {
                    A[i][j] = 1L;
                    continue;
                }
                int play = nums.get(i);
                Long withoutCoin = (i > 0)
                                ? A[i-1][j]
                                : 0;
                Long withCoin = (j>=play)
                              ? A[i][j-play]
                              : 0;
                A[i][j] = withCoin + withoutCoin;
            }
        }
        
        return A[M-1][N];
    }
}
