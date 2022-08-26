from collections import deque

col, row = map(int,input().split())

maps = [[0] * (col+2) for _ in range(row+2)]
for i in range(row):
    maps[i+1][1:col+1] = map(int,input().split())

odd_x = [-1,0,1,1,0,-1]
odd_y = [0,-1,0,1,1,1]

even_x = [-1,0,1,1,0,-1]
even_y = [-1,-1,-1,0,1,0]

visited = [[0] * (col+2) for _ in range(row+2)]
answer = 0
def bfs():
    global answer
    q = deque()
    q.append((0,0))
    visited[0][0] = 1
    while q:
        x, y = q.popleft()

        for i in range(6):
            nx = 0
            ny = 0
            if x % 2:
                nx = x + odd_x[i]
                ny = y + odd_y[i]
            else:
                nx = x + even_x[i]
                ny = y + even_y[i]
            if 0<= nx < row+2 and 0 <= ny < col+2:
                if maps[nx][ny] == 1:
                    answer += 1
                else:
                    if visited[nx][ny] == 0:
                        q.append((nx,ny))
                        visited[nx][ny] = 1

bfs()
print(answer)