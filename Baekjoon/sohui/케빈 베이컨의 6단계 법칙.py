from collections import deque

people, nodes = map(int, input().split())
graph = [[] for _ in range(people + 1)]

solution = []

for i in range(nodes):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(len(graph)):
    graph[i].sort(reverse=False)

visited = [False] * (people + 1)

def bfs(graph, start):
    num = [0] * (people + 1)
    q = deque()
    visited[start] = 1
    q.append(start)
    while q:
        a = q.popleft()
        for i in graph[a]:
            if visited[i] == 0:
                num[i] = num[a] + 1
                q.append(i)
                visited[i] = 1
    return sum(num)


result = []
for i in range(1, people + 1):
    visited = [0 for _ in range(people + 1)]
    result.append(bfs(graph, i))
print(result.index(min(result)) + 1)
