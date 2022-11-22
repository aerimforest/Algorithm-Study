import sys 

input = sys.stdin.readline 
n,k = map(int,input().split())

dp = [[0]*(n+1) for i in range(k+1)]

for i in range(1,n+1) :
    dp[1][i] = 1 

for i in range(1,k+1) : 
    dp[i][1] = i 

for r in range(2,k+1) :
    for c in range(2,n+1) :
        dp[r][c] = dp[r-1][c] + dp[r][c-1]

print(dp[k][n]%1000000000)
