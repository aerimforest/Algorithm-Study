# def solution(r,c,status) :
#     global cnt 
    
#     # print(r,c,status)
#     if r == N-1 and c == N-1 :
#         cnt += 1 
#         return 
    
#     if r+1 < N and c+1 <N :
#         if not grid[r+1][c+1] and not grid[r][c+1] and not grid[r+1][c]  :
#             solution(r+1,c+1,2)
    
#     if status== 0 or status == 2 :
#         if c+1 < N :
#             if not grid[r][c+1] :
#                 solution(r,c+1,0)
#     if status == 1 or status == 2 :
#         if r+1 < N :
#             if not grid[r+1][c] :
#                 solution(r+1,c,1)
    
# import sys 
# input = sys.stdin.readline
# #아래, 오른쪽, 대각선 

# N = int(input())

# grid = [list(map(int,input().split())) for _ in range(N)]

# cnt = 0
# solution(0,1,0)
# print(cnt)

import sys 
input = sys.stdin.readline
#아래, 오른쪽, 대각선 

N = int(input())

grid = [list(map(int,input().split())) for _ in range(N)]
dp = [[[0]* N for _ in range(N)] for _ in range(3)]

dp[0][0][1] = 1 

# for i in dp :
#     for x in i :
#         print(x)
#     print('----------')
for i in range(2,N) :
    if grid[0][i] == 0 :
        dp[0][0][i] = dp[0][0][i-1]

for r in range(1,N) :
    for c in range(1,N) :

        if grid[r][c] == 0 and grid[r][c-1] == 0 and grid[r-1][c] == 0 :
            dp[2][r][c] = dp[0][r-1][c-1] + dp[1][r-1][c-1] + dp[2][r-1][c-1]
        
        if grid[r][c] == 0 :
            dp[0][r][c] = dp[0][r][c-1] + dp[2][r][c-1]

            dp[1][r][c] = dp[1][r-1][c] + dp[2][r-1][c]
ans = 0
for i in range(3) :
    ans += dp[i][N-1][N-1]
print(ans)