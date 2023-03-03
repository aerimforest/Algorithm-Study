import sys
input = sys.stdin.readline

def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

n,m = map(int,input().split())
parent = [i for i in range(n)]
for i in range(1, m+1):
    u, v = map(int,input().split())
    if find(parent, u) != find(parent, v):
        union(parent, u, v)
    else:
        print(i)
        exit()
print(0)