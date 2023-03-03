from collections import deque
import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n,k = map(int,input().split())
    time = [0] + list(map(int,input().split()))

    deg = [0] * (n + 1)
    graph = [[] for __ in range(n + 1)]
    
    for __ in range(k):
        x,y = map(int,input().split())
        deg[y] += 1
        graph[x].append(y)
    
    w = int(input())

    queue = deque()
    for i in range(1, n+1):
        if not deg[i]:
            queue.append(i)
    
    work = [0] * (n+1)

    while queue:
        node = queue.popleft()
        work[node] += time[node]

        if node == w:
            print(work[w])
            break

        for nex in graph[node]:
            deg[nex] -= 1
            work[nex] = max(work[nex], work[node])

            if not deg[nex]:
                queue.append(nex)
    
