import sys

n = int(sys.stdin.readline())
array = list(map(int, input().split()))

array.sort()
minTake = sys.maxsize

for i in range(n-2):
    start = i + 1
    end = n - 1
    while start < end:
        take = array[i] + array[start] + array[end]
        if abs(take) < minTake:
            minTake = abs(take)
            result = [array[i], array[start], array[end]]
        if take < 0:
            start += 1
        elif take > 0:
            end -= 1
        else:
            break
            
print(result[0], result[1], result[2])
