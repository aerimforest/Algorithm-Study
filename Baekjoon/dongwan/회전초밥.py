import sys 

input = sys.stdin.readline

N,d,k,c = map(int,input().split())

#1번 조건 : 임의의 위치에서 k 개를 연속으로 먹은 경우 할인된 정액 가격 
#2번 조건 : 1번 행사에 참여할 경우, 쿠폰(c)에 적힌 초밥을 하나 추가로 제공 
sushi = [int(input()) for _ in range(N)]

res = 0

idx = 0 

while idx != N:
    maxi = idx + k
    set_sushi = set()
    alph = True
    for i in range(idx, maxi):
        i %= N
        set_sushi.add(sushi[i])

    cnt = len(set_sushi)
    if not c in set_sushi :
        cnt += 1
    if cnt == d :
        break 
    res = max(res, cnt)
    idx += 1 

print(res)
