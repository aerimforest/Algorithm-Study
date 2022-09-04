import sys
from collections import deque


def read_line():
    return sys.stdin.readline().rstrip()


def read_into(type, seperator):
    return list(map(type, read_line().split(seperator)))


def read_lines(line_number, trim_each_line):
    return [trim_each_line(read_line())
            for _ in range(line_number)]


dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs(x, y):
    q.append([x, y])
    c[x][y] = cnt
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if a[nx][ny] == a[x][y] and c[nx][ny] == 0:
                    q.append([nx, ny])
                    c[nx][ny] = 1


n = int(read_line())
a = read_lines(n, list)
c = [[0] * n for _ in range(n)]
q = deque()

cnt = 0
for i in range(n):
    for j in range(n):
        if c[i][j] == 0:
            bfs(i, j)
            cnt += 1
print(cnt, end=' ')

for i in range(n):
    for j in range(n):
        if a[i][j] == 'R':
            a[i][j] = 'G'
c = [[0] * n for _ in range(n)]

cnt = 0
for i in range(n):
    for j in range(n):
        if c[i][j] == 0:
            bfs(i, j)
            cnt += 1
print(cnt)
