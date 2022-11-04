from collections import deque
m,n = map(int,input().split())

grid = [list(map(int,input())) for _ in range(n)]

res = 10e9
q = deque([(0,0)])

dr = [1,0,-1,0]
dc = [0,1,0,-1]
dist = [[-1]*m for _ in range(n)]
dist[0][0] = 0
while q :
    cr,cc = q.popleft()

    for d in range(4) :
        nr = cr + dr[d]
        nc = cc + dc[d]
        if 0<=nr<n and 0<=nc<m  :
            if dist[nr][nc] == -1 :

                if grid[nr][nc] :
                    dist[nr][nc] = dist[cr][cc] + 1
                    q.append((nr,nc))
                else :
                    dist[nr][nc] = dist[cr][cc]
                    q.appendleft((nr,nc))

            

print(dist[n-1][m-1])