from itertools import combinations
from collections import deque
import sys
input = sys.stdin.readline

dx = [0,1,0,-1]
dy = [1,0,-1,0]
INF = int(1e9)

def bfs(queue: deque[int,int,int]) -> None:
    while queue:
        x,y,cnt = queue.popleft()
        # visited[y][x] = cnt
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y

            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            
            if visited[ny][nx] == -1 and board[ny][nx] != 1:
                queue.append([nx,ny,cnt+1])
                visited[ny][nx] = cnt+1
    # return visited

def get_time(lis: list[list]) -> int:
    # lis 는 빈곳만 확인함. 
    # 바이러스랑 벽은 포함되어 있지 않음
    time = [0]
    for x,y in lis:
        if visited[y][x] != -1:
            time.append(visited[y][x])
        else: # 방문 못한 곳이 있다면
            return INF
    # 가장 오래 걸린 곳
    return max(time)

n,m = map(int,input().split())

board = [list(map(int,input().split())) for _ in range(n)]

candidate = []
ans = []
empty = []

for i in range(n):
    for j in range(n):
        if board[i][j] == 2:
            candidate.append([j,i])
        elif board[i][j] == 0:
            empty.append([j,i])

for candi in combinations(candidate, m):
    visited = [[-1]*n for _ in range(n)]
    queue = deque()
    for k in candi:
        x,y = k
        visited[y][x] = 0
        queue.append([x,y,0])

    bfs(queue)

    ans.append(get_time(empty))

print(min(ans) if min(ans) != INF else -1)