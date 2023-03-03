from collections import deque
import sys
input = sys.stdin.readline

dx = [0,1,0,-1]
dy = [1,0,-1,0]

hx = [2,2,-2,-2,1,-1,1,-1]
hy = [-1,1,-1,1,2,2,-2,-2]

def bfs(a,b,c):
    queue = deque()
    queue.append([a,b,c,0])
    visited[c][a][b] = True
    
    while queue:
        x,y,z,cnt = queue.popleft()

        if x == h-1 and y == w-1:
            return cnt
        
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y

            if nx < 0 or ny < 0 or nx >= h or ny >= w:
                continue
            if board[nx][ny] == 0 and not visited[z][nx][ny]:
                queue.append([nx,ny,z,cnt+1])
                visited[z][nx][ny] = True

        if z > 0:
            for i in range(8):
                nx = hx[i] + x
                ny = hy[i] + y

                if nx < 0 or ny < 0 or nx >= h or ny >= w:
                    continue
                if board[nx][ny] == 0 and not visited[z-1][nx][ny]:
                    queue.append([nx,ny,z-1, cnt+1])
                    visited[z-1][nx][ny] = True
    
    return -1

k = int(input())
w,h = map(int,input().split())

# visited[a][b][c] board[b][c] 에 a번 만큼 말의 이동으로 방문했는지
visited = [[[False]*(w) for _ in range(h)] for __ in range(k+1)]

board = [list(map(int,input().split())) for _ in range(h)]

print(bfs(0,0,k))
