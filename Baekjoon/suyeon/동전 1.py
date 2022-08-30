import sys

n, k = map(int, sys.stdin.readline().split())
coins = [int(sys.stdin.readline().strip()) for _ in range(n)]

dp = [1] + [0] * k

for coin in coins:
    for i in range(1, k + 1):
        if i - coin >= 0:
            dp[i] += dp[i - coin]

print(dp[k])
