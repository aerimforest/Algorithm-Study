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

def find_root(target: int, root_of: list) -> int:
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

IN_SQUARE = 1
col, row, num_squares = read_n_map(int, ' ')
paper = [[0] * col for r in range(row)]
for _ in range(num_squares):
    first_row, first_col, last_row, last_col = read_n_map(int, ' ')
    for r in range(first_row, last_row):
        for c in range(first_col, last_col):
            paper[r][c] = IN_SQUARE

areas = list()
VISITED = -1
for r in range(row):
    for c in range(col):
        if paper[r][c] is IN_SQUARE or paper[r][c] is VISITED:
            continue
        # bfs
        que = deque([(r, c)])
        paper[r][c] = VISITED
        area = 0
        while que:
            now_r, now_c = que.popleft()
            paper[now_r][now_c] = VISITED
            area += 1
            paper[now_r][now_c] = VISITED
            for dr, dc in dirs:
                next_r, next_c = now_r + dr, now_c + dc
                if 0 <= next_r < row and 0 <= next_c < col \
                        and paper[next_r][next_c] is not VISITED \
                        and paper[next_r][next_c] is not IN_SQUARE:
                    que.append((next_r, next_c))
                    paper[next_r][next_c] = VISITED

        areas.append(area)

print(len(areas))
print(' '.join(map(str, sorted(areas))))
