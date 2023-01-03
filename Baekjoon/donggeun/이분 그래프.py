from collections import deque
import sys
input = sys.stdin.readline

def bfs(start, visited):
    queue = deque([start])
    visited[start] = 1
    while queue:
        node = queue.popleft()
        for next in graph[node]:
            if visited[next] == 0:
                visited[next] = -visited[node]
                queue.append(next)
            elif visited[next] == visited[node]:
                return False
    return True

k = int(input())
for _ in range(k):
    V,E = map(int,input().split())
    graph = [[] for _ in range(V+1)]
    visited = [0] * (V+1)
    ans = "YES"
    for _ in range(E):
        u,v = map(int,input().split())
        graph[v].append(u)
        graph[u].append(v)
    for i in range(1, V+1):
        if visited[i] == 0:
            if not bfs(i, visited):
                ans = "NO"
                break
    print(ans)