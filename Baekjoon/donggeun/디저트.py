import sys
input = sys.stdin.readline

n,m = map(int,input().split())
cake = [list(map(int,input().split())) for _ in range(m)]
dp = [[0]*m for _ in range(n)]
dp[0] = [cake[i][0] for i in range(m)]

for i in range(1,n):
    for j in range(m):
        tmp = [dp[i-1][k] for k in range(m) if k != j]
        if tmp:
            tmp = max(tmp)
        else:
            tmp = 0
        dp[i][j] = max(tmp + cake[j][i], dp[i-1][j] + cake[j][i]//2)

print(max(dp[n-1]))