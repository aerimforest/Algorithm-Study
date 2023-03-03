from collections import deque
import sys
input = sys.stdin.readline

dx = [1,0,-1,0]
dy = [0,-1,0,1]

def solve(n:int, m:int) -> int:
    for i in range(n):
        for j in range(m):
            if graph[i][j] == "0":
                return bfs(i,j)

def bfs(py:int,px:int) -> int:
    visited[0][py][px] = True
    queue = deque()
    queue.append([py,px,0,0]) # y좌표, x좌표,cnt, key 리스트

    while queue:
        y,x,cnt,key = queue.popleft()
        
        if graph[y][x] == "1":
            return cnt
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= m or ny >= n:
                continue
            
            if not visited[key][ny][nx] and graph[ny][nx] != "#": # 벽이 아니고, 방문하지 않았다면
                
                if str(graph[ny][nx]).isupper(): # 문이 있다면
                    door = 1 << (ord(graph[ny][nx])-65) # 비트 마스킹으로 현재 있는 키와 비교
                    if (key&door) > 0: # 키 갖고 있으면 방문
                        visited[key][ny][nx] = True
                        queue.append([ny,nx,cnt+1, key])

                elif str(graph[ny][nx]).islower(): # 키가 있으면
                    new_key = 1 << (ord(graph[ny][nx])-97) # 키 추가
                    new_key = new_key | key

                    if not visited[new_key][ny][nx]:
                        visited[new_key][ny][nx] = True
                        visited[key][ny][nx] = True
                        queue.append([ny,nx,cnt+1,new_key])
                else:
                    visited[key][ny][nx] = True
                    queue.append([ny,nx,cnt+1,key])

    return -1

n,m = map(int,input().split())
graph = [list(map(str,input().rstrip())) for _ in range(n)]
visited = [[[False]*m for _ in range(n)] for _ in range(64)]

print(solve(n,m))