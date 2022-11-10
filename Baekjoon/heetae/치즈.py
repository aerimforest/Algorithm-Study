import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
time = 0


def bfs():
    dq = deque()
    dq.append((0, 0))
    visited[0][0] = 1

    while dq:
        x, y = dq.popleft()

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            if 0 <= nx < N and 0 <= ny < M and visited[nx][ny] == 0:
                if arr[nx][ny] >= 1:
                    arr[nx][ny] += 1
                else:
                    visited[nx][ny] = 1
                    dq.append((nx, ny))


while True:
    flag = False
    visited = [[0] * M for _ in range(N)]
    bfs()

    for i in range(N):
        for j in range(M):
            if arr[i][j] >= 3:
                arr[i][j] = 0
                flag = True
            elif arr[i][j] == 2:
                arr[i][j] = 1

    if not flag:
        break

    time += 1

print(time)
