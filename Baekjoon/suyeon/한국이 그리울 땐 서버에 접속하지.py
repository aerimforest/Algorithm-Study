import sys


def is_match(file_name):
    return start_len + end_len <= len(file_name) and file_name[:start_len] == start and file_name[-end_len:] == end


n = int(input())

start, end = sys.stdin.readline().strip().split('*')
start_len, end_len = len(start), len(end)

for _ in range(n):
    print("DA" if is_match(sys.stdin.readline().strip()) else "NE")
