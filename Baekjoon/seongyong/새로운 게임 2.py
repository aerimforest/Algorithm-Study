import heapq
import sys
from collections import *


def read_line():
    return sys.stdin.readline().rstrip()


def read_line_as(return_type, element_type, seperator):
    return return_type(map(element_type, read_line().split(seperator)))


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


dirs = [(0, 1), (0, -1), (-1, 0), (1, 0)]
# adjacencies_of = lambda pos: (map(lambda d: (pos[0] + d[0], pos[1] + d[1]), dirs))
pos_in_field = lambda p, f: 0 <= p[0] < len(f) and 0 <= p[1] < len(f[p[0]])
# [(0, 1), (-1, 0), (0, -1), (1, 0), (1, 1), (-1, 1), (1, -1), (-1, -1)]
# map(int, read_line().split(' '))


# main logic
field_size, num_pieces = map(int, read_line().split(' '))
field = [read_line_as(list, lambda x: [int(x), []], ' ')
         for _ in range(field_size)]
pieces_info = [read_line_as(list, lambda x: int(x) - 1, ' ')
               for _ in range(num_pieces)]
for p_i in range(len(pieces_info)):
    r, c, d_i = pieces_info[p_i]
    pieces_info[p_i][2] = dirs[d_i]
    field[r][c][1].append(p_i)

W, R, B = 0, 1, 2
turn = 0
ongoing = True
while ongoing and turn <= 1000:
    turn += 1
    for p_i in range(len(pieces_info)):
        r, c, d = pieces_info[p_i]
        order = field[r][c][1].index(p_i)
        to_move = field[r][c][1][order:]
        n_r, n_c = _next = (r + d[0], c + d[1])

        # change direction when blue or end of field
        if not pos_in_field(_next, field) or field[n_r][n_c][0] == B:
            d = tuple(-1 * e for e in d)
            n_r, n_c = _next = (r + d[0], c + d[1])
            pieces_info[p_i][2] = d

        # move pieces
        if not pos_in_field(_next, field) or field[n_r][n_c][0] == B:
            continue
        field[r][c][1] = field[r][c][1][:order]
        if field[n_r][n_c][0] == W:
            field[n_r][n_c][1].extend(to_move)
        elif field[n_r][n_c][0] == R:
            field[n_r][n_c][1].extend(reversed(to_move))

        if len(field[n_r][n_c][1]) >= 4:
            ongoing = False
            break

        # update pieces_info
        for moved in to_move:
            pieces_info[moved][0], pieces_info[moved][1] = n_r, n_c

if turn > 1000:
    print(-1)
else:
    print(turn)
