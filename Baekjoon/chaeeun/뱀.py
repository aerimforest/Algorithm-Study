# (참고)

from collections import deque

def direction_change(d, c): ## 방향 바꾸는 함수
    if c == "L":
        d = (d - 1) % 4
    else:
        d = (d + 1) % 4
    return d

### input
N = int(input()) ## 보드의 크기
K = int(input()) ## 사과의 개수

board = [[0] * N for _ in range(N)] ## 보드 만들기

for _ in range(K):
    a, b = map(int, input().split()) ## 사과의 위치 정보
    board[a - 1][b - 1] = 1  

L = int(input()) ## 뱀의 방향 변환 횟수
times = {}
for i in range(L):
    X, C = input().split() ## 뱀의 방향 변환 정보
    times[int(X)] = C
### input
  
dy = [-1, 0, 1, 0] ## y 방향 인덱스로 접근
dx = [0, 1, 0, -1] ## x 방향 인덱스로 접근

direction = 1 
time = 1  
y, x = 0, 0  
snake = deque([[y, x]]) 
board[y][x] = 2

while True:
    y, x = y + dy[direction], x + dx[direction]
    if 0 <= y < N and 0 <= x < N and board[y][x] != 2:
        if not board[y][x] == 1:
            del_y, del_x = snake.popleft()
            board[del_y][del_x] = 0 
        board[y][x] = 2
        snake.append([y, x])
        if time in times.keys():
            direction = direction_change(direction, times[time])
        time += 1
    else: 
        break

### output
print(time)
### output