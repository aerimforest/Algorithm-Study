def find(x, y, d, s, li1, li2) :
    global Ans
    for i in range(16) :
        if li2[i] != 0 :
            a, b = li2[i] ; c = li1[a][b][1]
            while True :
                na = a + Dir[c][0] ; nb = b + Dir[c][1]
                if 0<=na<=3 and 0<=nb<=3 and li1[na][nb] != 0 :
                    p, q = li1[na][nb]
                    li1[na][nb] = [i, c] ; li1[a][b] = [p, q]
                    li2[i] = (na, nb)
                    if p != -1 : li2[p] = (a, b)
                    break
                else :
                    if c<7 : c+=1
                    else : c = 0

    li1[x][y] = [-1, -1]
    while 0<=x+Dir[d][0]<=3 and 0<=y+Dir[d][1]<=3 :
        nx = x + Dir[d][0] ; ny = y + Dir[d][1]
        if li1[nx][ny][0] != -1 :
            p, q = li1[nx][ny] ; li1[nx][ny] = 0 ; li2[p] = 0
            new = []
            for data in li1 : new.append(data.copy())
            find(nx, ny, q, s+p+1, new, li2.copy())
            li2[p] = (nx, ny) ; li1[nx][ny] = [p, q]
        x = nx ; y = ny

    Ans = max(Ans, s)

Map = [[0] * 4 for _ in range(4)]
Fish = [0] * 16
Dir = [(-1, 0), (-1, -1), (0, -1), (1, -1), (1, 0), (1, 1), (0, 1), (-1, 1)]


for i in range(4) :
    I = list(map(int,input().split()))
    for j in range(4) :
        Map[i][j] = [I[2*j]-1, I[2*j+1]-1]
        Fish[I[2*j]-1] = (i, j)

s = Map[0][0][0] ; d = Map[0][0][1] ; Fish[Map[0][0][0]] = 0 ; Map[0][0] = 0
Ans = 0
find(0, 0, d, s+1, Map, Fish)

print(Ans)