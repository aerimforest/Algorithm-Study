from collections import deque

n, m = map(int, input().split())
maps = [list(input()) for _ in range(n)]
max_len = 0
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
queue = deque()

def BFS(i, j):
    queue.append([i,j])
    visited = [[0] * m for _ in range(n)]
    max_value = 0
    visited[i][j] = 1

    while queue:
        x, y = queue.popleft()
        for a in range(4):
            nx = x + dx[a]
            ny = y + dy[a]

            if n > nx >= 0 and 0 <= ny < m:
                if maps[nx][ny] == 'L' and visited[nx][ny] == 0:
                    queue.append((nx,ny))
                    visited[nx][ny] = visited[x][y] + 1
                    max_value = max(max_value, visited[nx][ny])

    return max_value-1

for i in range(n):
    for j in range(m):
        if maps[i][j] == 'L':
            max_len = max(max_len, BFS(i,j))

print(max_len)
