import sys
input = sys.stdin.readline

board = [list(map(int, input().split())) for _ in range(19)]

# 왼쪽 아래로, 아래로, 오른쪽 위로, 위로
dx = [-1, 0, 1, 1]
dy = [1, 1, 1, 0]

for x in range(19):
    for y in range(19):
        if board[x][y] != 0:  # 첫번째 나오는 돌
            start = board[x][y]
            # 4방향 탐색 시작
            for i in range(4):
                cnt = 1
                nx = x + dx[i]
                ny = y + dy[i]
                # 범위 체크
                while 0 <= nx < 19 and 0 <= ny < 19 and board[nx][ny] == start:
                    cnt += 1

                    if cnt == 5:
                        # 육목 체크
                        if 0 <= x - dx[i] < 19 and 0 <= y - dy[i] < 19 and board[x - dx[i]][y - dy[i]] == start:
                            break
                        if 0 <= nx + dx[i] < 19 and 0 <= ny + dy[i] < 19 and board[nx + dx[i]][ny + dy[i]] == start:
                            break
                        # 육목 X -> 종료
                        print(start)
                        print(x + 1, y + 1)
                        sys.exit(0)

                    nx += dx[i]
                    ny += dy[i]
print(0)