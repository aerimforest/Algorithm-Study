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
from collections import defaultdict
import heapq

graph = defaultdict(dict)
n = int(read_line())
for _ in range(int(read_line())):
    _from, to, updated_distance_to_now = read_n_map(int, ' ')
    graph[_from][to] = updated_distance_to_now
start, end = read_n_map(int, ' ')
        
distances_to = list(int(1e10) for _ in range(n + 1))
distances_to[start] = 0
que = list()
heapq.heappush(que, [start, distances_to[start]])
while que:
    now, updated_distance_to_now = heapq.heappop(que)
    if distances_to[now] < updated_distance_to_now:
        continue

    for _next, now_to_next in graph[now].items():
        if updated_distance_to_now + now_to_next < distances_to[_next]:
            distances_to[_next] = updated_distance_to_now + now_to_next
            heapq.heappush(que, [_next, distances_to[_next]])

print(distances_to[end])
