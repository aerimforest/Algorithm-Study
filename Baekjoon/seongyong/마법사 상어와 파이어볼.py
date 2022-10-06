N, M, K = map(int, input().split())
fireballs = []
for _ in range(M):
    _r, _c, _m, _s, _d = list(map(int, input().split()))
    fireballs.append([_r-1, _c-1, _m, _s, _d])

MAP = [[[] for _ in range(N)] for _ in range(N)]

dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]

for _ in range(K):
    # 파이어볼 이동
    while fireballs:
        cr, cc, cm, cs, cd = fireballs.pop(0)
        nr = (cr + cs * dx[cd]) % N  # 1번-N번 행 연결되어있기 때문
        nc = (cc + cs * dy[cd]) % N
        MAP[nr][nc].append([cm, cs, cd])

    # 2개 이상인지 체크
    for r in range(N):
        for c in range(N):
            # 2개 이상인 경우 -> 4개의 파이어볼로 쪼개기
            if len(MAP[r][c]) > 1:
                sum_m, sum_s, cnt_odd, cnt_even, cnt = 0, 0, 0, 0, len(MAP[r][c])
                while MAP[r][c]:
                    _m, _s, _d = MAP[r][c].pop(0)
                    sum_m += _m
                    sum_s += _s
                    if _d % 2:
                        cnt_odd += 1
                    else:
                        cnt_even += 1
                if cnt_odd == cnt or cnt_even == cnt:  # 모두 홀수이거나 모두 짝수인 경우
                    nd = [0, 2, 4, 6]
                else:
                    nd = [1, 3, 5, 7]
                if sum_m//5:  # 질량 0이면 소멸
                    for d in nd:
                        fireballs.append([r, c, sum_m//5, sum_s//cnt, d])

            # 1개인 경우
            if len(MAP[r][c]) == 1:
                fireballs.append([r, c] + MAP[r][c].pop())

print(sum([f[2] for f in fireballs]))
