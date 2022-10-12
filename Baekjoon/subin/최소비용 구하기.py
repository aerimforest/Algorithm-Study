import sys
from collections import deque, defaultdict
input = sys.stdin.readline

def bfs(graph, s, e, costs):
    q = deque()
    q.append(s)
    costs[s] = 0

    while q:
        u = q.popleft()
        cost = costs[u]
        for v, vw in graph[u]:
            if costs[v] > cost + vw:
                costs[v] = cost + vw
                q.append(v)
    print(costs[e])

def init():
    graph = defaultdict(set)

    N = int(input())
    M = int(input())

    costs = [2**31] * (N+1)

    for i in range(M):
        u, v, w = map(int, input().split())
        graph[u].add((v, w))

    s, e = map(int, input().split())
    bfs(graph, s, e, costs)

init()