import sys

BLACK, WHITE, EMPTY = '1', '2', '0'

# 상 하 / 좌 우 / +대각선 / -대각선
dx = [1, 0, -1, 1]
dy = [0, 1, 1, 1]


def check(x, y):
    stone_type = board[x][y]

    for d in range(4):
        count = 0
        nx, ny = x, y

        while 0 <= nx < 19 and 0 <= ny < 19 and board[nx][ny] == stone_type:
            count += 1
            nx, ny = nx + dx[d], ny + dy[d]

        if count == 5:
            nx, ny = x - dx[d], y - dy[d]

            if 0 <= nx < 19 and 0 <= ny < 19 and board[nx][ny] == stone_type:
                continue

            print(stone_type)
            print(x + 1, y + 1)
            return True

    return False


board = [sys.stdin.readline().split() for _ in range(19)]

is_win = False

for i in range(19):
    for j in range(19):
        if board[i][j] == EMPTY:
            continue

        if check(i, j):
            is_win = True
            break

    if is_win:
        break

if not is_win:
    print(EMPTY)
