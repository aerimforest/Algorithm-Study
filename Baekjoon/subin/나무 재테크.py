from collections import deque
import sys


input = sys.stdin.readline

n, m, k = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]
land = [[5] * n for _ in range(n)]
trees = [[deque() for _ in range(n)] for _ in range(n)]
dx, dy = (-1, -1, -1, 0, 0, 1, 1, 1), (-1, 0, 1, -1, 1, -1, 0, 1)

for _ in range(m):
    x, y, z = map(int, input().split())
    trees[x - 1][y - 1].append(z)


def spring_summer():
    for i in range(n):
        for j in range(n):
            for k in range(len(trees[i][j])):
                if trees[i][j][k] <= land[i][j]:
                    land[i][j] -= trees[i][j][k]
                    trees[i][j][k] += 1
                else:
                    for _ in range(k, len(trees[i][j])):
                        land[i][j] += trees[i][j].pop() // 2
                    break


def fall_winter():
    for x in range(n):
        for y in range(n):
            for k in range(len(trees[x][y])):
                if trees[x][y][k] % 5 == 0:
                    for d in range(8):
                        nx, ny, = x + dx[d], y + dy[d]
                        if 0 <= nx < n and 0 <= ny < n:
                            trees[nx][ny].appendleft(1)
            land[x][y] += a[x][y]


for _ in range(k):
    spring_summer()
    fall_winter()

ans = 0
for i in range(n):
    for j in range(n):
        ans += len(trees[i][j])

print(ans)