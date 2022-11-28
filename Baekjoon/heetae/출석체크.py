import sys

input = sys.stdin.readline

N, K, Q, M = map(int, input().split())

sleep = [False for _ in range(N + 3)]
check = [0 for _ in range(N + 3)]

for i in map(int, input().split()):
    sleep[i] = True

for i in map(int, input().split()):
    if sleep[i]:
        continue

    for j in range(i, N + 3, i):
        if not sleep[j]:
            check[j] = 1

result = [check[0]]
for i in range(1, N + 3):
    result.append(result[-1] + check[i])

for _ in range(M):
    S, E = map(int, input().split())
    print(E - S + 1 - (result[E] - result[S - 1]))
