import sys
from collections import *


def read_line():
    return sys.stdin.readline().rstrip()


def read_line_as(return_type, element_type, seperator):
    return return_type(map(element_type, read_line().split(seperator)))

# main logic
n_circles, n_numbers, n_tasks = map(int, read_line().split(' '))
circles = [read_line_as(deque, int, ' ') for _ in range(n_circles)]
for _ in range(n_tasks):
    x, r_dir, n_rotations = map(int, read_line().split(' '))
    for circle in circles[x - 1::x]:
        if r_dir == 0:
            circle.rotate(n_rotations)
        else:
            circle.rotate(-n_rotations)

    poses_to_remove = [(i, j) for i in range(n_circles) for j in range(n_numbers)
                       if circles[i][j] != 0 \
                       and (circles[i][j] == circles[i][j - 1] \
                            or circles[i][j] == circles[i][(j + 1) % n_numbers] \
                            or 1 <= i and circles[i][j] == circles[i - 1][j] \
                            or i < n_circles - 1 and circles[i][j] == circles[i + 1][j])]

    if poses_to_remove:
        for i, j in poses_to_remove:
            circles[i][j] = 0
    else:
        written_nums = [circles[i][j] for i in range(n_circles) for j in range(n_numbers)
                        if circles[i][j] != 0]
        average = sum(written_nums) / len(written_nums)
        for i in range(n_circles):
            for j in range(n_numbers):
                if circles[i][j] == 0:
                    continue
                if circles[i][j] > average:
                    circles[i][j] -= 1
                elif circles[i][j] < average:
                    circles[i][j] += 1

print(sum(sum(circle) for circle in circles))

