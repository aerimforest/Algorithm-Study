from collections import deque
import sys

input = sys.stdin.readline

def _int(n):
    return int(n) - 1

N, M, fuel = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]
pboard = [[0] * N for _ in range(N)]
tx, ty = map(_int, input().split())
pas_list = [list(map(_int, input().split())) for _ in range(M)]


def bfs1(sx, sy):
    global fuel, tx, ty
    check = [[0] * N for _ in range(N)]
    q = deque()
    q.append((sx, sy))
    check[sx][sy] = 1

    tq = list()

    depth = 0
    while q:
        depth += 1
        if fuel == 0:
            return False, (-1, -1)
        fuel -= 1

        for _ in range(len(q)):
            x, y = q.popleft()
            for (nx, ny) in [(x - 1, y), (x, y - 1), (x, y + 1), (x + 1, y)]:
                if 0 <= nx < N and 0 <= ny < N:
                    if check[nx][ny] or board[nx][ny]:
                        continue
                    if pboard[nx][ny]:
                        tq.append((nx, ny))
                    check[nx][ny] = 1
                    q.append((nx, ny))

        if tq:
            nx, ny = sorted(tq)[0]
            tx, ty = nx, ny
            dx, dy = pboard[nx][ny]
            pboard[nx][ny] = 0
            return True, (dx, dy)
    return False, (-1, -1)


def bfs2(sx, sy, dx, dy):
    global fuel, tx, ty

    check = [[0] * N for _ in range(N)]
    check[sx][sy] = 1
    q = deque()
    q.append((sx, sy))

    depth = 0
    while q:
        depth += 1

        if fuel == 0:
            return False
        fuel -= 1

        for _ in range(len(q)):
            x, y = q.popleft()
            for (nx, ny) in [(x - 1, y), (x, y - 1), (x, y + 1), (x + 1, y)]:
                if 0 <= nx < N and 0 <= ny < N:
                    if check[nx][ny] or board[nx][ny]:
                        continue
                    if (nx, ny) == (dx, dy):
                        tx, ty = dx, dy
                        fuel += depth * 2
                        return True

                    check[nx][ny] = 1
                    q.append((nx, ny))
    return False


for x1, y1, x2, y2 in pas_list:
    pboard[x1][y1] = (x2, y2)


def solution():
    for _ in range(M):
        if pboard[tx][ty]:
            flag = True
            dx, dy = pboard[tx][ty]
            pboard[tx][ty] = 0
        else:
            flag, (dx, dy) = bfs1(tx, ty)

        if not flag:
            return False

        flag = bfs2(tx, ty, dx, dy)

        if not flag:
            return False

    return True


if solution():
    print(fuel)
else:
    print(-1)
