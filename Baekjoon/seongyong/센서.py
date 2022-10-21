import sys

n = int(sys.stdin.readline())
k = int(sys.stdin.readline())
pos = sorted(list(map(int, sys.stdin.readline().split())))

if k >= n:
    print(0)
    sys.exit()

dist = []
for i in range(1, n):
    dist.append(pos[i] - pos[i-1])

dist.sort(reverse=True)
for _ in range(k-1):
    dist.pop(0)

print(sum(dist))
