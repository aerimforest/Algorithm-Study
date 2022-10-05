N, M, K = map(int, input().split())
answer = 0
fireball = []
array = [[[] for i in range(N)] for _ in range(N)]

dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]

for _ in range(M):
    r, c, m, s, d = map(int, input().split())
    fireball.append([r-1, c-1, m, s, d])

for _ in range(K): # K 회 명령하기
    while fireball:
        x, y, m, s, d = fireball.pop(0)
        # 이동하기
        nx = (x + dx[d] * s) % N
        ny = (y + dy[d] * s) % N
        array[nx][ny].append([m, s, d])
        # 2개 이상인지 확인하기
    for i in range(N):
        for j in range(N):
            if len(array[i][j]) > 1:
                # 파이어볼 합치기
                new_m = 0  # 파이어볼 질량의 합
                new_s = 0
                count = len(array[i][j])  # (i,j)에 있는 파이어볼의 개수
                odd = 0
                even = 0
                while array[i][j]:
                    mm, ss, dd = array[i][j].pop(0)
                    new_m += mm
                    new_s += ss
                    if dd % 2:
                        even += 1
                    else:
                        odd += 1
                if new_m // 5:
                    if even == count or odd == count:
                        # 0, 2, 4, 6
                        for dir in [0, 2, 4, 6]:
                            fireball.append([i, j, new_m // 5, new_s // count, dir])
                    else:
                        # 1, 3, 5, 7
                        for dir in [1, 3, 5, 7]:
                            fireball.append([i, j, new_m // 5, new_s // count, dir])

            if len(array[i][j]) == 1:
                fireball.append([i, j] + array[i][j].pop(0))

answer = 0
for f in fireball:
    answer += f[2]
print(answer)