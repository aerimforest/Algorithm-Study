import sys
import heapq

INF = float('inf')
V, E = map(int, sys.stdin.readline().split())
K = int(sys.stdin.readline())
graph = [[] for _ in range(V + 1)]

answer = [INF] * (V + 1)
queue = []

for i in range(E):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append([v, w])

def dijkstra(start):
    answer[start] = 0 
    heapq.heappush(queue, [0, start]) 

    while queue:
        current_w, current_node = heapq.heappop(queue)

        if answer[current_node] < current_w:
            continue

        for next_node, weight in graph[current_node]:
            next_w = current_w + weight

            if next_w < answer[next_node]:
                answer[next_node] = next_w
                heapq.heappush(queue, [next_w, next_node])

dijkstra(K)

for i in answer[1:]:
    print(i if i != INF else "INF")