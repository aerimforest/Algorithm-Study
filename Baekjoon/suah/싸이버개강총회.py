import sys
input = lambda : sys.stdin.readline().strip()

s, e, q = input().split()
cnt = 0
arr = set()
while True:
    line = input()
    if len(line) < 5:
        break
    time, _id = line.split()
    if '0' < time <= s:
        arr.add(_id)
    elif e <= time <= q:
        if _id in arr:
            cnt += 1
            arr.remove(_id)

print(cnt)
