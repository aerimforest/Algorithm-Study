def game(n, k, chess_color, chess_horse, horse):
    count = 1
    while count < 1000:
        for i in range(k):
            r, c, d = horse[i]
            nr, nc = r + dr[d], c + dc[d]
            if not (0 <= nr < n and 0 <= nc < n) or chess_color[nr][nc] == 2:
                d ^= 1
                nr, nc = r + dr[d], c + dc[d]
                if not (0 <= nr < n and 0 <= nc < n) or chess_color[nr][nc] == 2:
                    nr, nc = r, c
            horse[i] = [nr, nc, d]
            if nr == r and nc == c:
                continue
            j = chess_horse[r][c].index(i)
            for m in chess_horse[r][c][j+1:]:
                horse[m][0], horse[m][1] = nr, nc
            if not chess_color[nr][nc]:
                chess_horse[nr][nc] += chess_horse[r][c][j:]
            elif chess_color[nr][nc] == 1:
                chess_horse[nr][nc] += chess_horse[r][c][j:][::-1]
            chess_horse[r][c] = chess_horse[r][c][:j]
            if len(chess_horse[nr][nc]) > 3:
                return count
        count += 1
    return -1

n, k = map(int, input().split())
dr = [0, 0, -1, 1]
dc = [1, -1, 0, 0]
chess_color = [list(map(int, input().split())) for _ in range(n)]
chess_horse = [[[] * n for _ in range(n)] for _ in range(n)]
horse = []


for i in range(k):
    r, c, d = map(lambda x: int(x)-1, input().split())
    horse.append([r, c, d])
    chess_horse[r][c].append(i)
print(game(n, k, chess_color, chess_horse, horse))