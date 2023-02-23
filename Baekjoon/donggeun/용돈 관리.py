import sys
input = sys.stdin.readline

def is_possible(money: list[int], k: int, m: int):
    day = k # 잔고
    cnt = 1 # 인출 횟수
    for i in money:
        if k < i:
            return False

        if day - i < 0:
            day = k
            cnt += 1
        day -= i

    return m >= cnt

n,m = map(int,input().split())
money = [int(input()) for _ in range(n)]
st,ed = 0, sum(money)
ans = 0

while st <= ed:
    mid = (st + ed) // 2

    if is_possible(money, mid, m):
        ans = mid
        ed = mid - 1
    else:
        st = mid + 1

print(ans)
# print(is_possible([100,400,300,100,500,101,400], 400, 5))