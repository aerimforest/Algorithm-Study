import sys
input = sys.stdin.readline

def dfs(x):
    if not visited[graph[x]]:
        visited[graph[x]] = True
        dfs(graph[x])

t = int(input())
for _ in range(t):
    ans = 0
    n = int(input())
    nums = list(map(int,input().split()))
    graph = [-1]
    for i in range(n):
        graph.append(nums[i])

    for x in range(1, n+1):
        visited = [False]*(n+1)
        dfs(x)
        if not visited[x]:
            ans += 1
    print(ans)