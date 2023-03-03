from collections import deque
import sys
input = sys.stdin.readline

dx = [0,1,-1,0]
dy = [1,0,0,-1]

def burn():
    while fire:
        a,b,t = fire.popleft()
        visited[a][b] = t

        for i in range(4):
            nx = dx[i] + a
            ny = dy[i] + b
            if nx < 0 or ny < 0 or nx >= r or ny >= c:
                continue
            if visited[nx][ny] == 0:
                visited[nx][ny] = t+1
                fire.append([nx,ny,t+1])
    return visited

def run():
    while queue:
        x,y,cnt = queue.popleft()
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]

            if nx < 0 or ny < 0 or nx >= r or ny >= c:
                continue
            if visited[nx][ny] == 0 or visited[nx][ny] > cnt+1 and visited[nx][ny] != -1:
                queue.append([nx,ny,cnt+1])
                visited[nx][ny]=-1
                if nx==r-1 or nx==0 or ny==c-1 or ny==0:
                    return cnt+1
                
    return "IMPOSSIBLE"

r,c = map(int,input().split())
graph = [list(map(str,input().rstrip())) for _ in range(r)]
visited = [[0]*(c) for _ in range(r)]
fire = deque()
queue = deque()
for i in range(r):
    for j in range(c):
        if graph[i][j] == 'F':
            fire.append([i,j,1])
        elif graph[i][j] == 'J':
            if i==0 or i==r-1 or j==0 or j==c-1:
                print(1)
                exit()
            queue.append([i,j,1])
        elif graph[i][j] == '#':
            visited[i][j] = -1

burn()
print(run())