def solution(x) :

    heap = []
    heapq.heappush(heap,(0,x))
    visited[x] = 0

    while heap :

        cost,x = heapq.heappop(heap)

        if visited[x] < cost :
            continue
        for nr,nc in grid[x] :
            new_cost = cost + nr 

            if visited[nc] > new_cost :
                heapq.heappush(heap,(new_cost,nc))
                visited[nc] = new_cost

import heapq
import sys

input = sys.stdin.readline

N = int(input())
M = int(input())

grid = [[] for _ in range(N+1)]
visited = [10e9]*(N+1)
for bus in range(M) :
    r,c,cost = map(int,input().split())

    grid[r].append((cost,c))


start,end = map(int,input().split())


solution(start)

print(visited[end])