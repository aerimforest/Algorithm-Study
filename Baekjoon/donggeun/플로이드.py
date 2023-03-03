import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
INF = int(1e9)
graph = [[INF]*(n+1) for _ in range(n+1)]

for i in range(1, n+1):
    graph[i][i] = 0

for _ in range(m):
    a,b,c = map(int,input().split())
    graph[a][b] = min(c, graph[a][b])

for x in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            graph[i][j] = min(graph[i][j], graph[i][x]+graph[x][j])
    
for i in range(1, n+1):
    for j in range(1, n+1):
        print(graph[i][j] if graph[i][j] != INF else 0, end=' ')
    print()