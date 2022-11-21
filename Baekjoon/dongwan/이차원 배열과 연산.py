import sys

input = sys.stdin.readline

r,c,k = map(int,input().split())
grid = [list(map(int,input().split())) for _ in range(3)]


time = 0
lr = 3
lc = 3

def row_sol(maps) :
    global lr
    tmp = []
    big_lr = lr
    for cr in range(lr) :
        save_dic = {}
        for cc in grid[cr] :
            try :
                save_dic[grid[cr][cc]]  
                save_dic[grid[cr][cc]] += 1 
            except :
                save_dic[grid[cr][cc]] = 1 
        sorted_dict = sorted(save_dic.items(), key=lambda x:x[1])
        print(sorted_dict)
def col_sol() :
    return 

while True  :
    if time == 1 :
        break
    if grid[r][c] == k :
        break 
    time += 1 
    if lr>= lc :
        row_sol(grid)
    else :
        col_sol(grid)

    
