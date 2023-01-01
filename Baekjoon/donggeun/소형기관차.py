import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int,input().split()))
m = int(input())

pre_fix = [0]
dp = [[0]*(n+1) for _ in range(4)]
for i in nums:
    pre_fix.append(pre_fix[-1] + i)

for i in range(1, 4):
    for j in range(i*m, n+1):
        dp[i][j] = max(dp[i][j-1], dp[i-1][j-m] + pre_fix[j]-pre_fix[j-m])

print(dp[3][n])