import heapq, sys
input = sys.stdin.readline

def dijkstra(start,end):
    INF = int(1e9)
    distance = [INF]*(n+1)
    distance[start] = 0
    global root
    h = []
    heapq.heappush(h,(start,0))
    while h:
        node, dist = heapq.heappop(h)
        if distance[node] < dist:
            continue

        for u,v in graph[node]:
            if dist+v < distance[u]:
                root[u] = node
                distance[u] = dist+v
                heapq.heappush(h, (u, dist+v))
    return distance[end]

def dfs(start):
    global route
    if start:
        route.append(start)
        dfs(root[start])

n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]
root = [None]*(n+1)
route = []
for _ in range(m):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))

start, end= map(int,input().split())

print(dijkstra(start, end))
dfs(end)
print(len(route))
print(*reversed(route))