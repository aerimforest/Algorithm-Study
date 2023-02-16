from collections import deque
import sys
input = sys.stdin.readline

dx = [0,-1,0,1]
dy = [1,0,-1,0]

def bfs(x,y):
    queue = deque()
    queue.append([x,y])
    visited = [[0]*m for _ in range(n)]
    visited[y][x] = 1

    while queue:
        px,py = queue.popleft()
        
        for i in range(4):
            nx = dx[i] + px
            ny = dy[i] + py



n,m,t = map(int,input().split())
fan = [list(map(int,input().split())) for _ in range(n)]
rot = [list(map(int,input().split())) for _ in range(t)]