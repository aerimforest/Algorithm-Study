from sys import stdin

input = stdin.readline

N, M = map(int, input().split())
frog = []
flower = []
result = []

for _ in range(N):
    a, b, c, d = map(int, input().split())
    frog.append((a, b, c, d))

for _ in range(N):
    a, b = map(int, input().split())
    flower.append((a, b))

for _ in range(M):
    a, b, c = map(int, input().split())
    result.append((a, b, c))

for i in range(1 << N):
    arr = [0] * 20
    flag = True
    for j in range(N):
        if (1 << j) & i:
            if arr[flower[j][0]] != 0: flag = False
            arr[flower[j][0]] = j + 1
        else:
            if arr[flower[j][1]] != 0: flag = False
            arr[flower[j][1]] = j + 1
    for j in range(M):
        a, b, c = result[j]
        if frog[arr[a] - 1][c - 1] != frog[arr[b] - 1][c - 1]: flag = False
    if flag:
        print("YES")
        print(*arr[1:N + 1])
        exit()
print("NO")
