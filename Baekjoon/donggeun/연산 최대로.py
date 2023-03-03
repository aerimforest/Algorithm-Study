# n 범위가 작음
# 완탐
from collections import defaultdict
import sys
input = sys.stdin.readline

# 연산자 집어넣는 경우의 수 구하기
def bt(s, idx_dict):
    if len(s) == p+q:
        global res
        if s not in res:
            res.append(s[::])
        return
    
    for idx, val in enumerate(oper):
        if not idx_dict[idx]:
            s.append(val)
            idx_dict[idx] = True
            bt(s, idx_dict)
            idx_dict[idx] = False
            s.pop()

# 괄호 속 수식 계산
def calc(exp, st, ed):
    if st + 1 == ed:
        return exp[st]
    res = exp[i]
    for i in range(st+1, ed, 2):
        if exp[i]:
            res *= exp[i+1]
        else:
            res += exp[i+1]

    return res

n = int(input())
nums = list(map(int,input().split()))
p,q = map(int,input().split())
res = []
oper = [0]*p + [1]*q # 0은 더하기, 1은 곱하기
bt([], defaultdict(bool))
print(res)