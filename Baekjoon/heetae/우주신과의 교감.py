import math
import sys

sys.setrecursionlimit(100000)
input = sys.stdin.readline


def find_parent(graph, n):
    if graph[n] != n:
        graph[n] = find_parent(graph, graph[n])
    return graph[n]


def union(graph, x, y):
    a = find_parent(graph, x)
    b = find_parent(graph, y)

    graph[max(a, b)] = min(a, b)


n, m = map(int, input().split())
g_loc = [0]
costs = []
graph = [i for i in range(n + 1)]
result = 0

for _ in range(n):
    x, y = map(int, input().split())
    g_loc.append((x, y))

for _ in range(m):
    god1, god2 = map(int, input().split())
    if find_parent(graph, god1) != find_parent(graph, god2):
        union(graph, god1, god2)

for i in range(1, n):
    for j in range(i + 1, n + 1):
        dis = math.sqrt((g_loc[i][0] - g_loc[j][0]) ** 2 + (g_loc[i][1] - g_loc[j][1]) ** 2)
        costs.append((dis, i, j))

costs.sort(key=lambda a: a[0])

for dis, x, y in costs:
    if find_parent(graph, x) != find_parent(graph, y):
        union(graph, x, y)
        result += dis

print("%0.2f" % result)
