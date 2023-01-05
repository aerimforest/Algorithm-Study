import sys
from collections import deque
input = sys.stdin.readline

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

n = int(input())
mat = [list(input().strip()) for _ in range(n)]

start = ()
dest = ()

for i in range(n):
    for j in range(n):
        if len(start) == 0 and mat[i][j] == "B":
            if i < n - 1 and mat[i + 1][j] == "B":
                start = (i + 1, j, 1)
                for k in range(3):
                    mat[i + k][j] = "0"

            elif j < n - 1 and mat[i][j + 1] == "B":
                start = (i, j + 1, 0)
                for k in range(3):
                    mat[i][j + k] = "0"

            continue

        if len(dest) == 0 and mat[i][j] == "E":
            if i < n - 1 and mat[i + 1][j] == "E":
                dest = (i + 1, j, 1)

            elif j < n - 1 and mat[i][j + 1] == "E":
                dest = (i, j + 1, 0)

            continue

def move(y, x, d, c):
    if c == 4:
        if 1 <= y < n - 1 and 1 <= x < n - 1:
            for i in range(y - 1, y + 2):
                for j in range(x - 1, x + 2):
                    if mat[i][j] == "1":
                        return (y, x, d)
            return (y, x, 1 - d)

    else:
        nx = x + dx[c]
        ny = y + dy[c]
        if d == 0:
            if 0 <= ny < n and 1 <= nx < n - 1:
                if (
                    mat[ny][nx - 1] != "1"
                    and mat[ny][nx] != "1"
                    and mat[ny][nx + 1] != "1"
                ):
                    return (ny, nx, d)
        elif d == 1:
            if 1 <= ny < n - 1 and 0 <= nx < n:
                if (
                    mat[ny - 1][nx] != "1"
                    and mat[ny][nx] != "1"
                    and mat[ny + 1][nx] != "1"
                ):
                    return (ny, nx, d)

    return (y, x, d)



def bfs(start):
        visited = [[[0] * n for _ in range(n)] for _ in range(2)]
        y, x, d = start
        visited[d][y][x] = 1
        que = deque()
        que.append((y, x, d, 0))

        while que:
            y, x, d, cnt = que.popleft()

            for i in range(5):
                ny, nx, nd = move(y, x, d, i)

                if visited[nd][ny][nx] == 0:
                    if (ny, nx, nd) == dest:
                        print(cnt + 1)
                        return
                    visited[nd][ny][nx] = 1
                    que.append((ny, nx, nd, cnt + 1))
        print(0)

bfs(start)