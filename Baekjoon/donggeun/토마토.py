import sys
from collections import deque
input =sys.stdin.readline

n,m = map(int, input().rstrip().split())
graph = [list(map(int,input().rstrip().split())) for _ in range(m)]
queue = deque()
dx = [-1,1,0,0]
dy = [0,0,-1,1]

for i in range(m):
    for j in range(n):
        if graph[i][j] == 1:
            queue.append([i,j])

def bfs():
    while queue:
        x,y = queue.popleft()
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]

            if -1 < nx < m and -1 < ny < n:
                if graph[nx][ny] == 0:
                    queue.append([nx,ny])
                    graph[nx][ny] = graph[x][y] + 1

bfs()
ans = 0
for i in range(m):
    for j in range(n):
        if graph[i][j] == 0:
            ans = -1
            print(ans)
            exit()
    ans = max(ans, max(graph[i]))
print(ans-1)