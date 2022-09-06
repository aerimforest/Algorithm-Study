# 메모리 초과 - 플로이드 워셜

import sys

input = lambda: sys.stdin.readline()

n = int(input())
graph = [[int(1e9)] * (n + 1) for _ in range(n + 1)]

for x in range(1, n + 1):
    for y in range(1, n + 1):
        if x == y:
            graph[x][y] = 0

for _ in range(n - 1):
    parent, child, weight = map(int, input().split())

    graph[parent][child] = weight
    graph[child][parent] = weight

for k in range(1, n + 1):
    for x in range(1, n + 1):
        for y in range(1, n + 1):
            graph[x][y] = min(graph[x][y], graph[x][k] + graph[k][y])

answer = 0

for x in range(1, n + 1):
    for y in range(1, n + 1):
        answer = max(answer, graph[x][y])

print(answer)
