from collections import deque
import sys
input = sys.stdin.readline

dx = [-1,0,1,0]
dy = [0,-1,0,1]

def can_eat(x,y,size):
    res = []
    tmp = []
    for fx,fy in fishes:
        if graph[fx][fy] < size:
            tmp.append([fx,fy])

    if not tmp:
        return [-1,-1]

    for fx,fy in tmp:
        dist = abs(fx-x) + abs(fy-y)
        res.append([dist, fx,fy])

    res.sort(key=lambda x:(x[0],x[1],x[2]))
    return [res[0][1], res[0][2]]

def bfs(a,b):
    visited = [[False]*(n) for _ in range(n)]
    visited[a][b] = True
    queue = deque()
    queue.append([a,b,0,2,0]) # x,y,cnt,size,먹은 횟수
    
    while queue:
        x,y,cnt,size,eat = queue.popleft()

        des = can_eat(x,y,size)
        # 더이상 먹을 게 없다.
        if sum(des) == -2:
            return cnt
        des_x,des_y = des[0], des[1]
       
        if x == des_x and y == des_y:
            graph[x][y] = 0 # 물고기 먹음
            fishes.remove([x,y])
            eat += 1

            if eat == size: # 성장
                eat = 0
                size += 1

            # 물고기 야미하고 방문한거 다시 초기화
            visited = [[False]*(n) for _ in range(n)]

        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            if graph[nx][ny] <= size and not visited[nx][ny]:
                queue.append([nx,ny,cnt+1,size,eat])
                visited[nx][ny] = True


n = int(input())
graph = [list(map(int,input().split())) for _ in range(n)]

shark = []
# 피쉬는 lambda 사용해서 정렬한 뒤 가면 될듯 x[0],x[1]
fishes = []

for i in range(n):
    for j in range(n):
        if graph[i][j] == 9:
            shark = [i,j]
        elif graph[i][j] != 0:
            fishes.append([i,j])

print(bfs(shark[0],shark[1]))