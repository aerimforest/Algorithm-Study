import sys, heapq
input = sys.stdin.readline
INF = int(1e9)

def dijkstra(start, n, graph):
    distance = [INF]*(n+1)
    distance[start] = 0
    pq = []
    heapq.heappush(pq, (0, start))
    while pq:
        dist, now = heapq.heappop(pq)
        if distance[now] < dist:
            continue
        
        for next, cost in graph[now]:
            if cost + dist < distance[next]:
                distance[next] = cost + dist
                heapq.heappush(pq, (cost+dist, next))

    return distance

def solve():
    n = int(input())
    a,b,c = map(int,input().split())
    graph = [[] for _ in range(n+1)]
    m = int(input())
    ans = 0

    for _ in range(m):
        u,v,w = map(int,input().split())
        graph[u].append((v,w))
        graph[v].append((u,w))

    a_dist = dijkstra(a,n,graph)
    b_dist = dijkstra(b,n,graph)
    c_dist = dijkstra(c,n,graph)

    ans = [0]
    for i in range(1, n+1):
        ans.append(min(a_dist[i], b_dist[i], c_dist[i]))
    print(ans.index(max(ans)))

solve()