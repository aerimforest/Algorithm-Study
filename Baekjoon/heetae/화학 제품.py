import sys

input = sys.stdin.readline

for _ in range(int(input())):
    a, b, c = map(int, input().split())
    ab, bc, ca = map(int, input().split())
    res = 0

    for x in range(min(a, b) + 1):
        ta, tb = a - x, b - x
        now1 = ab * x

        for y in range(min(tb, c) + 1):
            ttb, tc = tb - y, c - y
            now2 = bc * y + ca * min(ta, tc)

            if res < now1 + now2:
                res = now1 + now2

    print(res)
