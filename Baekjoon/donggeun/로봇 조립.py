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
        cnt[a] += cnt[b]
        cnt[b] = 0
    elif a > b:
        parent[a] = b
        cnt[b] += cnt[a]
        cnt[a] = 0

n = int(input())
parent = [i for i in range(10**6+1)]
cnt = [1 for _ in range(10**6+1)]
for _ in range(n):
    command = list(map(str,input().split()))
    if command[0] == "I":
        a,b = int(command[1]), int(command[2])
        if find(parent, a) != find(parent, b):
            union(parent, a, b)
    else:
        c = int(command[1])
        print(cnt[find(parent, c)])