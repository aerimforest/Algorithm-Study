# 뒤집는 조건 
## 행,열, 대각선 
### 2번 이하의 연산으로 다 바꿀 수 있으면 횟수 출력 
### 아니면 -1 출력

def calculator(cnt,target,grid) :
    global res
    for r in range(3) :
        for c in range(3) :
            if grid[r][c] != target :
                return False 

    res = min(res,cnt)
    return 

def solution(cnt,grid) :
    if cnt > 4 :
        return 
    if cnt >= res :
        return 

    target = grid[0][0]

    calculator(cnt,target,grid)
    # 행 
    for r in range(3) :
        new = copy.deepcopy(grid) 
        for c in range(3) :
            if new[r][c] == 'H' :
                new[r][c] = 'T'
            else :
                new[r][c] = 'H'
        solution(cnt+1,new)

    # 열 
    for r in range(3) :
        new = copy.deepcopy(grid) 
        for c in range(3) :
            if new[c][r] == 'H' :
                new[c][r] = 'T'
            else :
                new[c][r] = 'H'
        solution(cnt+1,new)

    #대각선 

    #1 

    new = copy.deepcopy(grid) 
    for r in range(3) :
        if new[r][r] == 'H' :
            new[r][r] = 'T'
        else :
            new[r][r] = 'H'
    solution(cnt+1,new)
    new = copy.deepcopy(grid) 
    for r in range(3) :
        if new[r][2-r] == 'H' :
            new[r][2-r] = 'T'
        else :
            new[r][2-r] = 'H'
    solution(cnt+1,new)


import sys 
import copy
input = sys.stdin.readline
T = int(input())


for t in range(T) :
    res = 10e9

    grid = [list(input().split()) for _ in range(3)]

    solution(0,grid)
    if res == 10e9 :
        print(-1)
    else :
        print(res)