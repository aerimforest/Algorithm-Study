import sys

sys.setrecursionlimit(100000)

n, m = map(int, sys.stdin.readline().rstrip().split())

graph = [i for i in range(n + 1)]


def find_parent(n):
    if graph[n] == n:
        return n
    graph[n] = find_parent(graph[n])
    return graph[n]


def union(graph, a, b):
    a = find_parent(a)
    b = find_parent(b)
    if a < b:
        graph[b] = a
    else:
        graph[a] = b


answer = []

for _ in range(m):
    check, a, b = map(int, sys.stdin.readline().rstrip().split())
    if check == 1:
        if find_parent(a) == find_parent(b):
            answer.append("YES")
        else:
            answer.append("NO")
    else:
        union(graph, a, b)

for i in answer:
    print(i)
