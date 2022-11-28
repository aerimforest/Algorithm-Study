import sys

target = int(sys.stdin.readline().rstrip())
m, n = map(int, sys.stdin.readline().split())

left = [int(sys.stdin.readline().rstrip()) for _ in range(m)]
right = [int(sys.stdin.readline().rstrip()) for _ in range(n)]

lsum, rsum = [0, sum(left)], [0, sum(right)]
for i in range(m):
    for j in range(m):
        if i == j:
            continue
        elif i < j <= m:
            tmp = sum(left[i:j])
            if tmp > target:
                continue
            lsum.append(tmp)
        else:  # j < i
            tmp = sum(left[i:] + left[:j])
            if tmp > target:
                continue
            lsum.append(tmp)

for i in range(n):
    for j in range(n):
        if i == j:
            continue
        elif i < j <= n:
            tmp = sum(right[i:j])
            if tmp > target:
                continue
            rsum.append(tmp)
        else:  # j < i
            tmp = sum(right[i:] + right[:j])
            if tmp > target:
                continue
            rsum.append(tmp)

lsum.sort()
rsum.sort()

ans = 0
lleft, lright = len(lsum), len(rsum)
lp, rp = 0, lright - 1

while lp < lleft and rp >= 0:
    tmp = lsum[lp] + rsum[rp]

    if tmp == target:
        lcnt, rcnt = 0, 0
        origin = lsum[lp]

        while lp < lleft and origin == lsum[lp]:
            lcnt += 1
            lp += 1
        origin = rsum[rp]

        while rp >= 0 and origin == rsum[rp]:
            rcnt += 1
            rp -= 1

        ans += (lcnt * rcnt)

    elif tmp < target:
        lp += 1
    else:
        rp -= 1

print(ans)