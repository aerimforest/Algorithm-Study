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


def dfs(rice_cakes, previous, day, result, visited):
    if day >= len(rice_cakes):
        return True

    for rice_cake in rice_cakes[day][1:]:
        if rice_cake != previous and not visited[day][rice_cake]:
            visited[day][rice_cake] = True
            result.append(rice_cake)
            if dfs(rice_cakes, rice_cake, day + 1, result, visited):
                return True
            result.pop()

    return False


n = int(read_line())
rice_cakes = read_lines_as(list, int, ' ', n)
result = list()
visited = [[False for _ in range(10)] for _ in range(n)]
dfs(rice_cakes, -1, 0, result, visited)
if result:
    for e in result: print(e)
else:
    print(-1)
