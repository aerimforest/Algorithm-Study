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
from itertools import combinations

WALL, VIRUS_SPOT = 1, 2
size, num_viruses = read_n_map(int, ' ')
field = read_lines_as(list, int, ' ', size)


def bfs_get_time(virus_poses: list):
    visited = set(virus_poses)
    time = 0
    q = deque((virus_pos, time) for virus_pos in virus_poses)
    while q:
        pos, time = q.popleft()
        pos_r, pos_c = pos
        for adj in map(lambda d: (pos_r + d[0], pos_c + d[1]), dirs):
            adj_r, adj_c = adj
            if adj in visited \
                    or not (0 <= adj_r < len(field) and 0 <= adj_c < len(field[0])) \
                    or field[adj_r][adj_c] is WALL:
                continue
            visited.add(adj)
            q.append((adj, time + 1))

    for r in range(len(field)):
        for c in range(len(field[r])):
            if field[r][c] is not WALL and (r, c) not in visited:
                return -1

    return time


virus_spots = [(r, c) for r in range(len(field)) for c in range(len(field[r]))
               if field[r][c] is VIRUS_SPOT]
possible_times = [time for time in map(bfs_get_time, combinations(virus_spots, num_viruses))
                  if time != -1]

if possible_times:
    print(min(possible_times))
else:
    print(-1)
