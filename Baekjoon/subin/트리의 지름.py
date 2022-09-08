import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

ans = 0

def dfs(graph, root):
    global ans
    if len(graph[root]) == 0:
        return 0
    if len(graph[root]) == 1:
        node, weight = graph[root][0]
        return weight + dfs(graph, node)
    arr = [dfs(graph, node) + weight for (node, weight) in graph[root]]
    arr.sort(reverse=True)
    ans = max(ans, arr[0] + arr[1])
    return arr[0]


n = int(input())
graph = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    a, b, l = map(int, input().split())
    graph[a].append((b, l))

res = dfs(graph, 1)
print(max(res, ans))