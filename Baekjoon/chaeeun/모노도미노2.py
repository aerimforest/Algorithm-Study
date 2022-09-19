# [참고]

import sys

input = sys.stdin.readline


def check_blue():
    global ans
    for j in range(2, 6):
        cnt = 0
        for i in range(4):
            if b[i][j]:
                cnt += 1

        if cnt == 4:
            remove_blue(j)
            ans += 1


def check_green():
    global ans
    for i in range(2, 6):
        cnt = 0
        for j in range(4):
            if g[i][j]:
                cnt += 1

        if cnt == 4:
            remove_green(i)
            ans += 1


def remove_blue(idx):
    for j in range(idx, 0, -1):
        for i in range(4):
            b[i][j] = b[i][j-1]
    for i in range(4):
        b[i][0] = 0


def remove_green(idx):
    for i in range(idx, 0, -1):
        for j in range(4):
            g[i][j] = g[i-1][j]
    for j in range(4):
        g[0][j] = 0


def move_blue(t, x):
    global b
    y = 1
    if t == 1 or t == 2:
        while True:
            if y + 1 > 5 or b[x][y+1]:
                b[x][y] = 1
                if t == 2:
                    b[x][y-1] = 1
                break
            y += 1

    else:
        while True:
            if y + 1 > 5 or b[x][y+1] != 0 or b[x+1][y+1] != 0:
                b[x][y], b[x+1][y] = 1, 1
                break
            y += 1

    check_blue()

    for j in range(2):
        for i in range(4):
            if b[i][j]:
                remove_blue(5)
                break


def move_green(t, y):
    global g
    x = 1
    if t == 1 or t == 3:
        while True:
            if x + 1 > 5 or g[x+1][y]:
                g[x][y] = 1
                if t == 3:
                    g[x-1][y] = 1
                break
            x += 1

    else:
        while True:
            if x + 1 > 5 or g[x+1][y] or g[x+1][y+1]:
                g[x][y], g[x][y+1] = 1, 1
                break
            x += 1

    check_green()

    for i in range(2):
        for j in range(4):
            if g[i][j]:
                remove_green(5)
                break


tc = int(input())
b = [[0] * 6 for _ in range(4)]
g = [[0] * 4 for _ in range(6)]

ans = 0
for i in range(tc):
    t, x, y = map(int, input().split())
    move_blue(t, x)
    move_green(t, y)

cnt_b, cnt_g = 0, 0
for i in range(4):
    for j in range(2, 6):
        if b[i][j]:
            cnt_b += 1
for i in range(2, 6):
    for j in range(4):
        if g[i][j]:
            cnt_g += 1

print(ans)
print(cnt_b + cnt_g)