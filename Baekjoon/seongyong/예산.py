import sys


def read_line():
    return sys.stdin.readline().rstrip()


n = int(read_line())
s = list(map(int, read_line().split()))
m = int(read_line())
low, high = 0, max(s)
while low <= high:
    mid = (low + high) // 2
    num = 0
    for i in s:
        if i >= mid: num += mid
        else: num += i
    if num <= m: low = mid + 1
    else: high = mid - 1
print(high)
