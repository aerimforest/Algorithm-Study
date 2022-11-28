import sys

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
lines = []
uf = [-1] * (N + 1)

for _ in range(M):
    lines.append(list(map(int, sys.stdin.readline().split())))

lines.sort(key=lambda x: x[2])


def find(a):
    if uf[a] < 0:
        return a
    uf[a] = find(uf[a])
    return uf[a]


def merge(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return False
    ## 부모를 바꾸는 과정
    uf[b] = a
    return True


answer = 0
count = 0
for line in lines:
    if merge(line[0], line[1]):
        count += 1
        answer += line[2]
    if count == (N - 1):
        print(answer)
        break
