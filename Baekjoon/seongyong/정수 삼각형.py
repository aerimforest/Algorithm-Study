import sys

if __name__ == '__main__':
    n = -1 + int(sys.stdin.readline())
    now = [int(sys.stdin.readline())]

    while n:
        under = list(map(int, sys.stdin.readline().split(' ')))
        under[0] += now[0]
        under[-1] += now[-1]
        for i in range(1, len(under) - 1): under[i] += max(now[i - 1], now[i])
        now = under
        n -= 1

    print(max(now))
