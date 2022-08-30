import sys

N = int(sys.stdin.readline())
prev_count = [ 1 for _ in range(10) ]
prev_count[0] = 0
cur_count = [ 0 for _ in range(10) ]

for _ in range(2, N + 1):
    for i in range(10):
        if i == 0:
            cur_count[i] = prev_count[i + 1]
        elif i == 9:
            cur_count[i] = prev_count[i - 1]
        else:
            cur_count[i] = prev_count[i - 1] + prev_count[i + 1]
    for i in range(10):
        prev_count[i] = cur_count[i]

print(sum(prev_count) % 1000000000)