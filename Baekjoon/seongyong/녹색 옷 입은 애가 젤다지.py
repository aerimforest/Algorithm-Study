import sys
import heapq
input = sys.stdin.readline

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

problem = 1
while True:
    N = int(input())
    if N == 0:
        break
    arr = []
    for _ in range(N):
        arr.append(list(map(int, input().split())))
    arr1 = [[sys.maxsize]*N for _ in range(N)]
    visited = [[False]*N for _ in range(N)]
    queue = [[arr[0][0], 0,0]]

    while queue:
        w, x, y = heapq.heappop(queue)
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and arr1[nx][ny] > w + arr[nx][ny]:
                arr1[nx][ny] = w + arr[nx][ny]
                visited[nx][ny] = True
                heapq.heappush(queue, [arr1[nx][ny], nx, ny])
                visited[nx][ny] = False
                
    print("Problem {0}: {1}".format(problem, arr1[N-1][N-1]))
    problem += 1
