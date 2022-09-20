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


def read_lines_as(row_type, col_type, seperator, line_number):
    return [read_line_as(row_type, col_type, seperator)
            for _ in range(line_number)]


visited = set()

# def dfs_return(dfs_result, current_position):
#     visited.remove(current_position)
#     return dfs_result


# main logic
from collections import deque
from collections import defaultdict

q = deque()
N, M = read_n_map(int, ' ')
g = defaultdict(list[tuple[int, ...]])
for _ in range(N - 1):
    node1, node2, distance = read_n_map(int, ' ')
    g[node1].append((node2, distance))
    g[node2].append((node1, distance))

for _ in range(M):
    start, end = read_n_map(int, ' ')
    q.clear()
    visited.clear()
    q.append((start, 0))
    visited.add(start)
    while q:
        now, dist_to_now = q.popleft()
        if now == end:
            print(dist_to_now)
            break

        for _next, dist in g[now]:
            if _next not in visited:
                visited.add(_next)
                q.append((_next, dist_to_now + dist))
