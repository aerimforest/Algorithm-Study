import sys, heapq
input = sys.stdin.readline

INF = int(1e9)
def dij_fox():
    distance = [INF]*(n+1)
    distance[1] = 0
    hq = []
    heapq.heappush(hq, (0,1))
    while hq:
        dist, now = heapq.heappop(hq)
        if distance[now] < dist:
            continue
        for nex,cost in graph[now]:
            if dist+cost<distance[nex]:
                distance[nex] = dist+cost
                heapq.heappush(hq, (cost+dist, nex))
    return distance[2:]

def dij_wolf():
    distance = [[INF]*(2) for _ in range(n+1)]
    distance[1] = [INF,0]
    hq = []
    heapq.heappush(hq, (0,1,1))
    while hq:
        dist, now, run = heapq.heappop(hq)
        if distance[now][run]!=dist:
            continue

        for nex, cost in graph[now]:
            if run==1 and distance[nex][0]>dist+(cost//2):
                distance[nex][0] = dist+(cost//2)
                heapq.heappush(hq, ((cost//2)+dist, nex,0))
            elif run==0 and distance[nex][1]>dist+(cost*2):
                distance[nex][1] = dist+(cost*2)
                heapq.heappush(hq, ((cost*2)+dist, nex, 1))
    return distance[2:]

def result(a,b):
    res = 0
    for i in range(n-1):
        if a[i]<min(b[i]):
            res += 1
    return res

n,m = map(int,input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    a,b,d = map(int,input().split())
    d*=2
    graph[a].append((b,d))
    graph[b].append((a,d))

fox = dij_fox()
wolf = dij_wolf() 

print(result(fox,wolf))