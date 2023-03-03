import sys
input = sys.stdin.readline

# S: 이다솜, Y: 임도연
# S가 4 이상
graph = [list(map(str,input().rstrip())) for _ in range(5)]
dx = [1,0,-1,0]
dy = [0,-1,0,1]
visited = [[False]*5 for _ in range(5)]

def move(s):
    res = []
    for i in range(4):
        nx = dx[i] + s[-1][0]
        ny = dy[i] + s[-1][1]

        if nx < 0 or ny < 0 or nx >= 5 or ny >= 5:
            continue
        res.append([nx,ny])
    return res


ans = []
def bt(s):
    if len(s) == 7:
        s.sort()
        if s not in ans:
            ans.append(s[::])
        return

    elif len(s) > 7:
        return

    for x,y in move(s):
        if not visited[x][y]:
            if [x,y] not in s:
                s.append([x,y])
                visited[x][y] = True
                bt(s)
                visited[x][y] = False
                s.pop()

for i in range(5):
    for j in range(5):
        visited[i][j] = True
        bt([[i,j]])
tot = 0
tmp = []
for candi in ans:
    s_cnt = 0
    y_cnt = 0
    for x,y in candi:
        if graph[x][y] == "S":
            s_cnt += 1
        else:
            y_cnt += 1
    if s_cnt >= 4:
        tot += 1
print(tot)