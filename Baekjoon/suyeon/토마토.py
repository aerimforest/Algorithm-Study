import sys
from collections import deque

NO_TOMATO, UNRIPE_TOMATO, RIPE_TOMATO = -1, 0, 1

# 위, 아래, 상, 하, 좌, 우
dz = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, 0, 0, -1, 1]
dx = [0, 0, -1, 1, 0, 0]


def get_min_day():
    max_day = -1

    for z in range(H):
        for y in range(N):
            for x in range(M):
                if matrix[z][y][x] == UNRIPE_TOMATO:
                    return -1

                max_day = max(max_day, matrix[z][y][x])

    if max_day == 1:
        return 0

    return max_day - 1


def bfs():
    while queue:
        z, y, x = queue.popleft()

        for i in range(6):
            nz = z + dz[i]
            ny = y + dy[i]
            nx = x + dx[i]

            if nz < 0 or ny < 0 or nx < 0 or nz >= H or ny >= N or nx >= M:
                continue

            if matrix[nz][ny][nx] == NO_TOMATO:
                continue

            if matrix[nz][ny][nx] == UNRIPE_TOMATO:
                matrix[nz][ny][nx] = matrix[z][y][x] + 1
                queue.append((nz, ny, nx))


M, N, H = map(int, input().split())

matrix = []
queue = deque([])

for z in range(H):
    matrix.append([])
    for y in range(N):
        matrix[z].append(list(map(int, sys.stdin.readline().split())))
        for x in range(M):
            if matrix[z][y][x] == RIPE_TOMATO:
                queue.append((z, y, x))

bfs()
print(get_min_day())
