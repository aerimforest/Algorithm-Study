import sys
from itertools import combinations

N, K = map(int, sys.stdin.readline().split())
words = []
for _ in range(N):
    words.append(set(sys.stdin.readline().rstrip())-{'a','n','t','i','c'})
if K-5 < 0:
    print(0)
    sys.exit()
ans = 0
for n in combinations('bdefghjklmopqrsuvwxyz',K-5):
    n = set(n)
    cnt = 0
    for word in words:
        if not word - n:
            cnt += 1
    ans = max(ans, cnt)
print(ans)