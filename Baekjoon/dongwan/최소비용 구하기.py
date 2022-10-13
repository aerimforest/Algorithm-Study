def solution(x) :

    heap = []
    heapq.heappush(heap,(0,x))
    distance[x] = 0

    while heap :

        cost,x = heapq.heappop(heap)

        if distance[x] < cost :
            continue
        for nr,nc in grid[x] :
            new_cost = cost + nr 

            if distance[nc] > new_cost :
                heapq.heappush(heap,(new_cost,nc))
                distance[nc] = new_cost

import heapq
import sys

input = sys.stdin.readline

N = int(input())
M = int(input())

grid = [[] for _ in range(N+1)]
distance = [1e9]*(N+1)
for bus in range(M) :
    r,c,cost = map(int,input().split())

    grid[r].append((cost,c))


start,end = map(int,input().split())


solution(start)

print(visited[end])