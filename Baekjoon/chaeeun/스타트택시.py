# [참고]
# BFS

import copy
from collections import deque
n, m, k = map(int, input().split())
graph = []
for i in range(n):
    data = list(map(int, input().split()))
    array = []
    for d in data:
        if d == 1:
            array.append(-1)
        else:
            array.append(-2)

    graph.append(array)

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]
cus = []
t_x, t_y = map(int, input().split())
t_x -= 1
t_y -= 1
for _ in range(m):
    a, b, c, d = map(int, input().split())
    cus.append([a, b, c, d])

def cal_dis(graph, t_x, t_y):
    g = copy.deepcopy(graph)
    visited = [[False]*n for _ in range(n)]
    q = deque()
    q.append((t_x, t_y))
    g[t_x][t_y] = 0
    visited[t_x][t_y] = True
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 > nx or 0 > ny or nx >= n or ny >= n:
                continue
            if g[nx][ny] == -1 or visited[nx][ny] == True:
                continue
            g[nx][ny] = g[x][y] + 1
            visited[nx][ny] = True
            q.append((nx, ny))
    return g


while True:
    if k < 0:
        break
    if len(cus) == 0:
        break
    move = []
    g_copy = cal_dis(graph, t_x, t_y)
    # 택시 - 손님
    for c in cus:
        a, b, c, d = c
        dis = g_copy[a-1][b-1]
        if dis < 0:
            continue
        move.append([dis, a-1, b-1, c-1, d-1])
    if len(move) == 0:
        k = -1
        break
    else:
        move.sort(key=lambda x:(x[0], x[1], x[2]))
        # 손님 - 도착지
        if move[0][0] > k:
            k = -1
            break
        else:
            k -= move[0][0]
            t_x, t_y, a, b = move[0][1:]
            end = cal_dis(graph, t_x, t_y)
            d = end[a][b]
            if d < 0:
                k = -1
                break
            k -= d
            if k >= 0:
                k += (d*2)
                cus.remove([t_x+1, t_y+1, a+1, b+1])
                t_x, t_y = a, b
            else:
                k = -1
                break

print(k)