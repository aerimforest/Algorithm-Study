from collections import deque
from sys import stdin

input = stdin.readline
dx = [1, -1, 0, 0, 1, 1, -1, -1]
dy = [0, 0, 1, -1, 1, -1, 1, -1]


def bfs(x):
    q.append(x)
    c.append(x)
    cnt = 0
    while q:
        qlen = len(q)
        while qlen:
            x = q.popleft()
            if x == e:
                print(cnt)
                return
            check_turn(x)
            for i in range(4):
                check = []
                flag = 0
                for j in range(3):
                    nx = x[j][0] + dx[i]
                    ny = x[j][1] + dy[i]
                    if 0 <= nx < n and 0 <= ny < n and a[nx][ny] != '1':
                        check.append([nx, ny])
                    else:
                        flag = 1
                        break
                if check not in c and flag == 0:
                    c.append(check)
                    q.append(check)
            qlen -= 1
        cnt += 1
    print(0)


def check_turn(x):
    for i in range(4, 8):
        nx = x[1][0] + dx[i]
        ny = x[1][1] + dy[i]
        if nx < 0 or ny < 0 or nx >= n or ny >= n or a[nx][ny] == '1':
            return
    if x[0][0] == x[1][0]:
        tx = x[1][0]
        ty = x[1][1]
        if a[tx - 1][ty] != '1' and a[tx + 1][ty] != '1':
            nb = [[tx - 1, ty], [tx, ty], [tx + 1, ty]]
            if nb not in c:
                c.append(nb)
                q.append(nb)
    elif x[0][1] == x[1][1]:
        tx = x[1][0]
        ty = x[1][1]
        if a[tx][ty - 1] != '1' and a[tx][ty + 1] != '1':
            nb = [[tx, ty - 1], [tx, ty], [tx, ty + 1]]
            if nb not in c:
                c.append(nb)
                q.append(nb)


n = int(input())
a = [list(input().strip()) for _ in range(n)]
c, b, e = [], [], []
q = deque()

for i in range(n):
    for j in range(n):
        if a[i][j] == 'B':
            b.append([i, j])
        elif a[i][j] == 'E':
            e.append([i, j])

bfs(b)
