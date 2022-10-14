N,Q = map(int,input().split())

n = 2**N
# print(n)
grid = [list(map(int,input().split())) for _ in range(n)]

courses = list(map(int,input().split()))

dr = [-1,1,0,0]
dc = [0,0,-1,1]

for course in courses :
    rotate = 2**course

    rotate_grid = [[0]*n for _ in range(n)]
    for i in range(0,n,rotate) :
        for j in range(0,n,rotate) :

            for k in range(rotate) :
                for l in range(rotate) :
                    rotate_grid[i+l][j+rotate-k-1] = grid[i+k][j+l]
    
    # for i in grid :
    #     print(i)
    grid = [[0]*n for _ in range(n)] 
    for r in range(n) :
        for c in range(n) :
            cnt = 0

            for d in range(4) :
                nr = r + dr[d]
                nc = c + dc[d]
                if 0<= nr < n and 0<=nc <n and not rotate_grid[nr][nc] :
                    cnt += 1 
                if rotate_grid[r][c] :
                    if cnt < 3 :
                        grid[r][c] = rotate_grid[r][c] -1 
                    else :
                        grid[r][c] = rotate_grid[r][c]

    # for i in grid :
    #     print(i)
# for i in grid :
#     print(i)
res = 0 
res_lst = [0] 
visited=[[0]*n for _ in range(n)] 

for r in range(n) :
    for c in range(n) :

        tmp = []

        if not grid[r][c] and not visited[r][c] :

            tmp.append([r,c])
            visited[r][c] = True 
            res += grid[r][c] 
            cnt = 1 

            while tmp :
                t = tmp.pop() 
                tr,tc = t[0],t[1]

                for d in range(4) :
                    ntr = tr+dr[d]
                    ntc = tc+dc[d] 

                    if 0<= ntr < n and 0<=ntc<n and not visited[ntr][ntc] and not grid[ntr][ntc] :
                        tmp.append([ntr,ntc]) 
                        visited[ntr][ntc] = True 
                        res += grid[ntr][ntc]
                        cnt += 1 
            res_lst.append(cnt)
# print(res_lst)
print(res)
print(max(res_lst))

