import sys
from collections import deque

input = lambda: sys.stdin.readline()


def bfs(start_node):
    visited = [False] * (n + 1)
    visited[start_node] = True

    queue = deque([(start_node, 0)])

    max_node, max_distance = 0, 0

    while queue:
        current_node, current_distance = queue.popleft()

        for node, distance in graph[current_node]:
            if not visited[node]:
                visited[node] = True
                queue.append((node, current_distance + distance))

                if max_distance < current_distance + distance:
                    max_node, max_distance = node, current_distance + distance

    return max_node, max_distance


n = int(input())
graph = [[] * (n + 1) for _ in range(n + 1)]

for _ in range(n - 1):
    parent, child, weight = map(int, input().split())

    graph[parent].append([child, weight])
    graph[child].append([parent, weight])

print(bfs(bfs(1)[0])[1])
