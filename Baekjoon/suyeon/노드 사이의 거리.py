# 시간 초과!

import sys

input = lambda: sys.stdin.readline()

INF = int(1e9)

n, m = map(int, input().split())

graph = [[INF] * (n + 1) for _ in range(n + 1)]

for a in range(1, n + 1):
    for b in range(1, n + 1):
        if a == b:
            graph[a][b] = 0

for _ in range(n - 1):
    a, b, distance = map(int, input().split())

    graph[a][b] = distance
    graph[b][a] = distance

for k in range(1, n + 1):
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

for _ in range(m):
    a, b = map(int, input().split())

    print(graph[a][b])
