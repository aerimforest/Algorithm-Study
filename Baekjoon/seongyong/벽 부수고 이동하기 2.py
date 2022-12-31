from collections import deque
q = deque()
from sys import stdin
input = stdin.readline

n,m,k = map(int, input().split())
vis = [[[0]*(k+1) for _ in range(m)] for __ in range(n)]
arr = [list(map(int,input().strip())) for _ in range(n)]
dx = [1,0,-1,0]
dy = [0,1,0,-1]

def bfs() :
    q.append([0,0,k]) # k는 벽을 뚫을 수 있는 수
    vis[0][0][k] = 1
    while q :
        x,y,z = q.popleft()
        if x == n-1 and y == m-1 :
            return vis[x][y][z]
        for i in range(4) :
            nx ,ny = dx[i] + x, dy[i]+y
            if 0<=nx<n and 0<=ny<m :
                if arr[nx][ny]==1 and z>0 and vis[nx][ny][z-1]==0:
                    vis[nx][ny][z-1] = vis[x][y][z]+1
                    q.append([nx,ny,z-1])
                elif arr[nx][ny]==0 and vis[nx][ny][z]==0:
                    vis[nx][ny][z] = vis[x][y][z]+1
                    q.append([nx,ny,z]) 
    return -1

print(bfs())
