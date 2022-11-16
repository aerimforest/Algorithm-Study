from collections import deque
import sys

input = sys.stdin.readline

n, k = map(int, input().split())
belt = deque(map(int, input().split()))
robots = deque([0] * 2 * n)

level = 1
while 1:
    belt.rotate(1)
    robots.rotate(1)
    robots[n - 1] = 0
    for i in range(n - 2, -1, -1):
        if robots[i] and not robots[i + 1] and belt[i + 1]:
            belt[i + 1] -= 1
            robots[i + 1], robots[i] = robots[i], 0
    robots[n - 1] = 0
    if not robots[0] and belt[0]:
        robots[0] = 1
        belt[0] -= 1
    if belt.count(0) >= k:
        print(level)
        break
    level += 1
