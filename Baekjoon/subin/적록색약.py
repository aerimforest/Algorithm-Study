from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
grid = [list(input().strip()) for _ in range(N)]
visited = [[[False] * N for _ in range(N)] for _ in range(2)]
answer = [0, 0]

def bfs(start, visited, st):
    queue = deque([start])
    dy = [0,1,0,-1]
    dx = [-1,0,1,0]

    while queue:
        y,x = queue.popleft()
        for i in range(4):
            ny, nx = y+dy[i], x+dx[i]
            if 0<=ny<N and 0<=nx<N and not visited[ny][nx]:
                if st[grid[y][x]] == st[grid[ny][nx]]:
                    queue.append((ny,nx))
                    visited[ny][nx] = True
    return 1

for i in range(N):
    for j in range(N):
        if not visited[0][i][j]:
            answer[0] += bfs((i,j), visited[0], {'R':0,'G':1,'B':2})
        if not visited[1][i][j]:
            answer[1] += bfs((i,j), visited[1], {'R':0,'G':0,'B':2})

print(answer[0], answer[1])