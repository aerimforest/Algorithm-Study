import sys
input = sys.stdin.readline

n,m = map(int,input().split())
nums = list(map(int,input().split()))
mod_arr = [0]*m
res = 0
tot = 0

for num in nums:
    tot += num
    mod_arr[tot%m] += 1

res += mod_arr[0]

for mod in mod_arr:
    res += (mod * (mod - 1)) // 2


print(res)