from collections import deque


def bfs(i, j):
    queue = deque()
    queue.append((i, j))
    d = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    cnt = 1
    while queue:
        y, x = queue.popleft()
        for dy, dx in d:
            Y, X = y + dy, x + dx
            if (0 <= Y < M) and (0 <= X < N) and graph[Y][X] == 0:
                graph[Y][X] = 1
                queue.append((Y, X))
                cnt += 1
    return cnt


M, N, K = map(int, input().split())
graph = [[0] * N for _ in range(M)]
for _ in range(K):
    x1, y1, x2, y2 = map(int, input().split())
    for i in range(y1, y2):
        for j in range(x1, x2):
            graph[i][j] = 1
res = []
for i in range(M):
    for j in range(N):
        if graph[i][j] == 0:
            graph[i][j] = 1
            res.append(bfs(i, j))
print(len(res))
print(*sorted(res))
