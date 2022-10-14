from collections import deque

n, q = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(2 ** n)]
l = list(map(int, input().split()))
max_l = max(l)
temp = [[0 for _ in range(2 ** max_l)] for _ in range(2 ** max_l)]
visited = [[0 for _ in range(2 ** n)] for _ in range(2 ** n)]
directions = ((-1, 0), (1, 0), (0, -1), (0, 1))

def rotate(position, l) :
    cur_r, cur_c = position

    for r in range(l) :
        for c in range(l) :
            temp[r][c] = data[cur_r+l-1-c][cur_c+r]

    for r in range(l) :
        for c in range(l) :
            data[cur_r+r][cur_c+c] = temp[r][c]

def visitable(nr, nc) :
    return 0 <= nr < 2 ** n and 0 <= nc < 2 ** n and data[nr][nc]

def simulation(l_value) :
    # 격자 크기 만큼 90도 회전
    for r in range(0, 2 ** n, l_value) :
        for c in range(0, 2 ** n, l_value) :
            rotate((r, c), l_value)

    check = [[0 for _ in range(2 ** n)] for _ in range(2 ** n)]

    # 인접한 얼음이 3개 미만인 경우 찾기
    for r in range(2 ** n) :
        for c in range(2 ** n) :
            if not data[r][c] :
                continue

            count = 0
            for dr, dc in directions :
                nr = r + dr
                nc = c + dc
                if visitable(nr, nc) :
                    count += 1

            # check 하지 않고 바로 녹이게 되면 탐색에 영향을 받음
            if count < 3 :
                check[r][c] = 1

    # 찾은 얼음 녹이기
    for r in range(2 ** n) :
        for c in range(2 ** n) :
            if check[r][c] :
                data[r][c] -= 1

def bfs(start) :
    q = deque([start])
    cnt = 1

    while q :
        cur_r, cur_c = q.popleft()
        for dr, dc in directions :
            nr = cur_r + dr
            nc = cur_c + dc

            if visitable(nr, nc) and not visited[nr][nc] :
                visited[nr][nc] = 1
                q.append((nr, nc))
                cnt += 1
    return cnt

for cur_l in l :
    simulation(2 ** cur_l)

# 남아 있는 얼음의 총합
sum_ice = sum(sum(data, []))
# 남아 있는 얼음 중 가장 큰 덩어리가 차지하는 칸의 개수
max_ice = 0
for i in range(2 ** n) :
    for j in range(2 ** n) :
        if data[i][j] and not visited[i][j] :
            visited[i][j] = 1
            max_ice = max(max_ice, bfs((i, j)))

print(sum_ice)
print(max_ice)
