import sys
input = sys.stdin.readline

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a,b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a<b:
        parent[b] = a
    else:
        parent[a] = b

n = int(input())
m = int(input())
graph = [list(map(int,input().split())) for _ in range(n)]
nums = list(map(int,input().split()))

parent = [i for i in range(n)]
for i in range(n):
    for j in range(i+1):
        if graph[i][j] == 1:
            union_parent(parent, i, j)

pre = find_parent(parent, nums[0]-1)

for k in range(1,m):
    if find_parent(parent,nums[k]-1) != pre:
        print("NO")
        break
else:
    print("YES")