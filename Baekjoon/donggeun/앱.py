import sys
input = sys.stdin.readline

n,m = map(int,input().split())
uses = list(map(int,input().split()))
cost = list(map(int,input().split()))

size = 0

for i in cost:
    size += i

dp = [0]*(size+1)

for i in range(n):
    for j in range(size, cost[i]-1, -1):
        dp[j] = max(dp[j], dp[j-cost[i]] + uses[i])

for i in range(size+1):
    if dp[i] >= m:
        print(i)
        break