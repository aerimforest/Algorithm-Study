import sys
from collections import *


def read_line():
    return sys.stdin.readline().rstrip()


def split_n_map(split_target, seperator, to_map):
    return map(to_map, split_target.split(seperator))


def read_n_map(to_map, seperator):
    return split_n_map(read_line(), seperator, to_map)


def read_line_as(return_type, element_type, seperator):
    return return_type(read_n_map(element_type, seperator))


def read_lines(line_number, trim_each_line=None):
    if trim_each_line:
        return [trim_each_line(read_line()) for _ in range(line_number)]
    else:
        return [read_line() for _ in range(line_number)]


def read_lines_as(row_type, col_type, seperator, line_number):
    return [read_line_as(row_type, col_type, seperator)
            for _ in range(line_number)]


def add_iter(iter0, iter2, return_type):
    return return_type(sum(e) for e in zip(iter0, iter2))


visited = set()


# def dfs_return(dfs_result, current_position):
#     visited.remove(current_position)
#     return dfs_result

def find_root(target, root_of: list):
    if root_of[target] == target:
        return target

    root_of[target] = find_root(root_of[target], root_of)
    return root_of[target]


def union(x, y, root_of: list):
    x, y = find_root(x, root_of), find_root(y, root_of)
    if x != y:
        bigger, smaller = max(x, y), min(x, y)
        root_of[bigger] = smaller


dirs = [(1, 0), (0, 1), (-1, 0), (0, -1)]

# main logic
arr = sorted(read_lines(int(read_line()), int))
zero_or_less, positives = list(), list()
result = 0
for e in arr:
    if e > 0:
        positives.append(e)
    else:
        zero_or_less.append(e)

for i in range(1, len(zero_or_less), 2):
    result += zero_or_less[i] * zero_or_less[i - 1]
if len(zero_or_less) % 2:
    result += zero_or_less[-1]

for i in range(-1, -len(positives), -2):
    if positives[i] * positives[i - 1] > positives[i] + positives[i - 1] :
        result += positives[i] * positives[i - 1]
    else:
        result += positives[i] + positives[i - 1]
if len(positives) % 2:
    result += positives[0]

print(result)
