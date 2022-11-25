import sys

input = sys.stdin.readline

a, b, c, d = map(int, input().split())
ma = 0


def func(x, y):
    if x >= abs(y):
        return 4 * x ** 2 + 3 * x + 1 + y
    if x <= -abs(y):
        return 4 * x ** 2 + x + 1 - y
    if y <= -abs(x):
        return 4 * y ** 2 - y + 1 + x
    return 4 * y ** 2 - 3 * y + 1 - x


for i in range(a, c + 1):
    for j in range(b, d + 1):
        ma = max(ma, len(str(func(i, j))))

for i in range(a, c + 1):
    for j in range(b, d + 1):
        print("{0: >{1}}".format(func(i, j), ma), end=" ")
    print()
