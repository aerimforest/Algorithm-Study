import sys,heapq
input = sys.stdin.readline
INF = int(1e9)

v,e,x = map(int,input().rstrip().split())
go_graph = [[] for _ in range(v+1)]
back_graph = [[] for _ in range(v+1)]

for _ in range(e):
    a,b,dis = map(int,input().rstrip().split())
    go_graph[a].append([b,dis])
    back_graph[b].append([a,dis])

def dijkstra(start,graph):
    q = []
    distance = [INF]*(v+1)

    heapq.heappush(q, [0,start])
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue

        for node_index, node_cost in graph[now]:
            cost = dist + node_cost
            if distance[node_index] > cost:
                distance[node_index] = cost
                heapq.heappush(q, (cost, node_index))
    return distance

result = 0
go = dijkstra(x,go_graph)
back= dijkstra(x,back_graph)
for i in range(1, v + 1):
    if result < go[i]+back[i]:
        result = go[i]+back[i]

print(result)