import heapq

def dijkstra(start, road, distance):
    distance[start] = 0
    q = []
    heapq.heappush(q, (0, start))
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for x in road:
            if x[0] == now:
                cost = dist + x[2]
                next = x[1]
                if cost < distance[next]:
                    distance[next] = cost
                    heapq.heappush(q, (cost, next))
            elif x[1] == now:
                cost = dist + x[2]
                prev = x[0]
                if cost < distance[prev]:
                    distance[prev] = cost
                    heapq.heappush(q, (cost, prev))
    return distance

def solution(N, road, K):
    answer = 0
    start = 1
    distance = [int(1e9)] * (N + 1)
    dijkstra(start, road, distance)
    for x in distance:
        if x <= K:
            answer += 1
    return answer