import sys

input = sys.stdin.readline

N = int(input())
cranes = list(map(int, input().split()))

M = int(input())
boxs = list(map(int, input().split()))

cranes.sort(reverse=True)
boxs.sort(reverse=True)

if boxs[0] > cranes[0]:
    print(-1)
    sys.exit()
else:
    time = 0

    while boxs:
        if not boxs:
            break

        for crane in cranes:
            for box in boxs:
                if crane >= box:
                    boxs.remove(box)
                    break

        time += 1

    print(time)