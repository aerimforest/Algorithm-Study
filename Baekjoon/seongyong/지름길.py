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


# visited = set()

# def dfs_return(dfs_result, current_position):
#     visited.remove(current_position)
#     return dfs_result


# main logic
from collections import deque

min_distance = 12 * 10000 + 1


def dfs(now_pos, road_length, moved_distance, shortcuts: deque):
    global min_distance
    if now_pos == road_length:
        min_distance = min(moved_distance, min_distance)
        return
    if not shortcuts:
        min_distance = min(moved_distance + road_length - now_pos,
                           min_distance)
        return

    shortcut = shortcuts.popleft()
    shortcut_start, shortcut_end, shortcut_distance = shortcut
    can_go_shortcut = now_pos <= shortcut_start and shortcut_end <= road_length
    if can_go_shortcut:
        moved_distance += shortcut_start - now_pos
        now_pos = shortcut_start

    # not going this shortcut
    dfs(now_pos, road_length, moved_distance, shortcuts)

    # going this shortcut
    if can_go_shortcut:
        dfs(shortcut_end, road_length, moved_distance + shortcut_distance, shortcuts)

    # appendleft for other dfs calls
    shortcuts.appendleft(shortcut)


num_shortcuts, road_length = read_n_map(int, ' ')
shortcuts = deque(sorted(read_lines_as(list, int, ' ', num_shortcuts),
                         key=lambda shortcut: shortcut[0]))
dfs(0, road_length, 0, shortcuts)
print(min_distance)
