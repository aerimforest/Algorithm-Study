import sys
from collections import *


def read_line():
    return sys.stdin.readline().rstrip()


def read_line_as(return_type, element_type, seperator):
    return return_type(map(element_type, read_line().split(seperator)))


def read_lines_as(row_type, col_type, seperator, line_number):
    return [read_line_as(row_type, col_type, seperator)
            for _ in range(line_number)]


dirs = [(0, 1), (-1, 0), (0, -1), (1, 0)]
pos_in_field = lambda p, f: 0 <= p[0] < len(f) and 0 <= p[1] < len(f[p[0]])
adjacencies_of = lambda pos: (map(lambda d: (pos[0] + d[0], pos[1] + d[1]), dirs))

# main logic
field = [read_line() for _ in range(int(read_line().split(' ')[0]))]
q = deque([(0, 0)])
visited = [[1 if r == 0 and c == 0 else 0
            for c in range(len(field[r]))] for r in range(len(field))]
while q:
    now = q.popleft()
    for a in adjacencies_of(now):
        if not pos_in_field(a, field) \
                or field[a[0]][a[1]] == '0' \
                or visited[a[0]][a[1]] != 0:
            continue
        visited[a[0]][a[1]] = visited[now[0]][now[1]] + 1
        if a[0] == len(field) - 1 and a[1] == len(field[-1]):
            q.clear()
            break
        q.append(a)

print(visited[-1][-1])
