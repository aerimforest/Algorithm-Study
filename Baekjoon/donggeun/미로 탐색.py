import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int, input().rstrip().split())
graph = []
dx = [0, 0, -1, 1] # 상하좌우
dy = [1, -1, 0, 0]
for i in range(n):
    graph.append(list(map(int, input().rstrip())))

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))
    return graph[n-1][m-1]

print(bfs(0,0))