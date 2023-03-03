import sys, heapq
input = sys.stdin.readline

V,E = map(int,input().split())
k=int(input())

graph=[[] for _ in range(V+1)]
for _ in range(E):
    e,v,w=map(int,input().split())
    graph[e].append([w,v])

def dijkstra(start):
    INF=1e9
    visited=[INF]*(V+1)
    visited[start]=0
    q=[[0,start]]
    while q:
        cost,node=heapq.heappop(q)
        if cost > visited[node]:
            continue
        for k,u in graph[node]:
            if visited[u] > visited[node]+k:
                visited[u] = visited[node]+k
                heapq.heappush(q,[visited[u], u])
    return visited[1:]

res = dijkstra(k)

for ans in res:
    print(ans if ans!=1e9 else 'INF')