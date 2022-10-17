import sys 
import heapq
input =sys.stdin.readline

cnt = 1

dr = [0,1,0,-1]
dc = [1,0,-1,0]
INF = int(1e9)


def dijkstra() :

    heap = []
    heapq.heappush(heap,(graph[0][0],0,0))
    distance[0][0] = 0 

    while heap :
        cost,r,c = heapq.heappop(heap)

        if r == N-1 and c == N-1 :
            print(f'Problem {cnt}: {distance[r][c]}')
            return
        for d in range(4) :
            nr = r + dr[d]
            nc = c + dc[d]

            if 0<= nr <N and 0<=nc<N :
                new_cost = cost + graph[nr][nc]

                if new_cost < distance[nr][nc] :
                    distance[nr][nc] = new_cost 
                    heapq.heappush(heap,(new_cost,nr,nc))

while True :
    N = int(input()) 
    if N == 0 : break 

    graph = [list(map(int,input().split())) for _ in range(N)] 
    distance = [[INF]*N for _ in range(N)]

    dijkstra()

    cnt+= 1