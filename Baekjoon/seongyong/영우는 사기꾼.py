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
num_buildings, num_edges, num_infos = read_n_map(int, ' ')
in_out = [None] + [[0, []] for _ in range(num_buildings)]
for _ in range(num_edges):
    _from, to = read_n_map(int, ' ')
    in_out[_from][1].append(to)
    in_out[to][0] += 1
infos = read_lines_as(list, int, ' ', num_infos)

built_count = [0] * (num_buildings + 1)
BUILD, DESTROY = 1, 2
cheated = False

for info in infos:
    operation, building = info
    in_degree, out = in_out[building]

    if operation is BUILD:
        if in_degree != 0:
            cheated = True
            break

        if not built_count[building]:
            for adj in in_out[building][1]:
                in_out[adj][0] = max(in_out[adj][0] - 1, 0)
        built_count[building] += 1

    elif operation is DESTROY:
        if not built_count[building]:
            cheated = True
            break

        built_count[building] -= 1
        if not built_count[building]:
            for adj in in_out[building][1]:
                in_out[adj][0] += 1

if cheated:
    print('Lier!')
else:
    print('King-God-Emperor')
