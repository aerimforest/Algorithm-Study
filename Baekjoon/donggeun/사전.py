import sys
input = sys.stdin.readline


def solve(n,m,k):
    if dp[n][m] < k:
        return -1
    
    res = ""
    while True:
        if not n:
            res += 'z'*m
            return res
        if not m:
            res += "a"*n
            return res

        tmp = dp[n-1][m]

        if k <= tmp:
            res += "a"
            n -= 1
        else:
            res += "z"
            m -= 1
            k -= tmp

n,m,k = map(int,input().split())
dp = [[1]*(m+1) for _ in range(n+1)]

for i in range(1, n+1):
    for j in range(1, m+1):
        dp[i][j] = dp[i-1][j] + dp[i][j-1]

print(solve(n,m,k))