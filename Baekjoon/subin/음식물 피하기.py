import sys
from collections import deque

n, m, k = map(int, sys.stdin.readline().split())

adj = [[0] * m for _ in range(n)]
visited = [[False] * m for _ in range(n)]

for _ in range(k):
    r, c = map(int, sys.stdin.readline().split())
    r -= 1
    c -= 1

    adj[r][c] = 1

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

d = deque()


def bfs(y, x):
    d.append((y, x))
    trash = 1

    while d:
        y, x = d.popleft()

        for i in range(4):
            # 하 상 좌 우 순으로 검사
            ny = y + dy[i]
            nx = x + dx[i]

            if ny < 0 or ny >= n or nx < 0 or nx >= m or visited[ny][nx]:
                continue

            if adj[ny][nx] == 1:
                trash += 1
                adj[ny][nx] = trash

                visited[ny][nx] = True
                d.append((ny, nx))
            else:
                continue


for i in range(n):
    for j in range(m):
        if adj[i][j] == 1 and not visited[i][j]:
            visited[i][j] = True
            bfs(i, j)

maxTrashNum = 0
for i in range(n):
    for j in range(m):
        if maxTrashNum < adj[i][j]:
            maxTrashNum = adj[i][j]

print(maxTrashNum)