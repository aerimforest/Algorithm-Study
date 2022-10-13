import heapq


#시작,도착,지름길의 길이 
INF = int(1e9)

def solution(x) :
    heap = []
    heapq.heappush(heap,(0,x))
    distance[x] = 0 

    while heap :
        cost,now = heapq.heappop(heap)

        if cost > distance[now] :
            continue
        for i in graph[now] :
            new_cost = cost + i[0]
            if new_cost < distance[i[1]] :
                distance[i[1]] = new_cost 

                heapq.heappush(heap,(new_cost,i[1]))


#지름길, 고속도로 길이
start = 0
N,end = map(int,input().split())
graph = [[] for _ in range(end+1)]

distance = [INF] * (end+1)

for i in range(end) :
    graph[i].append((1,i+1))

for _ in range(N) :
    s,e,l = map(int,input().split())

    if e > end :
        continue
    graph[s].append((l,e))

solution(0)

print(distance[end])