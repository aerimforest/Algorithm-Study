import sys
from heapq import heappush, heappop

input = lambda: sys.stdin.readline()

cards = []

for _ in range(int(input())):
    heappush(cards, int(input()))

if len(cards) == 1:
    print(0)
else:
    answer = 0

    while len(cards) > 1:
        bundle = heappop(cards) + heappop(cards)
        heappush(cards, bundle)

        answer += bundle

    print(answer)
