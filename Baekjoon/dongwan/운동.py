import sys 
import heapq 
input = sys.stdin.readline

v,e = map(int,input().split())
INF = 10e9
graph = [[INF]*(v+1) for _ in range(v+1)]


rst = []
cst = []
xst = []
for _ in range(e) :

    r,c,x = map(int,input().split())
    graph[r][c] = x 


# 경유지, 출발지, 도착지로 for문 

for x in range(1,v+1) :
    for r in range(1,v+1) :
        for c in range(1,v+1) :
            if graph[r][x] + graph[x][c] < graph[r][c] :
                graph[r][c] = graph[r][x] + graph[x][c]
res = INF 

for i in range(v+1) :

    res = min(res,graph[r][c])

if res == INF :
    print(-1)
else :
    print(res)