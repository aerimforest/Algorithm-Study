
from sys import setrecursionlimit
setrecursionlimit(10**9)

def dfs(r,c) :

    if visited[r][c] : 
        return visited[r][c] 
    visited[r][c]  =1 

    for d in range(4) :
        nr = r + dr[d]
        nc = c + dc[d]

        if 0<=nr< N and 0<=nc<N and grid[r][c] < grid[nr][nc] :

            visited[r][c] = max(visited[r][c],dfs(nr,nc)+1)
    
    return visited[r][c]

N = int(input())

dr = [1,0,-1,0]
dc = [0,1,0,-1]
grid = [list(map(int,input().split())) for _ in range(N)]
visited= [[0]*N for _ in range(N)]
res = 0 

for r in range(N) :
    for c in range(N) :
        # for i in visited :
        #     print(i)
        # print('---------------')
        res = max(res,dfs(r,c))

print(res)