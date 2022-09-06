import sys
input = lambda : sys.stdin.readline().strip()

sys.setrecursionlimit(10005)

n = int(input())
graph = [[] for _ in range(n+1)]


def dfs(x, wei):
    for i in graph[x]:
        a, b = i
        if distance[a] == -1:
            distance[a] = wei + b
            dfs(a, wei + b)


for _ in range(n-1):
    a, b, c = map(int, input().split())
    graph[a].append([b, c])
    graph[b].append([a, c])

# 루트에서 가장 먼 노드 찾기
distance = [-1] * (n+1)
distance[1] = 0
dfs(1, 0)

start = distance.index(max(distance))
distance = [-1] * (n+1)
distance[start] = 0
dfs(start, 0)

print(max(distance))
