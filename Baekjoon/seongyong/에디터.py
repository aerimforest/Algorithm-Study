import sys


def read_line():
    return sys.stdin.readline().rstrip()


def read_line_as(return_type, element_type, seperator):
    return return_type(map(element_type, read_line().split(seperator)))


# main logic
left, right = list(read_line()), list()
for _ in range(int(read_line())):
    cmd = read_line()
    if cmd == 'L' and left:
        right.append(left.pop())
    elif cmd == 'D' and right:
        left.append(right.pop())
    elif cmd == 'B' and left:
        left.pop()
    elif cmd[0] == 'P':
        inserted_str = cmd.split(' ')[-1]
        left.append(inserted_str)

print(''.join(left) + ''.join(reversed(right)))
