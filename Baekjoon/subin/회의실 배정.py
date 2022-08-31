n = int(input())
meeting = [list(map(int, input().split())) for _ in range(n)]
meeting.sort(key=lambda x: (x[1], x[0]))

count = 1
start, end = meeting[0]

for i in range(1, n):
    if end <= meeting[i][0]:
        count += 1
        end = meeting[i][1]

print(count)