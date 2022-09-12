import sys
from heapq import heappush, heappop

INF = int(1e9)

input = lambda: sys.stdin.readline()


def dijkstra(start, end):
    queue = []
    heappush(queue, (0, start))
    distance[start] = 0

    while queue:
        dist, now = heappop(queue)

        if distance[now] < dist:
            continue

        for i in graph[now]:
            cost = dist + i[1]

            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heappush(queue, (cost, i[0]))

    return distance[end]


n, m = int(input()), int(input())

graph = [[] for _ in range(n + 1)]
distance = [INF] * (n + 1)

for _ in range(m):
    star_bus, end_bus, cost_bus = map(int, input().split())
    graph[star_bus].append([end_bus, cost_bus])

start_bus, end_bus = map(int, input().split())

print(dijkstra(start_bus, end_bus))
