from collections import deque

r, c, n = map(int, input().split())
data = [list(input()) for _ in range(r)]
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
q = deque()


def bfs(q, data):
    while q:
        x, y = q.popleft()
        data[x][y] = '.'
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < r and 0 <= ny < c and data[nx][ny] == 'O':
                data[nx][ny] = '.'


def simulate(time):
    global data, q
    if time == 1:
        for i in range(r):
            for j in range(c):
                if data[i][j] == 'O':
                    q.append((i, j))
    elif time % 2 == 1:
        bfs(q, data)
        for x in range(r):
            for y in range(c):
                if data[x][y] == 'O':
                    q.append((x, y))
    else:
        data = [['O'] * c for _ in range(r)]


for i in range(1, n + 1):
    simulate(i)

for row in data:
    print(''.join(row))
