n = int(input())

lst = [list(map(int,input().split())) for _ in range(n)]

x, y = n//2, n//2

#     좌 , 하, 우,  상
dx = [0,   1,  0,  -1]
dy = [-1,  0,  1,   0]

l = 1
d = -1
cnt = 1

out = 0

while 0 <= x < n and 0 <= y < n :

    d += 1
    l = d // 2 + 1

    for _ in range(l):
        nx = x + dx[d % 4] 
        ny = y + dy[d % 4]      

        left = 0

        if ny == -1:
            y = ny
            break
        
        now = lst[nx][ny]

        # 7 % : nnx, nny
        for k in [1, -1]:
            nnx = nx + dx[(d + k)%4]
            nny = ny + dy[(d + k)%4]
            if 0 <= nnx < n and 0 <= nny < n:
                lst[nnx][nny] += int(now * 0.07)
            else:
                out += int(now * 0.07)
            left += int(now * 0.07)

        # 2 % : nnx, nny
        for k in [1, -1]:
            nnx = nx + dx[(d + k)%4] * 2
            nny = ny + dy[(d + k)%4] * 2
            if 0 <= nnx < n and 0 <= nny < n:
                lst[nnx][nny] += int(now * 0.02)
            else:
                out += int(now * 0.02)
            left += int(now * 0.02)
        
        # 1 % 
        for k in [1, -1]:
            nnx = x + dx[(d + k)%4]
            nny = y + dy[(d + k)%4] 
            if 0 <= nnx < n and 0 <= nny < n:
                lst[nnx][nny] += int(now * 0.01)
            else:
                out += int(now * 0.01)
            left += int(now * 0.01)
        
        # 10 % 
        nnx = nx + dx[d%4]
        nny = ny + dy[d%4]
        for k in [1, -1]:
            nnnx = nnx + dx[(d + k)%4]
            nnny = nny + dy[(d + k)%4] 
            if 0 <= nnnx < n and 0 <= nnny < n:
                lst[nnnx][nnny] += int(now * 0.10)
            else:
                out += int(now * 0.10)
            left += int(now * 0.10)

        # 5 % 
        nnx = x + dx[d%4] * 3
        nny = y + dy[d%4] * 3
        
        if 0 <= nnx < n and 0 <= nny < n:
            lst[nnx][nny] += int(now * 0.05)
        else:
            out += int(now * 0.05)
        left += int(now * 0.05)

        # alpha
        nnx = nx + dx[d%4]
        nny = ny + dy[d%4]
        
        if 0 <= nnx < n and 0 <= nny < n:
            lst[nnx][nny] += lst[nx][ny] - left
        else:
            out += lst[nx][ny] - left

        # do something

        x = nx
        y = ny
print(out)
