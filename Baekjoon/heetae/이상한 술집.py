import sys

input = sys.stdin.readline

N, K = map(int, input().split())
pot = [int(input()) for _ in range(N)]

start = 1
end = max(pot)

res = 0
while start <= end:
    mid = (start + end) // 2
    count = sum(i // mid for i in pot)

    if count >= K:
        res = mid
        start = mid + 1
    else:
        end = mid - 1

print(res)
