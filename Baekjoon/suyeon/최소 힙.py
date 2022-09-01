import sys
from heapq import heappop, heappush

min_heap = []

for _ in range(int(input())):
    num = int(sys.stdin.readline().strip())

    if num:
        heappush(min_heap, num)
        continue

    print(heappop(min_heap) if min_heap else 0)

