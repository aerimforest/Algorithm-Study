n,m = map(int,input().split())

grid = [list(map(int,input().split())) for _ in range(n)]

dr = [1,0,-1,0]
dc = [0,1,0,-1]


color = 2
for r in range(n) :
    for c in range(n) :
        if not grid[r][c] :
            continue
        
        elif grid[r][c] ==1 :
            lst = []
            lst.append((r,c))
            while lst :
                cr,cc = lst.pop()
                for d in range(4) :
                    nr = cr+dr[d]
                    nc = cc+dc[d]
                    
                    if 0<=nr<n and 0<=nc<m and grid[nr][nc] == 1 :
                        grid[nr][nc] = color
                        lst.append((nr,nc))
            else :
                color += 1 

