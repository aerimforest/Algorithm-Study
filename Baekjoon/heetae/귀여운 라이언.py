from sys import stdin

input = stdin.readline

N, K = map(int, input().split())
arr = list(map(int, input().split()))

res = int(1e9)
L = 0
R = 0
lion = 0

if arr[R] == 1:
    lion += 1

while R < N:
    if lion == K:
        res = min(res, R - L + 1)
        if arr[L] == 1:
            lion -= 1
        L += 1
    else:
        R += 1
        if R < N and arr[R] == 1:
            lion += 1

if res == int(1e9):
    print(-1)
else:
    print(res)
