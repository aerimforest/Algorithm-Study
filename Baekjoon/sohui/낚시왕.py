import sys

input = sys.stdin.readline

move = [(-1, 0), (1, 0), (0, 1), (0, -1)]
change_dir = [1, 0, 3, 2]


def move_shark(r, c, d, s):
    if 0 < s * move[d][0] + r <= R and 0 < s * move[d][1] + c <= C:
        return s * move[d][0] + r, s * move[d][1] + c, d

    if d == 0:
        s += (R - r)
    elif d == 1:
        s += r - 1
    elif d == 2:
        s += c - 1
    elif d == 3:
        s += (C - c)

    if d == 2 or d == 3:
        k = (s - 1) // (C - 1)
        go = (s - k * (C - 1)) % C
    else:
        k = (s - 1) // (R - 1)
        go = (s - k * (R - 1)) % R
    if k % 2 == 1:
        d = change_dir[d]
    if d == 0:
        r = R
    elif d == 1:
        r = 1
    elif d == 2:
        c = 1
    else:
        c = C
    r += move[d][0] * go
    c += move[d][1] * go
    return r, c, d


R, C, M = map(int, input().split())
shark = [[[] for _ in range(C + 1)] for _ in range(R + 1)]
for _ in range(M):
    r, c, s, d, z = map(int, input().split())
    shark[r][c] = [s, d - 1, z]
answer = 0
for i in range(1, C + 1):
    for j in range(1, R + 1):
        if shark[j][i]:
            answer += shark[j][i][2]
            shark[j][i] = []
            break
    temp = [[[] for _ in range(C + 1)] for _ in range(R + 1)]
    for r in range(1, R + 1):
        for c in range(1, C + 1):
            if not shark[r][c]: continue
            r_, c_, d_ = move_shark(r, c, shark[r][c][1], shark[r][c][0])
            if temp[r_][c_] and temp[r_][c_][2] > shark[r][c][2]:
                continue
            temp[r_][c_] = shark[r][c]
            temp[r_][c_][1] = d_
    shark = temp
print(answer)
