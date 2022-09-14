import sys
input = sys.stdin.readline

n, x = map(int, input().split())
visitor = list(map(int, input().split()))

if max(visitor) == 0:
    print("SAD")
else:
    value = sum(visitor[:x])
    max_value = value
    cnt = 1

    for i in range(x, n):
        value += visitor[i]
        value -= visitor[i-x]

        if value > max_value:
            max_value = value
            cnt = 1
        elif value == max_value:
            cnt += 1

    print(max_value)
    print(cnt)