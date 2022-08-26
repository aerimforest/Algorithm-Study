import sys
def read_line():
    return sys.stdin.readline().rstrip('\n')


def dfs(jwx, jwy, hp, milk):
    global result

    for x, y in milks:
        if _map[x][y] == 2:
            dist = abs(jwx - x) + abs(jwy - y)
            if dist <= hp:
                _map[x][y] = 0
                dfs(x, y, hp + h - dist, milk + 1)
                _map[x][y] = 2

    if abs(jwx - hx) + abs(jwy - hy) <= hp:
        result = max(result, milk)


n, m, h = map(int, read_line().split())
_map = [list(map(int, read_line().split())) for _ in range(n)]

milks = []
hx, hy = 0, 0

for i in range(n):
    for j in range(n):

        if _map[i][j] == 1:
            hx, hy = i, j

        if _map[i][j] == 2:
            milks.append((i, j))

result = 0
dfs(hx, hy, m, 0)
print(result)
