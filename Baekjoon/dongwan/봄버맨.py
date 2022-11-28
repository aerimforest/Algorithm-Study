import sys 
from collections import deque
input =sys.stdin.readline
R,C,n = map(int,input().split())
grid = [list(input().rstrip()) for _ in range(R)]
if n == 1: 
    for row in grid:
        print(''.join(row))
    sys.exit()
if n %2 == 0 :
    for _ in range(R) :
        print('O'*C)
    sys.exit()
dr = [1,0,-1,0]
dc = [0,1,0,-1]
q = deque()

for r in range(R):
    for c in range(C):
        if grid[r][c] == 'O':
            q.append((r,c))
def bfs(q,grid):
    while q:
        r,c = q.popleft()
        grid[r][c] = '.'
        for d in range(4):
            nr,nc = r+dr[d],c+dc[d]
            if 0<=nr<R and 0<=nc<C and grid[nr][nc]=='O':
                grid[nr][nc] = '.'

#초기에는 3초에 터질 폭탄들을 Q에 수집한다. 
def simulate(time):
    global grid, q

    #2의 배수가 아닐 때는 수집된 폭탄들이 3초가 지났기 때문에 주변까지 폭발시키고 다시 터질 폭탄을 수집한다. 
    if time % 2:
        bfs(q,grid)
        for r in range(R):
            for c in range(C):
                if grid[r][c] == 'O':
                    q.append((r,c))
    #2의 배수일 때는 모든 곳에 폭탄을 설치한다.
    else:
        grid = [['O']*C for _ in range(R)]

#0에 폭탄 수집 
#2에 폭탄 채우기 
#3에 0에서 수집한 폭탄 터치고, 2에서 설치한 폭탄 수집 
#4에 폭탄 채우기 
#5에 2에서 설치한 폭탄 터치고, 4에서 설치한 폭탄 수집 
#6에 폭탄 채우기 
#7에 4에서 설치한 폭탄 터치고, 6에서 설치한 폭탄 수집 
for i in range(2,n+1):
    simulate(i)

for row in grid:
    print(''.join(row))