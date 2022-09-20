import sys
from collections import deque

input = lambda: sys.stdin.readline()


def bfs(start_node, end_node):
    visited = [False] * (n + 1)
    visited[start_node] = True

    queue = deque([(start_node, 0)])

    while queue:
        current_node, current_distance = queue.popleft()

        if current_node == end_node:
            return current_distance

        for node, distance in graph[current_node]:
            if not visited[node]:
                visited[node] = True
                queue.append((node, current_distance + distance))


n, m = map(int, input().split())

graph = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    a, b, c = map(int, input().split())

    graph[a].append([b, c])
    graph[b].append([a, c])

for _ in range(m):
    a, b = map(int, input().split())

    print(bfs(a, b))
