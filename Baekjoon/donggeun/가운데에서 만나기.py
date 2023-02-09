import sys, heapq
from collections import defaultdict
input = sys.stdin.readline
INF = int(1e9)

n,m = map(int,input().split())
graph = [[INF]*(n+1) for _ in range(n+1)]
for _ in range(m):
    a,b,t = map(int,input().split())
    graph[a][b] = t

for x in range(1, n+1):
    graph[x][x] = 0

    for i in range(1, n+1):
        for j in range(1, n+1):
            if graph[i][x] + graph[x][j] < graph[i][j]:
                graph[i][j] = graph[i][x] + graph[x][j]


k = int(input())
crew = list(map(int,input().split()))
ans = defaultdict(list)
for x in range(1, n+1):
    tmp = []
    for c in crew:
        tmp.append(graph[c][x] + graph[x][c])
    ans[max(tmp)].append(x)

print(*ans[min(ans.keys())])