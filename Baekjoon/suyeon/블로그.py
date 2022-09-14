import sys

input = lambda: sys.stdin.readline()

n, x = map(int, input().split())
visitor_counts = [0] + list(map(int, input().split()))

for i in range(1, len(visitor_counts)):
    visitor_counts[i] += visitor_counts[i - 1]

answer = [visitor_counts[i] - visitor_counts[i - x] for i in range(x, len(visitor_counts))]

max_visitor = max(answer)
max_count = answer.count(max_visitor)

if not max_visitor:
    print('SAD')
else:
    print(max_visitor)
    print(max_count)
