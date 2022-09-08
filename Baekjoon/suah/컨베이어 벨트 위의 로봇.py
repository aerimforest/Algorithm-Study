from collections import deque
import sys
input = lambda : sys.stdin.readline().strip()

n, k = map(int, input().split())
belt = deque(list(map(int, input().split())))
robot = deque([0] * n)
step = 0

while 1:
    belt.rotate(1)
    robot.rotate(1)
    robot[-1] = 0     # 로봇이 내려가는 부분

    if sum(robot):
        for i in range(n-2, -1, -1):
            if robot[i] == 1 and robot[i + 1] == 0 and belt[i + 1] >= 1:
                robot[i+1] = 1
                robot[i] = 0
                belt[i+1] -= 1
        robot[-1] = 0  # 로봇이 내려가는 부분

    if robot[0] == 0 and belt[0] >= 1:
        robot[0] = 1
        belt[0] -= 1
    step += 1
    if belt.count(0) >= k:
        break

print(step)
