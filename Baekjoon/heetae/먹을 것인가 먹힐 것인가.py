from bisect import bisect
from sys import stdin

input = stdin.readline

t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    a = sorted(list(map(int, input().split())))
    b = sorted(list(map(int, input().split())))
    cnt = 0

    for i in a:
        cnt += bisect(b, i - 1)
    print(cnt)
