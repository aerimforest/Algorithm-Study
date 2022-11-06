import sys
from collections import deque

r, c = map(int, sys.stdin.readline().rsplit())
islands = [[0 for _ in range(c)] for _ in range(r)]
arr = [list(map(int, sys.stdin.readline().rsplit())) for _ in range(r)]
d = ((0,1), (0,-1), (1,0), (-1,0))
edges = []
cordis = []

def isin(y, x):
    if -1<y<r and -1<x<c: return True
    return False

def _make_islands(visited, sy, sx, k):
    q = deque()
    q.append((sy, sx))

    while q:
        y, x = q.popleft()
        for dy, dx in d:
            ny = y + dy
            nx = x + dx
            if not isin(ny, nx): continue
            if not visited[ny][nx]:
                visited[ny][nx] = True
                if arr[ny][nx] == 1:
                    islands[ny][nx] = k
                    q.append((ny, nx))
                    cordis.append((ny, nx, k))

def make_islands():
    visited = [[False for _ in range(c)] for _ in range(r)]
    k = 1
    for i in range(r):
        for j in range(c):
            if not visited[i][j] and arr[i][j] == 1:
                visited[i][j] = True
                islands[i][j] = k
                cordis.append((i, j, k))
                _make_islands(visited, i, j, k)
                k += 1
    
    return k

def _find_routes(sy, sx, k):
    q = deque()
    
    for dy, dx in d:
        q.append((sy, sx))
        visited = [[False for _ in range(c)] for _ in range(r)]
        visited[sy][sx] = True
        table = [[0 for _ in range(c)] for _ in range(r)]

        while q:
            y, x = q.popleft()
            ny = y + dy
            nx = x + dx

            if not isin(ny, nx): continue
            if not visited[ny][nx]:
                visited[ny][nx] = True
                if islands[ny][nx] == 0:
                    table[ny][nx] = table[y][x] + 1
                    q.append((ny, nx))
                    
                elif islands[ny][nx] != k and table[y][x] >= 2:
                    edges.append((table[y][x], k, islands[ny][nx]))

def find_routes():
    for y, x, k in cordis:
        _find_routes(y, x, k)

n = make_islands() - 1
find_routes()
uf = [-1 for _ in range(n+1)]

def find(a):
    if uf[a] < 0: return a
    uf[a] = find(uf[a])
    return uf[a]

def merge(a, b):
    a = find(a)
    b = find(b)
    if a == b: return False
    uf[b] = a
    return True

edges.sort()
total, cnt = 0, 0

for w, a, b in edges:
    if merge(a, b):
        total += w
        cnt += 1
        if cnt == n-1: break
if cnt == n-1: print(total)
else: print(-1)
