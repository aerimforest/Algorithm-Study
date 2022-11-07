from collections import deque
n,m = map(int,input().split())
grid = [list(map(int,input())) for _ in range(n)]

q = deque()
vistied = [[0]*m for _ in range(n)]

for i in range(m) :
    if not grid[0][i] :
        q.append((0,i))
        vistied[0][i] = 1 

dr = [0,1,0,-1]
dc = [1,0,-1,0]
while q :

    cr,cc = q.popleft()
    if cr == n-1 :
        print('YES')
        break
    for d in range(4) :

        nr = cr+dr[d]
        nc = cc+dc[d]

        if 0<=nr<n and 0<=nc<m and not vistied[nr][nc] and not grid[nr][nc] :
            vistied[nr][nc] = 1 
            q.append((nr,nc))
else :
    print('NO')