import sys


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


def add_iter(iter1, iter2, return_type):
    return return_type(sum(e) for e in zip(iter1, iter2))


# visited = set()

# def dfs_return(dfs_result, current_position):
#     visited.remove(current_position)
#     return dfs_result


# main logic
from collections import deque

for _ in range(int(read_line())):
    _, target = read_n_map(int, ' ')
    q = deque(read_n_map(lambda e: [int(e)], ' '))
    for i in range(len(q)): q[i].append(i)
    count = 0
    while q:
        if q[0][0] == max(q)[0]:
            count += 1
            if q.popleft()[1] == target:
                print(count)
                break
        else:
            q.append(q.popleft())
