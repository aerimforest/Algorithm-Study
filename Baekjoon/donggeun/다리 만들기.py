from collections import deque
import sys
input = sys.stdin.readline

dx = [1,0,-1,0]
dy = [0,1,0,-1]


def bfs_sep(a:int, b:int, c: int):
    queue = deque()
    queue.append([a,b,c])

    while queue:
        y,x,idx = queue.popleft()
        
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y

            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            if not visited[ny][nx] and graph[ny][nx] == 1:
                queue.append([ny,nx,idx])
                visited[ny][nx] = idx
    
def bfs_cnt(a:int, b:int, c:int) -> int:
    queue = deque()
    queue.append([a,b,c,0])
    visited_bool = [[False]*n for _ in range(n)]
    visited_bool[a][b] = True

    while queue:
        y,x,idx, cnt = queue.popleft()

        if visited[y][x] != idx and graph[y][x] != 0:
            return cnt

        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y

            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            if graph[ny][nx] == idx:
                continue
            if not visited_bool[ny][nx]:
                queue.append([ny, nx, idx, cnt +1])
                visited_bool[ny][nx] = True

    return 10001



n = int(input())
graph = [list(map(int,input().split())) for _ in range(n)]
visited = [[0]*n for _ in range(n)]
ans = 10001


k = 1
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1 and not visited[i][j]:
            visited[i][j] = k
            bfs_sep(i,j,k)
            k += 1

for i in range(n):
    for j in range(n):
        if visited[i][j]:
            ans = min(ans, bfs_cnt(i,j,visited[i][j])-1)
            
print(ans)