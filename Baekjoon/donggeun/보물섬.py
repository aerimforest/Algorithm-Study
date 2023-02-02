from collections import deque
import sys
input = sys.stdin.readline

dx = [1,0,-1,0]
dy = [0,1,0,-1]

def bfs(i: int, j: int):
    queue = deque()
    queue.append([i,j])
    visited[i][j] = 1
    res = [0]
    while queue:
        y,x = queue.popleft()
        for k in range(4):
            nx = dx[k] + x
            ny = dy[k] + y

            if nx < 0 or ny < 0 or nx >= m or ny >= n:
                continue
            if not visited[ny][nx] and graph[ny][nx] == "L":
                queue.append([ny, nx])
                visited[ny][nx] = visited[y][x] + 1
                res.append(visited[ny][nx])
    
    return max(res)

n,m = map(int,input().split())
graph = [list(map(str,input().rstrip())) for _ in range(n)]
ans = []
for i in range(n):
    for j in range(m):
        if graph[i][j] == "L":
            visited = [[0] * m for _ in range(n)]
            ans.append(bfs(i,j))

print(max(ans)-1)
