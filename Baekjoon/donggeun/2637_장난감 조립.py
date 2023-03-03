import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
toy = dict()
original = dict()

for i in range(1, n+1):
    toy[i] = []

for _ in range(m):
    x,y,k = map(int,input().split())
    toy[x].append([y,k])

for i in range(1, n+1):
    if toy[i] == []: # 기본부품
        original[i] = 0


def assembly(k):
    if toy[k] == []:
        original[k] += 1
        return
    else:
        for part, cnt in toy[k]:
            for _ in range(cnt):
                assembly(part)

assembly(n)

for part, cnt in original.items():
    print(part, cnt)