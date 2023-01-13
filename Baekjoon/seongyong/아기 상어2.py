import heapq
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


#
#
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
#
#
# dirs = [(0, 1), (-1, 0), (0, -1), (1, 0)]
dirs = [(0, 1), (-1, 0), (0, -1), (1, 0), (1, 1), (-1, 1), (1, -1), (-1, -1)]


def pos_is_in_field(r, c, field: list):
    return 0 <= r < len(field) and 0 <= c < len(field[r])


def adjacencies_of(r, c, field):
    return ((r + d[0], c + d[1]) for d in dirs
            if pos_is_in_field(r + d[0], c + d[1], field))


# main logic
n_row, n_col = read_n_map(int, ' ')
field = read_lines_as(list, int, ' ', n_row)
visited = [[0] * n_col for r in range(n_row)]
BLANK, SHARK = 0, 1
distance, max_distance = 0, 0
q = deque([(r, c, distance) for r in range(n_row) for c in range(n_col)
           if field[r][c] == SHARK])

while q:
    r, c, distance = q.popleft()
    distance += 1
    for a in adjacencies_of(r, c, field):
        if visited[a[0]][a[1]] or field[a[0]][a[1]] != BLANK:
            continue
        visited[a[0]][a[1]] = distance
        q.append((a[0], a[1], distance))
        max_distance = max(distance, max_distance)

print(max_distance)
