# 다른 사람 풀이 (답지 봄) 

from collections import deque

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

n = int(input())
a = [list(map(str, input())) for _ in range(n)]
c = [[0]*n for _ in range(n)]
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
c = [[0]*n for _ in range(n)]

cnt = 0
for i in range(n):
    for j in range(n):
        if c[i][j] == 0:
            bfs(i, j)
            cnt += 1
print(cnt)
