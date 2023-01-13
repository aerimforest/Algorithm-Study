from collections import deque
import sys
input = sys.stdin.readline

dx = [0,1,-1,0,-1,-1,1,1]
dy = [1,0,0,-1,-1,1,1,-1]

def bfs(q):
    while q:
        x,y,cnt = q.popleft()
        for i in range(8):
            nx = x+dx[i]
            ny = y+dy[i]

            if nx <0 or ny < 0 or nx >= n or ny >= m:
                continue

            if visited[nx][ny]==-1:
                q.append([nx,ny,cnt+1])
                visited[nx][ny] = cnt+1

n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
visited = [[-1]*(m) for _ in range(n)]
queue = deque()
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            queue.append([i,j,0])
            visited[i][j] = 0
bfs(queue)
ans = 0

for i in visited:
    if ans < max(i):
        ans = max(i)

print(ans)