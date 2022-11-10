import math
import sys
from collections import deque

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

N, L, R = map(int, input().split())
graph = []
dx = [0, 0, 1, -1]
dy = [-1, 1, 0, 0]
result = 0

for _ in range(N):
    graph.append(list(map(int, input().split())))


def bfs(i, j):
    dq = deque()
    dq.append((i, j))
    union = [(i, j)]
    visited[i][j] = True
    num = graph[i][j]

    while dq:
        x, y = dq.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue
            if visited[nx][ny]:
                continue
            if L <= abs(graph[nx][ny] - graph[x][y]) <= R:
                union.append((nx, ny))
                visited[nx][ny] = True
                dq.append((nx, ny))
                num += graph[nx][ny]

    for x, y in union:
        graph[x][y] = math.floor(num / len(union))

    return len(union)


while True:
    visited = [[False] * N for _ in range(N)]
    flag = False

    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                if bfs(i, j) > 1:
                    flag = True
    if not flag:
        break
    result += 1

print(result)
