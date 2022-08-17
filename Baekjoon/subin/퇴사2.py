import sys

N = int((sys.stdin.readline()).strip())
dp = [0] * (N + 2)
for i in range(1, N + 1) :
    t, p = map(int, (sys.stdin.readline()).split())
    dp[i] = max(dp[i], dp[i - 1])
    if N + 1 >= i + t:
        dp[i + t] = max(dp[i + t], dp[i] + p)

print(max(dp))