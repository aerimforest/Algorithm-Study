n, k = map(int, input().split())
di = [0, 0, -1, 1]
dj = [1, -1, 0, 0]
change_dir = [1, 0, 3, 2]
board = [list(map(int, input().split())) for _ in range(n)]
tower = [[[] for _ in range(n)] for _ in range(n)]
pos_dir = []
for kk in range(k):
    i, j, dir = map(int, input().split())
    i, j, dir = i - 1, j - 1, dir - 1
    pos_dir.append([i, j, dir])
    tower[i][j].append(kk)


def move():
    for now in range(k):
        i, j, dir = pos_dir[now]
        ni, nj = i + di[dir], j + dj[dir]
        floor = tower[i][j].index(now)
        go = False
        if (ni < 0 or ni >= n or nj < 0 or nj >= n) or board[ni][nj] == 2:
            dir = change_dir[dir]
            ni, nj = i + di[dir], j + dj[dir]
        if 0 <= ni < n and 0 <= nj < n and board[ni][nj] == 0:
            go = True
            chess_tower = tower[i][j][floor:]
            tower[i][j] = tower[i][j][:floor]
            tower[ni][nj] += chess_tower
        elif 0 <= ni < n and 0 <= nj < n and board[ni][nj] == 1:
            go = True
            chess_tower = tower[i][j][floor:][::-1]
            tower[i][j] = tower[i][j][:floor]
            tower[ni][nj] += chess_tower
        if go:
            if len(tower[ni][nj]) >= 4:
                return True
            for chess_num in chess_tower:
                pos_dir[chess_num][0] = ni
                pos_dir[chess_num][1] = nj
                if chess_num == now:
                    pos_dir[chess_num][2] = dir
        else:
            pos_dir[now][2] = dir
    return False


ans = 0
while 1:
    ans += 1
    if ans > 1000:
        ans = -1
        break
    elif move():
        break

print(ans)