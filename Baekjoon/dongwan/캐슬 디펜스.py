import copy
from itertools import combinations
import sys 
from collections import deque
input =sys.stdin.readline
#궁수는 3명 
#grid, 사정거리 
n,m,d = map(int,input().split())
grid = [list(map(int,input().split())) for _ in range(n)]

dr = [0,-1,0]
dc = [-1,0,1]

bugs = 0
for r in range(n) :
    for c in range(m) :
        if grid[r][c] :
            bugs += 1
def solution(archors) :
    tmp_grid = copy.deepcopy(grid)

    kill_lst = [[0]*m for _ in range(n)]
    res = 0

    for i in range(n-1,-1,-1) :
        if res == bugs :
            return res
        turn = []

        for archor in archors :

            queue = deque([(i,archor,1)])

            while queue :
                r,c,distance = queue.popleft()
                if tmp_grid[r][c] == 1 :
                    turn.append((r,c))

                    if kill_lst[r][c] == 0:
                        kill_lst[r][c] = 1 
                        res += 1 
                    break 
                if distance < d :
                    for k in range(3) :
                        nr = r+ dr[k]
                        nc = c + dc[k]
                        if 0<=nr<n and 0<=nc<m :
                            queue.append((nr,nc,distance+1))
        else :
            for br,bc in turn :
                tmp_grid[br][bc] = 0 
    return res 

answer = 0

candidates = list(combinations([_ for _ in range(m)],3))

for candidate in candidates :
    answer = max(answer,solution(candidate))
print(answer)