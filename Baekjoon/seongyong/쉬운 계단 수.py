import sys


def read_line():
    return sys.stdin.readline().rstrip()


def read_lines(line_number, trim_each_line):
    return [trim_each_line(read_line())
            for _ in range(line_number)]


def dp(digit, length, memo):
    if memo[digit][length] or length == 1: return memo[digit][length]

    if digit == 9: return dp(8, length - 1, memo)
    if digit == 0: return dp(1, length - 1, memo)

    memo[digit][length] = (dp(digit + 1, length - 1, memo)
                           + dp(digit - 1, length - 1, memo)) \
                          % 1000000000
    return memo[digit][length]


if __name__ == '__main__':
    length = int(read_line())
    memo = [[0 for l in range(length + 1)] for digit in range(10)]
    for digit in range(1, 10): memo[digit][1] = 1

    ans = 0
    for digit in range(10): ans = (ans + dp(digit, length, memo)) % 1000000000

    print(ans)
