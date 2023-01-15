import sys
input = sys.stdin.readline

n = int(input())
cost = [list(map(int,input().split())) for _ in range(n)]
INF = int(1e9)
ans = INF
for i in range(3):
    dp = [[INF,INF,INF] for _ in range(n)]
    dp[0][i] = cost[0][i]
    for j in range(1,n):
        r,g,b = dp[j-1][0],dp[j-1][1],dp[j-1][2]
        dp[j][0] = min(g,b)+cost[j][0]
        dp[j][1] = min(r,b)+cost[j][1]
        dp[j][2] = min(r,g)+cost[j][2]
    for k in range(3):
        if i != k:
            ans = min(ans,dp[n-1][k])
print(ans)