from collections import deque

def bfs(m,n,h):
    dx,dy,dz=[-1,1,0,0,0,0],[0,0,1,-1,0,0],[0,0,0,0,1,-1]
    res=0

    queue=deque([])

    for i in range(h):
        for j in range(n):
            for k in range(m):
                if mat[i][j][k]==1:
                    queue.append([i,j,k])

    while queue:
        z,y,x=queue.popleft()

        for i in range(6):
            nx=x+dx[i]
            ny=y+dy[i]
            nz=z+dz[i]

            if 0<=nx<m and 0<=ny<n and 0<=nz<h and mat[nz][ny][nx]==0:
                mat[nz][ny][nx]=mat[z][y][x]+1
                queue.append([nz,ny,nx])

    for i in mat:
        for j in i:
            for k in j:
                if k==0:
                    return -1
                res=max(res,k)

    return res-1


M,N,H=map(int,input().split())

mat=[[list(map(int,input().split())) for _ in range(N)] for _ in range(H)]

print(bfs(M,N,H))