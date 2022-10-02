# [참고]

from collections import deque


def findpath(x):
    arr = []
    temp = x
    for _ in range(dist[x] + 1):
        arr.append(temp)
        temp = move[temp]
    print(' '.join(map(str, arr[::-1])))


def bfs():
    q = deque()
    q.append(N)
    while q:
        x = q.popleft()
        if x == K:
            print(dist[x])
            findpath(x)
            return x
        for i in (x + 1, x - 1, 2 * x):
            if 0 <= i <= 100000 and dist[i] == 0:
                q.append(i)
                dist[i] = dist[x] + 1
                move[i] = x


N, K = map(int, input().split())
dist = [0] * 100001
move = [0] * 100001
bfs()