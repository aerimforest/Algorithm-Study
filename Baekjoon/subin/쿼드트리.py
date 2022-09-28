import sys

input = sys.stdin.readline

n = int(input())
mtx = [list(map(int, list(input().strip()))) for _ in range(n)]


def check(x, y, n):
    for i in range(x, x + n):
        for j in range(y, y + n):
            if mtx[x][y] != mtx[i][j]:
                print("(", end="")
                check(x, y, n // 2)
                check(x, y + n // 2, n // 2)
                check(x + n // 2, y, n // 2)
                check(x + n // 2, y + n // 2, n // 2)
                print(")", end="")

                return

    print(1 if mtx[x][y] == 1 else 0, end="")


check(0, 0, n)