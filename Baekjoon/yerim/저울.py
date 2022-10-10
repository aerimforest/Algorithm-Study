# [2437] 저울
import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
arr.sort()

sum = 1

for num in arr :
    if sum < num :
        break
    sum += num

print(sum)