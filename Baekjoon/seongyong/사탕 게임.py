import sys


def read_line():
    return sys.stdin.readline().rstrip()


def read_line_as(return_type, element_type, seperator):
    return return_type(map(element_type, read_line().split(seperator)))



dirs = [(0, 1), (0, -1), (-1, 0), (1, 0)]
adjacencies_of = lambda pos: (map(lambda d: (pos[0] + d[0], pos[1] + d[1]), dirs))
pos_in_field = lambda row, col, f: 0 <= row < len(f) and 0 <= col < len(f[row])

# main logic
size = int(read_line())
field = [list(read_line()) for _ in range(size)]

result = 0
for r in range(size):
    for c in range(size):
        for a in adjacencies_of((r, c)):
            if not pos_in_field(a[0], a[1], field):
                continue
            field[r][c], field[a[0]][a[1]] = field[a[0]][a[1]], field[r][c]

            top, bottom = r, r
            while top - 1 >= 0 and field[top - 1][c] == field[r][c]:
                top -= 1
            while bottom + 1 < size and field[bottom + 1][c] == field[r][c]:
                bottom += 1

            left, right = c, c
            while left - 1 >= 0 and field[r][left - 1] == field[r][c]:
                left -= 1
            while right + 1 < size and field[r][right + 1] == field[r][c]:
                right += 1

            result = max(max(bottom - top + 1, right - left + 1), result)
            field[r][c], field[a[0]][a[1]] = field[a[0]][a[1]], field[r][c]

print(result)
