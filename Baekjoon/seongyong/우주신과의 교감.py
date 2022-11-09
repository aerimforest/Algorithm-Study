import sys
input = sys.stdin.readline
def find(c):
	if par[c] == c:
		return c
	else:
		par[c] = find(par[c])
	return par[c]
 
def union(a, b):
	a, b = find(a), find(b)
	par[max(a, b)] = min(a, b)
 
def check(a, b):
	return find(a) == find(b)
 
# a통로와 b통로의 거리를 구하는 함수
def dist(a, b):
	return ((a[0] - b[0])**2 + (a[1] - b[1])**2)**(1/2)
 
N, M = map(int,input().split())
par = [i for i in range(N)]
coordinate, graph = [], []
answer = 0
for _ in range(N):
	x, y = map(int,input().split())
	coordinate.append((x,y))
# 이미 연결되어 있는 통로 union해주기
for _ in range(M):
	x, y = map(int,input().split())
	union(x-1, y-1)
 
# 각 통로들 사이의 거리를 구해서 graph에 넣는 과정
for i in range(N-1):
	for j in range(i+1, N):
		graph.append((i, j, dist(coordinate[i], coordinate[j])))
# 거리순으로 오름차순 정렬
graph.sort(key= lambda x: x[2])
for i in graph:
	if not check(i[0], i[1]):
		union(i[0], i[1])
		answer += i[2]
print('%.2f' %(answer))
