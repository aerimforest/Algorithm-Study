import sys


def read_int_map():
    return map(int, sys.stdin.readline().rstrip('\n').split(' '))


_ = sys.stdin.readline()
arr = list(read_int_map())
sub_sum = [0 for i in range(len(arr))]
sub_sum[0] = arr[0]
max_honey = 0

for i in range(1, len(arr)):
    sub_sum[i] = arr[i] + sub_sum[i - 1]

# case on right
for i in range(1, len(arr) - 1):
    max_honey = max(max_honey, 2 * sub_sum[-1] - arr[0] - arr[i] - sub_sum[i])

# case on left
for i in range(1, len(arr) - 1):
    max_honey = max(max_honey, sub_sum[-1] - arr[-1] - arr[i] + sub_sum[i - 1])

# case in middle
for i in range(1, len(arr) - 1):
    max_honey = max(max_honey, sub_sum[i] - arr[0] + sub_sum[-1] - sub_sum[i - 1] - arr[-1])

print(max_honey)
