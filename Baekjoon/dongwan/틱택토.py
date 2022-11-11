def flag(grid,equ):
    if grid[0][0]==grid[0][1]==grid[0][2]==equ:
        return True
    if grid[1][0]==grid[1][1]==grid[1][2]==equ:
        return True
    if grid[2][0]==grid[2][1]==grid[2][2]==equ:
        return True
    if grid[0][0]==grid[1][0]==grid[2][0]==equ:
        return True
    if grid[0][1]==grid[1][1]==grid[2][1]==equ:
        return True
    if grid[0][2]==grid[1][2]==grid[2][2]==equ:
        return True
    if grid[0][0]==grid[1][1]==grid[2][2]==equ:
        return True
    if grid[2][0]==grid[1][1]==grid[0][2]==equ:
        return True
    return False
    

while True:
    x=input()
    if x=="end":
        break
    else:
        lx = x.count('X')
        lo = x.count('O')
        grid=[[0]*3 for _ in range(3)]
        i = 0
        for r in range(3):
            for c in range(3):
                grid[r][c]=x[i]
                i+=1
        #x가 놓은게 o가 놓은 것보다 2번이상 더 놨으면 
        if lx>lo+1:
            print("invalid")
            continue
        if lo>lx:
            print("invalid")
            continue
        if lo==lx:
            if flag(grid,"O") and not flag(grid,"X"):
                print("valid")
                continue
        if lo+1==lx:
            if flag(grid,"X") and not flag(grid,"O"):
                print("valid")
                continue
        if lx==5 and lo==4:
            if not flag(grid,"O"):
                print("valid")
                continue
        print("invalid")