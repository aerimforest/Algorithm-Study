# (참고)

import sys
input = sys.stdin.readline

times = list(input().split())
start = int(times[0][:2] + times[0][3:])
end = int(times[1][:2] + times[1][3:])
stream = int(times[2][:2] + times[2][3:])
student = dict()
cnt = 0

while True:
    log = input()
    if len(log) < 3:
        break
    time, name = log.split()
    time = int(time[:2] + time[3:])
    if time <= start:
        student[name] = 1
    elif end <= time <= stream:
        if student.get(name) and student[name] == 1:
            cnt += 1
            student[name] = 0

print(cnt)