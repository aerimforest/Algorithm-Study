from collections import deque
import sys
input = sys.stdin.readline

first = deque(list(map(int,input().rstrip())))
second = deque(list(map(int,input().rstrip())))
third = deque(list(map(int,input().rstrip())))
fourth = deque(list(map(int,input().rstrip())))

def move(num, wise):
    one = first[2] != second[6]
    two = second[2] != third[6]
    three = third[2] != fourth[6]
    if num == 1:
        first.rotate(wise)
        if one:
            second.rotate(-1*wise)
        if one and two:
            third.rotate(wise)
        if one and two and three:
            fourth.rotate(-1*wise)
    elif num == 2:
        second.rotate(wise)
        if one:
            first.rotate(-1*wise)
        if two:
            third.rotate(-1*wise)
        if two and three:
            fourth.rotate(wise)
    elif num == 3:
        third.rotate(wise)
        if two and one:
            first.rotate(wise)
        if two:
            second.rotate(-1*wise)
        if three:
            fourth.rotate(-1*wise)
    else:
        fourth.rotate(wise)
        if three and two and one:
            first.rotate(-1*wise)
        if three and two:
            second.rotate(wise)
        if three:
            third.rotate(-1*wise)

k = int(input())
for _ in range(k):
    num, wise = map(int,input().split())
    move(num, wise)

print(int("".join(map(str,[fourth.popleft(), third.popleft() ,second.popleft(), first.popleft()])), 2))
