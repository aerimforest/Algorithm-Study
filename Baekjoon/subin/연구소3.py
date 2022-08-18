from collections import deque
from itertools import combinations
import sys

input = sys.stdin.readline
inf = sys.maxsize

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
dx, dy = (-1, 1, 0, 0), (0, 0, -1, 1)

def bfs(active):
    q = deque()
    visited = [[-1] * n for _ in range(n)]
    result = 0

    for x, y in active:
        q.append((x, y))
        visited[x][y] = 0

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            if 0 <= nx < n and 0 <= ny < n:
                if graph[nx][ny] == 0 and visited[nx][ny] == -1:
                    q.append((nx, ny))
                    visited[nx][ny] = visited[x][y] + 1
                    result = max(result, visited[nx][ny])
                elif graph[nx][ny] == 2 and visited[nx][ny] == -1:
                    q.append((nx, ny))
                    visited[nx][ny] = visited[x][y] + 1

    if list(sum(visited, [])).count(-1) != wall_cnt:
        return inf
    return result

wall_cnt = 0
virus = []
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            wall_cnt += 1
        elif graph[i][j] == 2:
            virus.append((i, j))

ans = inf
for active in combinations(virus, m):
    ans = min(ans, bfs(active))

print(ans if ans != inf else -1)