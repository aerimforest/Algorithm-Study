import sys

n = int(input())
cards = list(map(int, sys.stdin.readline().split()))

dp = [0] * (n + 1)

for i in range(1, n + 1):
    for j in range(1, i + 1):
        dp[i] = max(cards[j - 1] + dp[i - j], dp[i])

print(dp[-1])
