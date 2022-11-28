import sys
input = sys.stdin.readline
n = int(input())
dp = [0]*(n+1)
for i in range(n+1) :
    dp[i] = [0,0,0]
dp[1][0] = 1
dp[1][1] = 1
dp[1][2] = 1


for i in range(2, n + 1):
    dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901
    dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901
    dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901

print(sum(dp[n]) % 9901)
