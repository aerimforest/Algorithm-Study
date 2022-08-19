import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
graph = {x+1:[] for x in range(N)}
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def count(i, j):
    d = deque([(i, 0)])
    visit = [False] * (N+1)
    visit[i] = True
    while d:
        x, cnt = d.popleft()
        for y in graph[x]:
            if not visit[y]:
                if y == j:
                    return cnt+1
                d.append((y, cnt+1))
                visit[y] = True

ans, minm = 0, 1e10
for i in range(1, N+1):
    temp = 0
    for j in range(1, N+1):
        if i != j:
            temp += count(i, j)
    if temp < minm:
        minm = temp
        ans = i
print(ans)