import sys
from collections import deque
input = sys.stdin.readline

m, n, h = map(int, input().split())

tomato = [[list(map(int, input().split())) for i in range(n)] for depth in range(h)]

dx = [-1, 0, 1, 0, 0, 0]
dy = [0, 1, 0, -1, 0, 0]
dh = [0, 0, 0, 0, -1, 1]
queue = deque()

for i in range(h):
    for j in range(n):
        for k in range(m):
            if tomato[i][j][k] == 1:
                queue.append([i, j, k])
while queue:
    z, x, y = queue.popleft()
    for i in range(6):  # 6방향 탐색
        nz = z + dh[i]
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < n and 0 <= ny < m and 0 <= nz < h:
            if tomato[nz][nx][ny] == 0:
                tomato[nz][nx][ny] = tomato[z][x][y] + 1
                queue.append([nz, nx, ny])

flag = False
for i in tomato: # 익지 않은 토마토 존재할
    for j in i:
        for k in j:
            if k == 0:
                flag = True
                break

if flag:
    print(-1)
else:
    max_value = 0
    for i in range(h):
        for j in range(n):
            for k in range(m):
                max_value = max(max_value, tomato[i][j][k]) # 가장 마지막 토마토가 익는 시
    print(max_value - 1)
