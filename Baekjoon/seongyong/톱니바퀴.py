from collections import deque
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


def rotate_left(target: int, gears: list[deque], cw: int):
    if target == -1: return

    if gears[target + 1][-2] != gears[target][2]:
        rotate_left(target - 1, gears, cw * -1)
        gears[target].rotate(cw)


def rotate_right(target: int, gears: list, cw: int):
    if target == 4: return

    if gears[target - 1][2] != gears[target][-2]:
        rotate_right(target + 1, gears, cw * -1)
        gears[target].rotate(cw)


def rotate_gear(target: int, gears: list, cw: int):
    rotate_left(target - 1, gears, cw * -1)
    rotate_right(target + 1, gears, cw * -1)
    gears[target].rotate(cw)


gears = read_lines(4, lambda line: deque(map(int, list(line))))
for _ in range(int(read_line())):
    target, cw = read_n_map(int, ' ')
    target -= 1
    rotate_gear(target, gears, cw)

result = 0
for gear in gears:
    result += int(gear[0])
print(result)
