import sys
input = sys.stdin.readline

n = int(input())
days = [list(map(int,input().split())) for _ in range(n)]
dp = [0 for _ in range(n+1)]

for i in range(n-1,-1,-1):
    if i+days[i][0] > n:
        dp[i] = dp[i+1]
    else:
        dp[i] = max(dp[i+1], days[i][1]+dp[i+days[i][0]])
print(dp[0])