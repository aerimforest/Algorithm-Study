import sys
input = sys.stdin.readline
def dc(x,a):
    d = [x]
    for i in range(a):
        d += list(k+1 if k +1 < 4 else 0 for k in d[::-1])
    return d

n = int(input())
g = [[0]*101 for _ in range(101)]
ds = [(0, 1), (-1, 0), (0, -1), (1, 0)]



for _ in range(n):
    x,y,a,b = map(int,input().split())
    g[y][x] = 1
    for i in dc(a,b):
        x += ds[i][1]
        y += ds[i][0]
        g[y][x] = 1

r = 0
for i in range(100):
    for j in range(100):
        if g[j][i] and g[j][i+1] and g[j+1][i] and g[j+1][i+1]:
            r += 1
print(r)
