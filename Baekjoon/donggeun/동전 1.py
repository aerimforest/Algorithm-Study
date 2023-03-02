import sys
input = sys.stdin.readline

n,k = map(int,input().split())
coins = sorted([int(input()) for _ in range(n)])
dp = [0]*(k+1)

for coin in coins:
    dp[coin] += 1

    
    for nxt in range(coin, k+1):
        dp[nxt] += dp[nxt-coin]
print(dp)