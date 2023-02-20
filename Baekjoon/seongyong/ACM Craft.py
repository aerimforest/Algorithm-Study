import sys
from collections import *


def read_line():
    return sys.stdin.readline().rstrip()


def read_line_as(return_type, element_type, seperator):
    return return_type(map(element_type, read_line().split(seperator)))


# main logic
for _ in range(int(read_line())):
    n_vertices, n_edges = map(int, read_line().split(' '))
    time_cost = [0] + read_line_as(list, int, ' ')
    in_degree = [-1] + [0] * n_vertices
    g_next = defaultdict(list)
    for _ in range(n_edges):
        _from, to = map(int, read_line().split(' '))
        g_next[_from].append(to)
        in_degree[to] += 1
    end = int(read_line())

    q = deque(i for i in range(1, len(in_degree)) if in_degree[i] == 0)
    past_time = [time_cost[i] if in_degree[i] == 0 else 0
                 for i in range(n_vertices + 1)]
    while q:
        now = q.popleft()
        if now == end:
            break

        for _next in g_next[now]:
            past_time[_next] = max(past_time[now] + time_cost[_next],
                                   past_time[_next])
            in_degree[_next] -= 1
            if in_degree[_next] == 0:
                q.append(_next)

    print(past_time[end])

