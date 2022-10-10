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
k, n = read_n_map(int, ' ')
cables = read_lines(k, int)
right = max(cables)+1
left = 0
mid: int
while left < right:
    mid = (left + right) // 2
    count = 0
    for cable in cables:
        count += cable // mid

    if count < n:
        right = mid
    else:
        if right == left + 1:
            break
        left = mid

print(mid)
