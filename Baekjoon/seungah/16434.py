# 16434 드래곤 앤 던전 (이분 탐색)

import sys
input = sys.stdin.readline

# N: 방의 개수, atk: 용사 초기 공격력
N, atk = map(int, input().split())

#  방 정보 나타내는 세 개 정수 t, a, h
## t 1인 경우, 공격력 a이고 생명력 h인 몬스터
## t 2인 경우, 용사 atk += a, 용사 curlHP += h 포션 존재

room = []
for i in range(N):
    room.append(list(map(int, input().split())))

left, right = 0, sys.maxsize
answer = 0

def binarySearch(atk, hp, maxHP):
    for t,a,h in room:
        if t == 1: # 몬스터, 공격력 a 생명력 h
            if h%atk == 0: # 나머지가 0이면 용사가 먼저 몬스터 죽임 (2에서 끝)
                hp = hp - (h//atk-1) * a
            else: # 아니면 공격 다 받음
                hp = hp - (h//atk *a)
        else: # 포션
            hp = min(maxHP, hp+h) # maxHP 넘으면 안됨
            atk += a
        if hp <= 0: # hp가 0 이하면 maxHP 높여서 다시 이분탐색
            return False
    return True

while left <= right:
    mid = (left + right) // 2
    if binarySearch(atk,mid,mid):
        right = mid-1
        answer = mid
    else:
        left = mid+1

print(answer)