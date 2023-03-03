# 1766 문제집
"""위상 정렬 알고리즘 기억을 되살리려고 
    조금은 쉬운 문제를 풀고 최종 순위를
    다시 풀려 했으나 최종 순위 풀이 방법이
    떠오르지 않았습니다..."""

# 3665번
import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n = int(input())
    nums = list(map(int,input().split()))
    graph = []
    m = int(input())
    for _ in range(m):
        a,b = map(int,input().split())
    
    for i in range(n-1):
        graph.append([nums[i], nums[i+1]])


# 1766번 풀이
import sys, heapq
input = sys.stdin.readline

def solve():
    n,m = map(int,input().split())
    edges = [0]*(n+1)
    graph = [[] for _ in range(n+1)]
    for _ in range(m):
        a,b = map(int,input().split())
        edges[b]+=1
        graph[a].append(b)
    topology(n, graph, edges)

def topology(n, graph, edges):
    ans = []
    h = []
    for i in range(1, n+1):
        if not edges[i]:
            heapq.heappush(h, i)

    while h:
        node = heapq.heappop(h)
        ans.append(node)
        for i in graph[node]:
            edges[i] -= 1
            if not edges[i]:
                heapq.heappush(h, i)
    print(*ans)

solve()