import heapq
import sys
from collections import *


def read_line():
    return sys.stdin.readline().rstrip()


def read_line_as(return_type, element_type, seperator):
    return return_type(map(element_type, read_line().split(seperator)))



dirs = [(0, 1), (-1, 0), (0, -1), (1, 0)]
pos_in_field = lambda p, f: 0 <= p[0] < len(f) and 0 <= p[1] < len(f[p[0]])
adjacencies_of = lambda pos: (map(lambda d: (pos[0] + d[0], pos[1] + d[1]), dirs))


# main logic
n_col, n_row = read_line_as(list, int, ' ')
box = [read_line_as(list, int, ' ') for _ in range(n_row)]

q = deque([(r, c) for r in range(n_row) for c in range(n_col)
           if box[r][c] == 1])
while q:
    now = q.popleft()
    for a in adjacencies_of(now):
        if not pos_in_field(a, box) or box[a[0]][a[1]] != 0:
            continue
        box[a[0]][a[1]] = box[now[0]][now[1]] + 1
        q.append(a)

result = -2
has_unripe = False
for r in range(n_row):
    for c in range(n_col):
        if box[r][c] == 0:
            has_unripe = True
            break
        result = max(result, box[r][c])

if has_unripe:
    print(-1)
else:
    print(result - 1)
