import sys

input = sys.stdin.readline

n, Eugene, p = map(int, input().split())

if n == 0:
    print(1)
else:
    ranking = list(map(int, input().split()))
    if n == p and ranking[-1] >= Eugene:
        print(-1)
    else:
        rank = n + 1
        for i in range(n):
            if ranking[i] <= Eugene:
                rank = i + 1
                break
        print(rank)
