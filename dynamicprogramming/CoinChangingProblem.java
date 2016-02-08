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
        long[] A = new long[N+1];
        A[0] = 1L;
        for (int i=0; i<M ; ++i) {
            int play = nums.get(i);
            for (int j=play; j<=N; ++j) {
                    A[j] += A[j-play];
            }
        }
        
        return A[N];
    }
}
