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



# main logic
def find_parent(x, parent_of:list):
    if parent_of[x] != x:
        parent_of[x] = find_parent(parent_of[x], parent_of)

    return parent_of[x]


def union(x, y, parent_of:list):
    x = find_parent(x, parent_of)
    y = find_parent(y, parent_of)

    if x < y:
        parent_of[y] = x
    else:
        parent_of[x] = y


num_cities = int(read_line())
read_line()
graph = read_lines_as(list, int, ' ', num_cities)
plan = read_line_as(list, lambda x: int(x) - 1, ' ')

parent_of = list(i for i in range(num_cities))
for r in range(len(graph)):
    for c in range(len(graph[r])):
        if graph[r][c]:
            union(r, c, parent_of)

possible = True
for now, _next in zip(plan, plan[1:]):
    if parent_of[now] != parent_of[_next]:
        possible = False
        break

if possible:
    print("YES")
else:
    print("NO")
