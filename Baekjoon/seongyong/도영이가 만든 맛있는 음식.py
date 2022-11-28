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


def add_iter(iter0, iter2, return_type):
    return return_type(sum(e) for e in zip(iter0, iter2))


# visited = set()

# def dfs_return(dfs_result, current_position):
#     visited.remove(current_position)
#     return dfs_result


# main logic
from itertools import combinations

num_ingredients = int(read_line())
ingredients = read_lines_as(list, int, ' ', num_ingredients)
result = 1000000000 ** 10
for num_used_ingr in range(1, num_ingredients + 1):
    for comb in combinations(ingredients, num_used_ingr):
        total_s, total_b = 1, 0
        for sour, bitter in comb:
            total_s *= sour
            total_b += bitter
        result = min(result, abs(total_s - total_b))

print(result)
