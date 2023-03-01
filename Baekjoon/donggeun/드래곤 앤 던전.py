import sys, math
input = sys.stdin.readline

def fight(atk, max_hp):
    cur_hp = max_hp
    
    for t,a,h in room:
        if t == 1:
            if math.ceil(cur_hp/a) >= math.ceil(h/atk): # cur_hp >= monster_hp
                # 용사 이김
                cur_hp -= a*(math.ceil(h/atk) - 1) # 마지막 공격은 죽어서 못함
                if cur_hp <= 0: # 필요한 조건인가?
                    return False
            else: # 지는 경우
                return False
        else: # 포션 있음
            atk += a
            cur_hp = min(max_hp, cur_hp + h)

    return cur_hp > 0

n,atk = map(int,input().split())

room = [list(map(int,input().split())) for _ in range(n)]
ans = []
st, ed = 0, (10**6)**2


while st <= ed:
    mid = (st + ed) // 2
    if fight(atk, mid):
        ans.append(mid)
        ed = mid - 1
    else:
        st = mid + 1

print(min(ans))