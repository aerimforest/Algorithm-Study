import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int,input().split()))
res = [0]*n
stk = []
for i in range(n):
    while stk:
        if nums[i] <= stk[-1][0]:
            res[i] = stk[-1][1]+1
            stk.append([nums[i], i])
            break
        else:
            stk.pop()
    if not stk:
        stk.append([nums[i], i])

print(*res, sep=' ')