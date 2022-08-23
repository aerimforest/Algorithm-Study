import sys


def read_int_map():
    return map(int, sys.stdin.readline().rstrip('\n').split(' '))


if __name__ == '__main__':
    _, K = read_int_map()
    students = list(read_int_map())
    gaps = list()
    for i in range(1, len(students)):
        gaps.append(students[i] - students[i - 1])

    gaps.sort()
    print(sum(gaps[:len(students) - K]))
