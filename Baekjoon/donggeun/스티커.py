import sys
input = sys.stdin.readline

for i in range(int(input())):
    n = int(input())
    sticker= [list(map(int,input().rstrip().split())) for j in range(2)]
    dp = [[0]*n for i in range(2)]
    
    for k in range(2):
        dp[k][0] = sticker[k][0]
        if n > 1:
            dp[k][1] = sticker[k^1][0] + sticker[k][1]
    
    for j in range(2, n):
        for i in range(2):
            dp[i][j] = max(dp[i^1][j-2], dp[i^1][j-1])+sticker[i][j]
    
    print(max(dp[0][n-1], dp[1][n-1]))