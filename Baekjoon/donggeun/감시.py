import sys
input = sys.stdin.readline

n,m = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
cctv = {1:[], 2:[], 3:[], 4:[], 5:[]}
wall = []

# 1: 한방향(4), 2: 양방향(2), 3: 직각(4), 4: 세방향(4), 5: 네방향(1)
for i in range(n):
    for j in range(m):
        if board[i][j] == 0:
            pass
        elif board[i][j] == 1:
            cctv[1].append([i,j])
        elif board[i][j] == 2:
            cctv[2].append([i,j])
        elif board[i][j] == 3:
            cctv[3].append([i,j])
        elif board[i][j] == 4:
            cctv[4].append([i,j])
        elif board[i][j] == 5:
            cctv[5].append([i,j])
        else:
            wall.append([i,j])
tmp = []
# cctv 각각 경우의 수 만들어서 cctv 방향과 wall 탐색
print("")