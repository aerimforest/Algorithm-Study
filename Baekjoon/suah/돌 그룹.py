from collections import deque
import sys
input = lambda : sys.stdin.readline().strip()


def bfs():
    global a, b, c, total, visited
    q = deque()
    q.append((a, b))
    visited[a][b] = 1
    while q:
        x, y = q.popleft()
        z = total - x - y
        if x == y == z:
            print(1)
            return
        for a, b in (x, y), (y, z), (x, z):
            if a < b:
                b -= a
                a += a
            elif a > b:
                a -= b
                b += b
            else:
                continue
            
            c = total - a - b
            x = min(a, b, c)
            y = max(a, b, c)
            if visited[x][y] == 0:
                q.append((x, y))
                visited[x][y] = 1
    print(0)

a, b, c = map(int, input().split())
total = a + b + c
visited = [[0] * (total + 1) for _ in range(total+1)]

if total % 3 == 0:
    bfs()
else:
    print(0)
