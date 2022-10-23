import sys 

input = sys.stdin.readline

def find_parent(x) :
    if parent[x] != x :
        parent[x] = find_parent(parent[x])
    return parent[x]

def union_find(a,b) :
    a= find_parent(a)
    b= find_parent(b) 

    if a< b :
        parent[b] = a 
    else :
        parent[a] = b 


N = int(input())

M = int(input())
edges = []
result = 0
parent = [i for i in range(N+1)]

for _ in range(M) :
    a, b, cost = map(int,input().split())

    edges.append((cost,a,b))

edges.sort()

for edge in edges :
    cost, a,b = edge 
    
    if find_parent(a) != find_parent(b) :
        union_find(a,b)
        result += cost 

print(result )