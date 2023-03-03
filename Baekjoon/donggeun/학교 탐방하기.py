import sys, heapq
input = sys.stdin.readline

def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]


def union(parent, a, b):
    a = parent[a]
    b = parent[b]

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


n,m = map(int,input().split())
min_h = []
max_h = []

min_cnt = 0
max_cnt = 0
parent = [i for i in range(n+1)]
st,one,road = map(int,input().split())

if not road: # 오르막길이라면
    min_cnt += 1
    max_cnt += 1


union(parent, st, one)

for _ in range(m):
    a,b,c = map(int,input().split())
    heapq.heappush(max_h, [-c,a,b]) # 내리막길 순으로 정렬 내리막길 -1, 오르막길 0
    heapq.heappush(min_h, [c,a,b]) # 오르막길 우선 담김 

edges = 0
while min_h:
    c,a,b = heapq.heappop(min_h)
    if find(parent, a) != find(parent, b):
        union(parent, a, b)
        edges += 1
        if not c: # 1이 아니라면, 즉 오르막길이라면
            min_cnt += 1

        if edges == n-1:
            break
            
parent = [i for i in range(n+1)]
union(parent, st, one)

edges = 0
while max_h:
    c,a,b = heapq.heappop(max_h)
    if find(parent, a) != find(parent, b):
        union(parent, a, b)
        edges += 1
        if c == 0:
            max_cnt += 1
        if edges == n-1:
            break

print(min_cnt**2 - max_cnt**2)