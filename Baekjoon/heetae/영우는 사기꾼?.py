import sys

n, m, k = map(int, sys.stdin.readline().split())

in_degree = [0] * (n + 1)
graph = [[] for i in range(n + 1)]
now = [0] * (n + 1)
check = False

for _ in range(m):
    x, y = map(int, sys.stdin.readline().split())
    graph[x].append(y)
    in_degree[y] += 1

for _ in range(k):
    n, a = map(int, sys.stdin.readline().split())
    if n == 1:
        if in_degree[a] != 0:
            check = True
            break
        else:
            now[a] += 1
            if now[a] == 1:
                for next in graph[a]:
                    in_degree[next] -= 1

    else:
        if now[a] <= 0:
            check = True
            break
        else:
            now[a] -= 1
            if now[a] == 0:
                for next in graph[a]:
                    in_degree[next] += 1

if check:
    print("Lier!")
else:
    print("King-God-Emperor")
