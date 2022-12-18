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
#     combo_block.remove(current_position)
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
n_frames = int(read_line())
_ = read_line()
votes = read_line_as(list, int, ' ')

voted_count = [0] * 101
frames = list()


def min_idx_in_frame():
    min_i, min_voted = 0, voted_count[frames[0]]
    for i, student in enumerate(frames):
        voted = voted_count[student]
        if voted < min_voted:
            min_i, min_voted = i, voted
    return min_i


for voted_student in votes:
    if voted_student not in frames:
        if len(frames) >= n_frames:
            min_i = min_idx_in_frame()
            min_student = frames[min_i]
            voted_count[min_student] = 0
            frames.pop(min_i)
        frames.append(voted_student)
    voted_count[voted_student] += 1

print(' '.join(map(str, sorted(frames))))
