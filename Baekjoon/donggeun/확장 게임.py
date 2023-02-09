from collections import deque
import sys
input = sys.stdin.readline

dx = [1,0,-1,0]
dy = [0,-1,0,1]

n,m,p = map(int,input().split())
move = list(map(int,input().split()))
tot = n*m
fill = 0
ans = dict()

def bfs(p:int, q: deque) -> deque:
    res = deque()
    while q:
        y,x,cnt = q.popleft()
        if cnt >= move[p-1]:
            res.append([y,x,0])
            continue
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y

            if 0 > nx or 0 > ny or nx >= m or ny >= n:
                continue

            if not visited[ny][nx] and board[ny][nx] == ".":
                global fill
                fill += 1
                q.append([ny,nx,cnt+1])
                visited[ny][nx] = p
    
    return res
        
board = [list(map(str,input().rstrip())) for _ in range(n)]
visited = [[0]*(m) for _ in range(n)]

queue_dict = dict()
for i in range(1, p+1):
    queue_dict[i] = deque()
    ans[i] = 0

for i in range(n):
    for j in range(m):
        if board[i][j].isnumeric():
            fill += 1
            visited[i][j] = int(board[i][j])
            queue_dict[int(board[i][j])].append([i,j,0])
        elif board[i][j] == "#":
            fill += 1


while fill < tot:
    for i in range(1, p+1):
        queue_dict[i] = bfs(i, queue_dict[i])

for i in range(n):
    for j in range(m):
        if visited[i][j]:
            ans[visited[i][j]] += 1

print(*ans.values())