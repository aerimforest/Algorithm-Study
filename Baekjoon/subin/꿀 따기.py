import sys

N = int(sys.stdin.readline())
road = list(map(int, sys.stdin.readline().split()))

case1 = sum(road[1:-1]) + max(road[1:-1])

stop2 = 1
best2 = 0
cur2 = 0
for i in range(1, N - 2):
    cur2 += road[i] - road[i + 1] * 2
    if cur2 > best2:
        stop2 = i + 1
        best2 = cur2
case2 = sum(road[1:]) - road[stop2] + sum(road[stop2 + 1:])

stop3 = N - 2
best3 = 0
cur3 = 0
for i in range(N - 2, 1, -1):
    cur3 += road[i] - road[i - 1] * 2
    if cur3 > best3:
        stop3 = i - 1
        best3 = cur3
case3 = sum(road[:N - 1]) - road[stop3] + sum(road[:stop3])

print(max(case1, case2, case3))
