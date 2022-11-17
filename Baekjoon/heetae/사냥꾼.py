import sys

input = sys.stdin.readline

m, n, l = map(int, input().split())
man = list(map(int, input().split()))
man.sort()
animal = [list(map(int, input().split())) for i in range(n)]

cnt = 0
for a, b in animal:
    start = 0
    end = len(man) - 1
    while start < end:
        mid = (start + end) // 2
        if man[mid] < a:
            start = mid + 1
        else:
            end = mid
    if abs(man[end] - a) + b <= l or abs(man[end - 1] - a) + b <= l:
        cnt += 1

print(cnt)
