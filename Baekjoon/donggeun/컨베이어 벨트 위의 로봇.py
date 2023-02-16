from collections import deque
import sys
input = sys.stdin.readline

def is_over(belt: deque, k: int):
    return belt.count(0) >= k

n,k = map(int,input().split())
belt = deque(list(map(int,input().split())))
robot = deque([0]*2*n)
level = 1

while True:

    belt.rotate(1)
    robot.rotate(1)

    # 박스 제거
    robot[n-1] = 0
    
    for i in range(n-2, -1, -1):
        if robot[i] and not robot[i+1] and belt[i+1]:
            belt[i+1] -= 1
            robot[i+1], robot[i] = robot[i], 0

    if not robot[0] and belt[0]:
        robot[0] = 1
        belt[0] -= 1

    if is_over(belt, k):
        break

    level += 1

print(level)