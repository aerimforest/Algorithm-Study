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


#
# def add_iter(iter0, iter2, return_type):
#     return return_type(sum(e) for e in zip(iter0, iter2))
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
#
#
# def adjacencies_of(target: tuple):
#     return (add_iter(d, target, tuple) for d in dirs)
#
#
# def pos_in_field(pos: tuple, field: list):
#     return 0 <= pos[0] < len(field) and 0 <= pos[1] < len(field[pos[0]])


# main logic
n_vertices = int(read_line())
n_edges = int(read_line())
# graph = defaultdict(list)
graph = [[] for _ in range(n_vertices + 1)]
for orig, dest, weight in read_lines_as(list, int, ' ', n_edges):
    graph[orig].append([weight, dest])
start, end = read_n_map(int, ' ')

INF = 100001 * 100000
min_cost_to = [INF] * (n_vertices + 1)
pre_vertex_of = [-1] * (n_vertices + 1)
min_cost_to[start] = 0
q = [[min_cost_to[start], start]]
while q:
    cost_to_now, now = heapq.heappop(q)
    for w, next_v in graph[now]:
        new_cost = cost_to_now + w
        if new_cost < min_cost_to[next_v]:
            min_cost_to[next_v] = new_cost
            pre_vertex_of[next_v] = now
            heapq.heappush(q, [min_cost_to[next_v], next_v])

min_route = [end]
now = end
while now != start:
    now = pre_vertex_of[now]
    min_route.append(now)
min_route.reverse()

print(min_cost_to[end])
print(len(min_route))
print(*min_route)
