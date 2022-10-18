import sys
input = sys.stdin.readline
from collections import deque, defaultdict

N, M = map(int, input().split())
indegree = [0] * (N+1)
graph = defaultdict(list)

for i in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)
    indegree[B] += 1

def topology_sort():
    result = []
    queue = deque()
    for i in range(1, N+1):
        if indegree[i] == 0:
            queue.append(i)
    while queue:
        now = queue.popleft()
        result.append(now)
        for i in graph[now]:
            indegree[i] -= 1
            if indegree[i] == 0:
                queue.append(i)
    for i in result:
        print(i, end=" ")

topology_sort()