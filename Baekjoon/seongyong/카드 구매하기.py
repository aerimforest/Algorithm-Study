import sys


def read_line():
    return sys.stdin.readline().rstrip()


def read_into(type, seperator):
    return list(map(type, read_line().split(seperator)))


def read_lines(line_number, trim_each_line):
    return [trim_each_line(read_line())
            for _ in range(line_number)]


N = int(input())
p = [0] + read_into(int, ' ')
memo = [0 for _ in range(N + 1)]

for i in range(1, N + 1):
    for k in range(1, i + 1):
        memo[i] = max(memo[i], memo[i - k] + p[k])
print(memo[-1])
