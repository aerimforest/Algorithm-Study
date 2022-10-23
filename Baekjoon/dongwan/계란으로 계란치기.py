#계란으로 계란을 치면
## 각 계란의 내구도는 상대 계란 무게만큼 깎임 
##내구도가 0이 되는 순간 계란은 깨짐 

# 1. 가장 왼쪽 계란 집음
# 2. 손에든 계란으로 깨지지 않은 계란 중 하나를 깸 
## 2-1. 손에든 계란이 깨졌거나 깨지지 않은 계란이 없으면 치지않고 넘어감 
## 2-2. 손에 든 계란을 원래 자리에 내려놓고 3번 과정을 진행
#3. 가장 최근에 든 계란의 오른쪽 계란을 들고 2번 과정 진행 
# 가장 최근 계란이 마지막 계란이면 종료 

import sys
input = sys.stdin.readline
N = int(input())

eggs = [list(map(int,input().split())) for _ in range(N)]
# 내구도, 무게 
# 가장 많은 계란을 깨려면 ?
answer = 0

def check(eggs):
  count = 0
  for egg in eggs:
    if egg[0] <= 0:
      count += 1
  return count

def dfs(index, eggs):
  global answer

  if index == N:
    answer = max(answer, check(eggs))
    return 

  if eggs[index][0] <= 0:
    # 현재 계란의 내구도가 다 달았을 때 다음 계란으로 넘어간다.
    dfs(index + 1, eggs)
  else:
    # 현재 계란의 내구도가 남아있을 때 다른 계란들과 부딪친다. (현재 계란 제외, 내구도가 없는 계란 제외)
    is_all_broken = True
    for i in range(len(eggs)):
      if index != i and eggs[i][0] > 0:
        is_all_broken = False
        eggs[index][0] -= eggs[i][-1]
        eggs[i][0] -= eggs[index][-1]
        dfs(index + 1, eggs)
        eggs[index][0] += eggs[i][-1]
        eggs[i][0] += eggs[index][-1]
    # 모든 계란이 깨져있는 경우 dfs를 바로 빠져나와준다.
    if is_all_broken:
      dfs(N, eggs)
dfs(0,eggs)
print(answer)
# #가장 왼쪽 계란을 든다
# i = 0

# while True :
#     # print(i)

#     #최근 계란이 마지막이면 종료 
#     if i == N :
#         break 
    
#     shield,power = eggs[i][0],eggs[i][1] 
#     #계란이 깨졌으면 다음 계란으로 
#     if eggs[i][0] <= 0 :
#         i += 1 
#         continue
#     print(eggs)
#     target_power = 10e9
#     target = i
#     for idx in range(N) :
#         if idx == i or eggs[idx][0] < 0:
#             continue
#         if eggs[idx][1] <= target_power :
#             if eggs[idx][1] == target_power :
#                 if eggs[idx][0] < eggs[target][0] :
#                     target = idx 
#             target_power = eggs[idx][1]
#             target = idx
#     if target == i :
#         break
#     eggs[i][0] -= eggs[target][1]
#     eggs[target][0] -= eggs[i][1]
#     print(f'me: {i}')
#     print(f'target : {target}')
#     print(eggs)

#     #계란이 안깨졌으면 다음 계란 
#     if eggs[target][0] > 0 :
#         i += 1 
#         continue
