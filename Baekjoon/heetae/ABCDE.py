import sys

input = sys.stdin.readline

finished = False
visited = [False] * 2001

n, m = map(int, input().split())
f = [[] for _ in range(n)]
for i in range(m):
    a, b = map(int, input().split())
    f[a].append(b)
    f[b].append(a)


def dfs(here, depth):
    global finished

    visited[here] = True
    if depth == 4:
        finished = True
        return
    for i in f[here]:
        if not visited[i]:
            dfs(i, depth + 1)
            visited[i] = False


for i in range(n):
    dfs(i, 0)
    visited[i] = False
    if finished:
        break
if finished:
    print(1)
else:
    print(0)
