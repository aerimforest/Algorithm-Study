from collections import deque
import sys
input = sys.stdin.readline

dx = [0,1,-1,0]
dy = [1,0,0,-1]

def bfs():
    queue = deque()
    queue.append([0,0,0])
    visited = [[[False]*n for _ in range(n)] for __ in range(2*n+1)]
    visited[0][0][0] = True
    while queue:
        x,y,cnt = queue.popleft()
        print("x",x,'y',y, "cnt",cnt)
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y

            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            
            if board[ny][nx] and not visited[cnt][ny][nx]:
                queue.append([nx, ny, cnt])
                visited[cnt][ny][nx] = True
            elif not board[ny][nx] and not visited[cnt+1][ny][nx]: # 벽부숨
                if cnt + 1 >= 2*n:
                    continue

                queue.append([nx,ny,cnt+1])
                visited[cnt+1][ny][nx] = True

    for room in range(n):
        if visited[room][n-1][n-1]:
            return room

n = int(input())
board = [list(map(int,input().rstrip())) for _ in range(n)]
print(bfs())

"""
반례
3
100
000
001
"""