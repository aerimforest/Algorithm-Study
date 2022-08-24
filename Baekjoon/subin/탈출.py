import sys
from collections import deque

sys.setrecursionlimit(10 ** 5)

R, C = map(int, sys.stdin.readline().split(" "))

map_arr = []
for _ in range(R):
    map_arr.append(list(sys.stdin.readline().strip()))

visited_arr = []
for _ in range(R):
    visited_arr.append([0 for _ in range(C)])

water_queue = deque()
dochi_queue = deque()

for i in range(R):
    for j in range(C):
        if map_arr[i][j] == "*":
            water_queue.append((i, j))
        if map_arr[i][j] == "S":
            dochi_queue.append((i, j))
            visited_arr[i][j] == 1

di = [(1, 0), (0, 1), (-1, 0), (0, -1)]

while dochi_queue:
    for _ in range(len(water_queue)):
        water_x, water_y = water_queue.popleft()
        for d in di:
            water_nx = water_x + d[0]
            water_ny = water_y + d[1]

            if water_nx < 0 or water_ny < 0 or water_nx > R - 1 or water_ny > C - 1: continue
            if map_arr[water_nx][water_ny] == '.':
                map_arr[water_nx][water_ny] = '*'
                water_queue.append((water_nx, water_ny))

    for _ in range(len(dochi_queue)):
        dochi_x, dochi_y = dochi_queue.popleft()

        for d in di:
            dochi_nx = dochi_x + d[0]
            dochi_ny = dochi_y + d[1]

            if dochi_nx < 0 or dochi_ny < 0 or dochi_nx > R - 1 or dochi_ny > C - 1: continue
            if map_arr[dochi_nx][dochi_ny] == '.' and visited_arr[dochi_nx][dochi_ny] == 0:
                visited_arr[dochi_nx][dochi_ny] = visited_arr[dochi_x][dochi_y] + 1
                dochi_queue.append((dochi_nx, dochi_ny))
            if map_arr[dochi_nx][dochi_ny] == 'D':
                print(visited_arr[dochi_x][dochi_y] + 1)
                exit()

print("KAKTUS")