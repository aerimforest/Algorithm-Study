import sys, heapq
input = sys.stdin.readline

def find(parent: list[int], x: int) -> int:
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]


def union(parent: list[int], a: int, b: int) -> None:
    a = find(parent, a)
    b = find(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

p,w = map(int,input().split())
c,v = map(int,input().split()) # 시작 도착
parent = [i for i in range(p)]
h = []
route = []

for _ in range(w):
    st,ed,wid = map(int,input().split())
    heapq.heappush(h, [-wid,st,ed])

while h:
    wid, st, ed = heapq.heappop(h)
    wid = -wid
    # print("st:",st,"ed:",ed)
    if find(parent, st) != find(parent, ed):
        route.append(wid)
        union(parent, st, ed)

        if find(parent, c) == find(parent, v):
            # print("브레이크 걸림")
            break

print(min(route))
