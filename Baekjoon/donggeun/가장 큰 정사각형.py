import sys
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [list(map(str, input().rstrip())) for _ in range(n)]
dp = [[0]*(m+1) for _ in range(n+1)]
ans = 0
for i in range(1,n+1):
    for j in range(1,m+1):
        if graph[i-1][j-1] == "1":
            dp[i][j] = min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j])+1
        ans = max(ans, dp[i][j])

print(ans**2)