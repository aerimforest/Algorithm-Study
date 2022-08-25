from sys import stdin

Y, X = map(int, stdin.readline().split())

if Y == 1:
    print(1)
elif Y == 2:
    print(min(4, (X + 1) // 2))
else:
    if X <= 6:
        print(min(4, X))
    else:
        print(X-2)