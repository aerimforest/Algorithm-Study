import sys


def get_max_meeting():
    count, last_time = 0, 0

    for start_time, end_time in sorted(meetings, key=lambda x: (x[1], x[0])):
        if start_time >= last_time:
            count += 1
            last_time = end_time

    return count


n = int(input())
meetings = [tuple(map(int, sys.stdin.readline().split())) for _ in range(n)]

print(get_max_meeting())
