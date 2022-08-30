import sys


def read_line():
    return sys.stdin.readline().rstrip()


def read_lines(line_number, trim_each_line):
    return [trim_each_line(read_line())
            for _ in range(line_number)]


if __name__ == '__main__':
    n, k = map(int, read_line().split())
    coins = read_lines(n, int)
    memo = [0 for val in range(k + 1)]

    for coin in coins:
        for val in range(1, k + 1):
            if val - coin >= 0:
                memo[val] += memo[val - coin]
            if val == coin:
                memo[val] += 1

    print(memo[-1])
