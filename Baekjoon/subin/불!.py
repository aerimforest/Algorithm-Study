from collections import deque

jq=deque()
mq=deque()

r,c = map(int,input().split())

jdist=[[-1 for _ in range(c)] for _ in range(r)]
mdist=[[-1 for _ in range(c)] for _ in range(r)]

m=[]
exist=False
for i in range(r):
    inp=list(input())
    if 'J' in inp:
        jq.append((i,inp.index('J')))
        jdist[i][inp.index('J')]=0

    for index,j in enumerate(inp):
        if j == 'F':
            mq.append((i,index))
            mdist[i][index]=0
            exist=True
    m.append(inp)

dx=[1,-1,0,0]
dy=[0,0,1,-1]

while mq:
    x,y=mq.popleft()

    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if 0 <= nx < r and 0 <= ny < c:
            if m[nx][ny] == '.' and mdist[nx][ny] == -1:
                mdist[nx][ny]=mdist[x][y]+1
                mq.append((nx,ny))

while jq:
    x,y=jq.popleft()

    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if nx<0 or nx>=r or ny<0 or ny>=c:
            print(jdist[x][y]+1)
            exit(0)
        if jdist[nx][ny] >= 0 or m[nx][ny] == '#':
            continue
        if mdist[nx][ny] != -1 and mdist[nx][ny] <= jdist[x][y]+1:
            continue
        jdist[nx][ny]=jdist[x][y]+1
        jq.append((nx,ny))
print('IMPOSSIBLE')