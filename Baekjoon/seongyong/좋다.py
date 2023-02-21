import sys
from collections import *


def read_line():
    return sys.stdin.readline().rstrip()


def read_line_as(return_type, element_type, seperator):
    return return_type(map(element_type, read_line().split(seperator)))


# main logic
read_line()
arr = sorted(read_line_as(list, int, ' '))
count = 0
for i in range(len(arr)):
    small, big = 0, len(arr)-1
    while small < big \
            and small < len(arr) and big >= 0:
        if small == i or big == i:
            small += (small == i)
            big -= (big == i)
        elif arr[small] + arr[big] < arr[i]:
            small += 1
        elif arr[small] + arr[big] > arr[i]:
            big -= 1
        else:
            count += 1
            break
print(count)

