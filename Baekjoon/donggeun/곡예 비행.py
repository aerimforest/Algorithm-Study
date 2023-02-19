import sys
input = sys.stdin.readline

INF = -int(1e4)
# INF = 0
n,m = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
up_dp = [[INF]*(m+1) for _ in range(n+1)]
down_dp = [[INF]*(m+1) for _ in range(n+1)]

# up_dp는 n-1 -> 0, 0 -> m-1
# def pr():
#     for i in up_dp:
#         print(i)
#     print()

# 상승 
up_dp[n-1][0], up_dp[n][1] = 0,0
for i in range(1, m+1):
    for j in range(n-1, -1, -1):
        up_dp[j][i] = max(up_dp[j+1][i], up_dp[j][i-1]) + board[j][i-1]

def pr():
    for d in down_dp:
        print(d)



down_dp[n-1][m], down_dp[n][m-1] = 0,0
for i in range(n-1, -1, -1):
    for j in range(m-1, -1, -1):
        # print(f"i:{i}, j:{j}, max({down_dp[i][j+1]}, {down_dp[i+1][j]}) + {board[i][j]}")
        down_dp[i][j] = max(down_dp[i][j+1], down_dp[i+1][j]) + board[i][j]
        # print(board[i-1][j-1], end=' ')
    #     pr()
    # print()

def pr(dp: list[list[int]]) -> None:

    for i in range(n+1):
        for j in range(m+1):
            print(dp[i][j] if dp[i][j] != INF else "INF", end=' ')
        print()
    
# pr(up_dp)
# print("===")
# pr(down_dp)

def up_val(i:int, j:int) -> int:
    return up_dp[i][j] if j != 0 else INF

def down_val(i:int, j:int) -> int:
    return down_dp[i][j] if j != m else INF


dp = [[0]*m for _ in range(n)]

for i in range(n):
    for j in range(1, m+1):
        dp[i][j-1] = up_dp[i][j]

for i in range(n):
    for j in range(m):
        # print(i,j)
        dp[i][j] += down_dp[i][j]

print(max(map(max, dp)))
