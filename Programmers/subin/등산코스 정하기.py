import heapq
from collections import defaultdict

def solution(n, paths, gates, summits):
    heap = []
    graph = defaultdict(list)
    for i, j, w in paths:
        graph[i].append((j, w))
        graph[j].append((i, w))


    INF = 123456789
    answer = [-1, INF]
    summits = set(summits)
    distance = [INF] * (n + 1)

    for gate in gates:
        heapq.heappush(heap, (0, gate))
        distance[gate] = 0

    while heap:
        dist, x = heapq.heappop(heap)

        if distance[x] < dist:
            continue

        if x in summits:
            if distance[x] < answer[1]:
                answer = [x, distance[x]]
            elif distance[x] == answer[1]:
                answer[0] = min(answer[0], x)
            continue

        for y, w in graph[x]:
            cost = max(w, dist)
            if distance[y] > cost:
                distance[y] = cost
                heapq.heappush(heap, (cost, y))

    return answer