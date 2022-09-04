import sys
sys.setrecursionlimit(1000000)

RED, GREEN = 'R', 'G'

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def dfs(x, y):
    visited[x][y] = True
    color = matrix[x][y]

    for d in range(4):
        nx, ny = x + dx[d], y + dy[d]

        if nx < 0 or nx >= n or ny < 0 or ny >= n:
            continue

        if not visited[nx][ny] and matrix[nx][ny] == color:
            dfs(nx, ny)


n = int(input())
matrix = [list(sys.stdin.readline().strip()) for _ in range(n)]

count = 0
visited = [[False] * n for _ in range(n)]

for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            dfs(i, j)
            count += 1

        if matrix[i][j] == RED:
            matrix[i][j] = GREEN

print(count)

count = 0
visited = [[False] * n for _ in range(n)]

for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            dfs(i, j)
            count += 1

print(count)
