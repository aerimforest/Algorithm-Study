import heapq
import sys


# from collections import *


def read_line():
    return sys.stdin.readline().rstrip()


def read_line_as(return_type, element_type, seperator):
    return return_type(map(element_type, read_line().split(seperator)))


def read_lines_as(row_type, col_type, seperator, line_number):
    return [read_line_as(row_type, col_type, seperator)
            for _ in range(line_number)]


# def find_root(target, root_of: list):
#     if root_of[target] == target:
#         return target
#
#     root_of[target] = find_root(root_of[target], root_of)
#     return root_of[target]
#
#
# def union(x, y, root_of: list):  # must use find_root in main logic
#     x, y = find_root(x, root_of), find_root(y, root_of)
#     if x != y:
#         bigger, smaller = min(x, y), max(x, y)
#         root_of[bigger] = smaller


# [(0, 1), (-1, 0), (0, -1), (1, 0), (1, 1), (-1, 1), (1, -1), (-1, -1)]
# dr = [1, 0, -1, 0]
# dc = [0, 1, 0, -1]

# main logic
n, m = read_line_as(list, int, ' ')
not_heard = set(read_line() for _ in range(n))
not_seen = set(read_line() for _ in range(m))

result = sorted(list(not_seen & not_heard))
print(len(result))
print(*result, sep='\n')
