import sys
from collections import *


def read_line():
    return sys.stdin.readline().rstrip()


def read_line_as(return_type, element_type, seperator):
    return return_type(map(element_type, read_line().split(seperator)))


def read_lines_as(row_type, col_type, seperator, line_number):
    return [read_line_as(row_type, col_type, seperator)
            for _ in range(line_number)]


for _ in range(int(read_line())):
    t, n_vertices, n_edges = map(int, read_line().split(' '))
    g_edges = defaultdict(list)
    in_degree = [0] * (n_vertices + 1)
    for _ in range(n_edges):
        _from, to = map(int, read_line().split(' '))
        g_edges[_from].append(to)
        in_degree[to] += 1

    strahler_order = [0 if in_degree[v] else 1 for v in range(n_vertices+1)]
    need_to_plus = [False] * (n_vertices + 1)
    q = deque(v for v in range(1, n_vertices + 1)
              if in_degree[v] == 0)
    while q:
        now = q.popleft()
        for next_v in g_edges[now]:
            if strahler_order[now] > strahler_order[next_v]:
                strahler_order[next_v] = strahler_order[now]
                need_to_plus[next_v] = True
            elif strahler_order[now] == strahler_order[next_v] \
                    and need_to_plus[next_v]:
                strahler_order[next_v] += 1
                need_to_plus[next_v] = False

            in_degree[next_v] -= 1
            if in_degree[next_v] == 0:
                q.append(next_v)

    print(f'{t} {strahler_order[-1]}')
