import heapq

pn = 0
while True:
    pn += 1
    N = int(input())
    if not N:
        quit()
    arr = [list(map(int, input().split())) for i in range(N)]
    dist = [[float('INF') for i in range(N)] for j in range(N)]
    visited = [[False for i in range(N)] for j in range(N)]
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]

    pq = []
    heapq.heappush(pq, [arr[0][0], 0, 0])
    dist[0][0] = arr[0][0]
    while len(pq) > 0:
        cur = heapq.heappop(pq)

        d = cur[0]
        x = cur[1]
        y = cur[2]

        if visited[x][y]:
            continue

        visited[x][y] = True

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if not (0 <= nx < N and 0 <= ny < N):
                continue
            nd = dist[x][y] + arr[nx][ny]

            if dist[nx][ny] > nd:
                dist[nx][ny] = nd
                heapq.heappush(pq, [nd, nx, ny])

    ans = dist[N - 1][N - 1]
    print(f'Problem {pn}:', ans)