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


# visited = set()

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
row, col, time = read_n_map(int, ' ')
all_blank = set((r, c) for r in range(row) for c in range(col))
first, second = set(), None
for r in range(row):
    for c, blank in enumerate(read_line()):
        if blank == 'O':
            first.add((r, c))
t, first_time_to_bomb, second_time_to_bomb = 1, 2, 0
while True:
    t += 1
    first_time_to_bomb -= 1
    if second_time_to_bomb:
        second_time_to_bomb -= 1

    if t > time:
        break

    if first_time_to_bomb == 0:
        for bomb in first:
            for _dir in dirs:
                adjacent = tuple(sum(e) for e in zip(bomb, _dir))
                second.discard(adjacent)
        first, second = second, None
        first_time_to_bomb, second_time_to_bomb = second_time_to_bomb, None
    else:
        second = all_blank - first
        second_time_to_bomb = 3

if second is None:
    for r in range(row):
        for c in range(col):
            if (r, c) in first:
                print('O', end="")
            else:
                print('.', end="")
        print()
else:
    for r in range(row):
        for c in range(col):
            print('O', end="")
        print()
