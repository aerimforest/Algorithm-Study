import sys
input = sys.stdin.readline

n = int(input())
nums= list(map(int,input().split()))

arr = [0]*n
idx = 1

for i in nums:
    now = i
    for j in range(n):
        if arr[j] == 0:
            if now==0:
                arr[j] = idx
                break
            now -= 1
    idx += 1

print(*arr)