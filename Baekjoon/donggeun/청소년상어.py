sea = [[] for _ in range(4)]
ans = 0
dy = [-1,-1,0,1,1,1,0,-1]
dx = [0,-1,-1,-1,0,1,1,1]

for i in range(4):
    tmp = list(map(int,input().split()))
    for idx, x in enumerate(tmp):
        if idx%2 == 1:
            sea[i].append((tmp[idx-1],x-1))


def food(y, x, dir,array):
    feed = []
    for i in range(1,4):
        y += dy[dir]
        x += dx[dir]
        if 0<=y<4 and 0<=x<4 and 0 < array[y][x][0]:
            feed.append([y,x])
    return feed

def fish(array, num):
    for r in range(4):
        for c in range(4):
            if array[r][c][0] == num:
                return (r, c)
    return False

def move(array, sy, sx):
    for i in range(1,17):
        f = fish(array,i)
        if f is False:
            continue
        else:
            direction = array[f[0]][f[1]][1]
            for i in range(8):
                direction = (direction+i)%8
                fy = f[0] + dy[direction]
                fx = f[1] + dx[direction]
                if 0<=fy<4 and 0<=fx<4 and (fy,fx) != (sy, sx):
                    tmp = array[fy][fx]
                    array[fy][fx] = (array[f[0]][f[1]][0], direction)
                    array[f[0]][f[1]] = tmp
                    break
    return array

def dfs(array, y, x, eat):
    global ans

    array = [array[i][:] for i in range(4)]

    eat += array[y][x][0]
    dir = array[y][x][1]
    array[y][x] = (0,0)

    move(array, y, x)
    feed = food(y,x,dir, array)

    ans = max(ans, eat)

    for shark in feed:
        dfs(array, shark[0], shark[1], eat)

dfs(sea, 0,0,0)
print(ans)