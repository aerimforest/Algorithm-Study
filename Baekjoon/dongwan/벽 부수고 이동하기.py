import sys 
from collections import deque
input = sys.stdin.readline
n, m = map(int, input().split())
grid = [list(map(int, input().rstrip())) for _ in range(n)]
# for i in grid:
#     print(i)
visited = [[[0] * 2 for _ in range(m)] for _ in range(n)]
visited[0][0][0] = 1

# 상하좌우
dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]


def bfs(r, c, w):
    queue = deque()
    queue.append((r, c, w))

    while queue:
        cr, cc, cw = queue.popleft()
        # 끝 점에 도달하면 이동 횟수를 출력
        if cr == n - 1 and cc == m - 1:
            return visited[cr][cc][cw]
        for d in range(4):
            nr = cr + dr[d]
            nc = cc + dc[d]
            if nr < 0 or nr >= n or nc < 0 or nc >= m:
                continue
            # 다음 이동할 곳이 벽이고, 벽파괴기회를 사용하지 않은 경우
            if grid[nr][nc] == 1 and cw == 0 :
                visited[nr][nc][1] = visited[cr][cc][0] + 1
                queue.append((nr, nc, 1))
            # 다음 이동할 곳이 벽이 아니고, 아직 한 번도 방문하지 않은 곳이면
            elif grid[nr][nc] == 0 and visited[nr][nc][cw] == 0:
                visited[nr][nc][cw] = visited[cr][cc][cw] + 1
                queue.append((nr, nc, cw))
    return -1


print(bfs(0, 0, 0))