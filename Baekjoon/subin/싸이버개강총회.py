import sys

input = sys.stdin.readline
s, e, q = map(str, input().split())

# 해시 사용
data = dict()
result = dict()

while True:
    try:
        time, nick = input().split()
        if time <= s:
            data[nick] = time
        elif e <= time <= q:
            if nick in data:
                result[nick] = 1
    except:
        break

print(len(result))