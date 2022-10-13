import heapq


#시작,도착,지름길의 길이 
INF = int(1e9)

def solution(x) :
    heap = []
    heapq.heappush(heap,(0,x))
    distance[x] = 0 

    while heap :
        dist,now = heapq.heappop(heap)

        if dist > distance[now] :
            continue
        for i in graph[now] :
            cost = dist + i[1]
            if cost < distance[i[0]] :
                distance[i[0]] = cost 

                heapq.heappush(heap,(cost,i[0]))


#지름길, 고속도로 길이
start = 0
N,end = map(int,input().split())
graph = [[] for _ in range(end+1)]

distance = [INF] * (end+1)

for i in range(end) :
    graph[i].append((i+1,1))

for _ in range(N) :
    s,e,l = map(int,input().split())

    if e > end :
        continue
    graph[s].append((e,l))

solution(0)

print(distance[end])