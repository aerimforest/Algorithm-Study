from collections import deque, defaultdict
import sys
input = sys.stdin.readline

def is_two_or_more(order:list) -> bool:
    return order.count(max(order)) >= 2

t = int(input())
for _ in range(t):
    k,m,p = map(int,input().split())
    parent = [[] for _ in range(m+1)]
    graph = [[] for _ in range(m+1)]
    nums = defaultdict(int)
    deg = [0]*(m+1)
    ans = -1
    for __ in range(p):
        a,b = map(int,input().split())
        deg[b] += 1
        graph[a].append(b)
        parent[b].append(a)
        nums[a] = 1

    queue = deque()

    for i in range(1,m+1):
        if not deg[i]:
            queue.append([i,1]) # node, level

    for i in range(1,m+1):
        if not deg[i]:
            queue.append([i,1])

    while queue:
        node,lev = queue.popleft()
        ans = max(ans, lev)
        for i in graph[node]:
            deg[i] -= 1
            if deg[i] == 0:
                order = [nums[j] for j in parent[i]]
                if is_two_or_more(order):
                    nums[i] = max(order)+1
                    queue.append([i, max(order)+1])
                else:
                    nums[i] = max(order)
                    queue.append([i, lev])
    
    print(k,ans)