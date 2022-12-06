from sys import stdin

input = stdin.readline

N, M = map(int, input().split())
time = sorted(list(int(input()) for _ in range(N)))

start = 0
end = min(time) * M
res = 0

while start <= end:
    mid = (start + end) // 2
    q = 0

    for t in time:
        q += mid // t

    if q >= M:
        end = mid - 1
        res = mid
    else:
        start = mid + 1

print(res)
