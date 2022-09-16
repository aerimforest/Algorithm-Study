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

# def dfs_return(dfs_result, current_position):
#     visited.remove(current_position)
#     return dfs_result


from collections import deque

que = deque()


def bfs_checkin(current_position):
    visited.add(current_position)
    que.append(current_position)


# main logic
a, b, c = sorted(read_n_map(int, ' '))
bfs_checkin((a, b, c))
while que:
    a, b, c = que.popleft()
    if a == b == c:
        break
    one_two = tuple(sorted((2 * a, b - a, c)))
    one_three = tuple(sorted((2 * a, b, c - a)))
    two_three = tuple(sorted((a, 2 * b, c - b)))

    if one_two not in visited:
        bfs_checkin(one_two)
    if one_three not in visited:
        bfs_checkin(one_three)
    if two_three not in visited:
        bfs_checkin(two_three)

print(int(a == b == c))
