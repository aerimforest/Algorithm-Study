import sys
from collections import *


def read_line():
    return sys.stdin.readline().rstrip()


def read_line_as(return_type, element_type, seperator):
    return return_type(map(element_type, read_line().split(seperator)))


def read_lines_as(row_type, col_type, seperator, line_number):
    return [read_line_as(row_type, col_type, seperator)
            for _ in range(line_number)]


# main logic
_, goal = read_line_as(list, int, ' ')
arr = read_line_as(list, int, ' ')
count = defaultdict(int)
count[0] = 1
sub_sum = 0
result = 0
for e in arr:
    sub_sum += e
    result += count[sub_sum - goal]
    count[sub_sum] += 1

print(result)
