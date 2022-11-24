import sys

input = sys.stdin.readline

n = int(input())
dp = [1] * 10
for i in range(1, n):
    for j in range(1, 10):
        dp[j] += dp[j - 1]

print(sum(dp) % 10007)
