class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] memo = new long[n + 1];
        memo[1] = 1;
        if (n >= 2) memo[2] = 2;
        for (int i = 3; i <= n; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % 1234567;
        }
        answer = memo[n];
        return answer;
    }
}
