import sys
from collections import defaultdict, deque

input = lambda: sys.stdin.readline()


def bfs():
    queue = deque([stones])
    visited[stones] = True

    while queue:
        a, b, c = queue.popleft()

        if a == b == c:
            return 1

        for x, y in (a, b), (a, c), (b, c):
            if x == y:
                continue

            if x < y:
                y -= x
                x *= 2
            else:
                x -= y
                y *= 2

            z = sum_stone - x - y

            if not visited[(x, y, z)]:
                visited[(x, y, z)] = True
                queue.append((x, y, z))

    return 0


stones = tuple(map(int, input().split()))
sum_stone = sum(stones)

visited = defaultdict(bool)

print(0 if sum_stone % 3 else bfs())
