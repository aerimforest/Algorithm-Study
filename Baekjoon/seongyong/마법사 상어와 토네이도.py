# 모래 계산하는 함수
def recount(s_x, s_y, direction):
    global ans

    if s_y < 0:
        return
        
    # 3. a, out_sand
    total = 0  # a 구하기 위한 변수
    for dx, dy, z in direction:
        nx = s_x + dx
        ny = s_y + dy
        if z == 0:  # a(나머지)
            new_sand = sand[s_x][s_y] - total
        else:  # 비율
            new_sand = int(sand[s_x][s_y] * z)
            total += new_sand

        if 0 <= nx < N and 0 <= ny < N:  # 인덱스 범위이면 값 갱신
            sand[nx][ny] += new_sand
        else:  # 범위 밖이면 ans 카운트
            ans += new_sand


N = int(input())
sand = [list(map(int, input().split())) for _ in range(N)]

# 2. 방향별 모래 비율 위치
left = [(1, 1, 0.01), (-1, 1, 0.01), (1, 0, 0.07), (-1, 0, 0.07), (1, -1, 0.1),
         (-1, -1, 0.1), (2, 0, 0.02), (-2, 0, 0.02), (0, -2, 0.05), (0, -1, 0)]
right = [(x, -y, z) for x,y,z in left]
down = [(-y, x, z) for x,y,z in left]
up = [(y, x, z) for x,y,z in left]

s_x, s_y = N//2, N//2
ans = 0
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

# 1.토네이도 회전 방향(y위치)
dict = {0: left, 1: down, 2: right, 3: up}
time = 0
for i in range(2*N-1):
    # 몫: i//4(타임+1), 나머지:i%4(방향)
    d = i % 4
    if d == 0 or d == 2:  # 다음 회차(d==0) 이거나 right(d==2) 이면 한번 더
        time += 1
    for _ in range(time):
        n_x = s_x + dx[d]
        n_y = s_y + dy[d]
        recount(n_x, n_y, dict[d])  # y좌표, 방향
        s_x, s_y = n_x, n_y

print(ans)
