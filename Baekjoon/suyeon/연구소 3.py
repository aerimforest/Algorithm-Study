import sys
from copy import deepcopy
from itertools import combinations

INF = int(1e9)
EMPTY, WALL, DEACTIVATE_VIRUS = ' ', '-', '*'

# 상 하 좌 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def get_max_time(matrix, min_time):
    max_time = 0
    is_empty = False

    for x in range(N):
        for y in range(N):
            status = matrix[x][y]

            if status == EMPTY:
                is_empty = True
                break

            if status != WALL and status != DEACTIVATE_VIRUS:
                max_time = max(max_time, status)

    if is_empty:
        return min_time

    return max_time


def spread_virus(matrix, x, y, time):
    next_steps = []

    for d in range(4):
        nx, ny = x + dx[d], y + dy[d]

        if nx < 0 or nx >= N or ny < 0 or ny >= N:
            continue

        if matrix[nx][ny] == EMPTY:
            matrix[nx][ny] = time
            next_steps.append((nx, ny))
        elif matrix[nx][ny] == DEACTIVATE_VIRUS:
            matrix[nx][ny] = 0
            next_steps.append((nx, ny))

    return next_steps


def get_min_time():
    min_time = INF

    for next_steps in combinations(viruses, M):
        copy_lab_matrix = deepcopy(lab_matrix)

        for x, y in next_steps:
            copy_lab_matrix[x][y] = 0

        time = 1
        while next_steps:
            temp = []

            for x, y in next_steps:
                temp.extend(spread_virus(copy_lab_matrix, x, y, time))

            time += 1
            next_steps = temp

        min_time = min(min_time, get_max_time(copy_lab_matrix, min_time))

    return min_time if min_time != INF else -1


N, M = map(int, input().split())

viruses = []
lab_matrix = [[EMPTY] * N for _ in range(N)]

for i in range(N):
    for j, input_type in enumerate(sys.stdin.readline().split()):
        if input_type == '1':
            lab_matrix[i][j] = WALL
        elif input_type == '2':
            lab_matrix[i][j] = DEACTIVATE_VIRUS
            viruses.append((i, j))

print(get_min_time())
