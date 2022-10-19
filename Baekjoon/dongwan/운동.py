import sys 
import heapq 
input = sys.stdin.readline

v,e = map(int,input().split())
INF = 10e9

graph = [[] for _ in range(v+1)]

distance  = [[INF]*(v+1) for _ in range(v+1)]

heap = []

for _ in range(e) :

    r,c,cost = map(int,input().split())
    graph[r].append([cost,c])
    distance[r][c] = cost 

    heapq.heappush(heap,(cost,r,c))


while heap :

    cost,r, c = heapq.heappop(heap)
    if r == c :
        print(cost)
        break 
    
    if distance[r][c] < cost :
        continue

    for new,x in graph[c] :
        new_cost = cost + new 

        if new_cost < distance[r][x] :
            distance[r][x] = new_cost 
            heapq.heappush(heap,(new_cost,r,x))
else :
    print(-1)
# for _ in range(e) :

#     r,c,x = map(int,input().split())
#     graph[r][c] = x 


# # 경유지, 출발지, 도착지로 for문 

# for x in range(1,v+1) :
#     for r in range(1,v+1) :
#         for c in range(1,v+1) :
#             if graph[r][x] + graph[x][c] < graph[r][c] :
#                 graph[r][c] = graph[r][x] + graph[x][c]
# res = INF 
# for i in range(v+1) :

#     res = min(res,graph[i][i])

# if res == INF :
#     print(-1)
# else :
#     print(res)


