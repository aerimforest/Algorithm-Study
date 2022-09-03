R, C, T = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(R)]
air = None
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

for i in range(R):
    for j in range(C):
        if grid[i][j] == -1:
            air = [(i, j), (i + 1, j)]
            break
    if air is not None:
        break

def extend_dust(grid):
    new_grid = [[0 for _ in range(C)] for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if grid[i][j] == -1:
                new_grid[i][j] = -1
                continue
            value = grid[i][j] // 5
            extend_count = 4
            for k in range(4):
                mx = j + dx[k]
                my = i + dy[k]
                if mx < 0 or mx >= C or my < 0 or my >= R or grid[my][mx] == -1:
                    extend_count -= 1
                    continue
                else:
                    new_grid[my][mx] += value
            new_grid[i][j] += grid[i][j] - ((grid[i][j] // 5) * extend_count)
    return new_grid

def air_move(grid):
    new_grid = [[grid[i][j] for j in range(C)] for i in range(R)]
    ao = air[0]
    ao2 = air[1]
    new_grid[ao[0]][ao[1] + 1] = 0
    new_grid[ao2[0]][ao[1] + 1] = 0
    new_grid[ao[0] - 1][ao[1]] = 0
    new_grid[ao2[0] + 1][ao2[1]] = 0

    for i in range(ao[1] + 2, C - ao[1]):
        new_grid[ao[0]][i] = grid[ao[0]][i - 1]
        new_grid[ao[0] + 1][i] = grid[ao[0] + 1][i - 1]

    for i in range(1, ao[0] + 1):
        new_grid[ao[0] - i][C - 1] = grid[ao[0] - i + 1][C - 1]
        if new_grid[i][ao[1]] != -1:
            new_grid[i][ao[1]] = grid[i - 1][ao[1]]

    for i in range(1, R - ao2[0]):
        new_grid[ao2[0] + i][C - 1] = grid[ao2[0] + i - 1][C - 1]
        if new_grid[R - 1 - i][ao2[1]] != -1:
            new_grid[R - 1 - i][ao2[1]] = grid[R - i][ao2[1]]

    for i in range(1, C):
        new_grid[0][C - i - 1] = grid[0][C - i]
        new_grid[R - 1][C - i - 1] = grid[R - 1][C - i]

    return new_grid

for i in range(T):
    grid = extend_dust(grid)
    grid = air_move(grid)

answer = 0
for i in range(R):
    for j in range(C):
        if grid[i][j] != -1:
            answer += grid[i][j]

print(answer)