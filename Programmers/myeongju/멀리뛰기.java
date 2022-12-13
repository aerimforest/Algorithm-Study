import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n) {
        
        long[] dp = new long[n+1];
        
        dp[1] = 1l;
        if(n>1) dp[2] = 2l;
        
        for(int i=3; i<=n; i++) 
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        
        return dp[n];
    }
}