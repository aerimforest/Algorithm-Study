import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)
n, m = map(int, input().split())
parent = [i for i in range(n + 1)] 

#부모를 찾기 (같은 부모인지 확인 용)
def find_parent(x):
    if parent[x] != x:
        parent[x] = find_parent(parent[x])
    return parent[x]

#부모를 찾은 후, 더 값이 작은쪽으로 부모를 바꿔줌
#합집합을 만듬
def union_parent(a, b):
    a = find_parent(a)
    b = find_parent(b)
    if a < b: 
        parent[b] = a
    else:
        parent[a] = b
        
for _ in range(m):
    opr, a, b = map(int, input().split())
    if opr == 0:
        union_parent(a, b)
    else:
        if find_parent(a) == find_parent(b):
            print("YES")
        else:
            print("NO")