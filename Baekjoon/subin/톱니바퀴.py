import sys
from collections import deque

wheels = []
wheels.append(deque([-1]))

for _ in range(4):
    wheel = deque(list(input()))
    wheels.append(wheel)

K = int(sys.stdin.readline())
rotation = []
for _ in range(K):
    rotation.append(list(map(int, sys.stdin.readline().split())))


def rotating(num, d):
    if d == 1:
        wheels[num].appendleft(wheels[num].pop())
    else:
        wheels[num].append(wheels[num].popleft())


for num, d in rotation:
    cnt_left = 0
    cnt_right = 0
    temp = num
    for i in range(temp, 1, -1):
        if wheels[i - 1][2] != wheels[i][6]:
            cnt_left += 1
        else:
            break
    temp = num
    for i in range(temp, 4, 1):
        if wheels[i + 1][6] != wheels[i][2]:
            cnt_right += 1
        else:
            break

    rotating(num, d)

    left_d = -(d)
    right_d = -(d)
    for i in range(num - 1, num - cnt_left - 1, -1):
        rotating(i, left_d)
        left_d *= -1

    for i in range(num + 1, num + cnt_right + 1):
        rotating(i, right_d)
        right_d *= -1

result = 0
for index, i in enumerate(wheels[1:]):
    if i[0] == '1':
        if index == 0:
            result += 1
        elif index == 1:
            result += 2
        elif index == 2:
            result += 4
        elif index == 3:
            result += 8

print(result)