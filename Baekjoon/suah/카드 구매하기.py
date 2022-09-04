import sys
input = lambda : sys.stdin.readline().strip()

n = int(input())
p = [0] + list(map(int, input().split()))
dp = [0 for _ in range(n+1)]

for i in range(1, n+1):
    for k in range(1, i+1):
        # dp를 max값으로 계속 갱신
        dp[i] = max(p[k] + dp[i-k], dp[i])

print(dp[n])
