import sys


def read_line():
    return sys.stdin.readline().rstrip()


def read_n_map(to_map, seperator):
    return map(to_map, read_line().split(seperator))


def read_line_as(return_type, element_type, seperator):
    return return_type(read_n_map(element_type, seperator))


def read_lines(trim_each_line, line_number):
    if trim_each_line:
        return [trim_each_line(read_line()) for _ in range(line_number)]
    else:
        return [read_line() for _ in range(line_number)]


visited = set()


def dfs_return(dfs_result, current_position):
    visited.remove(current_position)
    return dfs_result


# main logic
wines = read_lines(int, int(read_line()))
memo = [0 for _ in range(len(wines))]
memo[0] = wines[0]
if len(memo) >= 2:
    memo[1] = wines[0] + wines[1]
if len(memo) >= 3:
    memo[2] = max(wines[0] + wines[2], wines[1] + wines[2], memo[1])
    for i in range(3, len(memo)):
        memo[i] = max(wines[i] + wines[i - 1] + memo[i - 3],
                      wines[i] + memo[i - 2],
                      memo[i - 1])

print(max(memo))
