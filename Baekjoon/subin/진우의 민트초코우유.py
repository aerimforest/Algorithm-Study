import sys
input = lambda: sys.stdin.readline().strip()

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
result = 0


def dfs(x, y, HP, milk):
    global result

    for nx, ny in milks:
        # 우유를 마시지 않았다면
        if maps[nx][ny] == 2:
            dist = abs(nx - x) + abs(ny - y)
            if dist <= HP:
                maps[nx][ny] = 0
                dfs(nx, ny, HP + H - dist, milk + 1)
                maps[nx][ny] = 2

    if abs(x - i) + abs(y - j) <= HP:
        result = max(result, milk)


N, M, H = map(int, input().split())
maps = []
milks = []

for _ in range(N):
    maps.append(list(map(int, input().split())))

for a in range(N):
    for b in range(N):
        if maps[a][b] == 1:
            i, j = a, b
        if maps[a][b] == 2:
            milks.append([a, b])

dfs(i, j, M, 0)
print(result)