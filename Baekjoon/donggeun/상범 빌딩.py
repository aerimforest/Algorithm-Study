import sys
from collections import deque

input = sys.stdin.readline

dx = [0,1,0,-1,0,0]
dy = [1,0,-1,0,0,0]
dz = [0,0,0,0,1,-1]

def bfs(l, r, c):
    queue = deque()
    queue.append((l,r,c))
    visited = [[[0]*C for _ in range(R)] for __ in range(L)]
    while queue:
        z,y,x = queue.popleft()
        if graph[z][y][x] == "E":
            return f"Escaped in {visited[z][y][x]} minute(s)."
        for i in range(6):
            nz = z + dz[i]
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 > nz or 0 > ny or 0 > nx or L <= nz or R <= ny or C <= nx:
                continue
            if graph[nz][ny][nx] == "#":
                continue
            if visited[nz][ny][nx] == 0:
                queue.append((nz,ny,nx))
                visited[nz][ny][nx] = visited[z][y][x] + 1
    return "Trapped!"

while True:
    L, R, C = map(int,input().split())
    if L+R+C == 0:
        break
    graph = []
    flag = False
    for _ in range(L):
        graph.append([list(map(str,input().rstrip())) for __ in range(R)])
        input()
    for i in range(L):
        for j in range(R):
            for k in range(C):
                if graph[i][j][k] == "S":
                    print(bfs(i,j,k))
                    flag = True
                    break
            if flag:
                break
        if flag:
            break