import heapq
import sys


def read_line():
    return sys.stdin.readline().rstrip()

# main logic
heap = list()
for i in range(int(read_line())):
    op = int(read_line())
    if op == 0:
        if len(heap):
            print(heapq.heappop(heap))
        else:
            print(0)
    else:
        heapq.heappush(heap, op)
