"""
회전하는 것을 함수 3개(시계방향90, 반시계방향90, 180) 만드는 것이 효율적일까 아니면
시계방향90도 회전 함수 하나를 만들어서 x1, x2, x3 번 쓰는게 효율적일까
고민하였고, 유지보수를 위해 함수 하나를 사용하기로 정함.

해결해야할 문제 
시간초과, 놓친 경우의 수
"""
from itertools import permutations, combinations_with_replacement, product
import sys
input = sys.stdin.readline

def bomb_qual(R,B,G,Y):
    return 7*R + 5*B + 3*G + 2*Y


# 0: 12시, 1: 시계방향 90도, 2: 180도, 3: 시계방향 270
def clockwise(lis, status):
    res = [[] for _ in range(4)]
    for k in range(status):
        res = [[] for _ in range(4)]
        for i in range(4):
            for j in range(3, -1, -1):
                res[i].append(lis[j][i])
        lis = res
    return lis

def add_efficacy(pre, new):
    if pre + new <= 0:
        return 0
    if pre + new >= 9:
        return 9
    return pre + new

def add_element(pre, new):
    if new == "W":
        return pre
    return new

def position(status):
    # 0: 1행1열, 1: 1행2열, 2: 2행1열, 3: 2행2열
    if status == 0:
        return [0,0]
    if status == 1:
        return [0,1]
    if status == 2:
        return [1,0]
    return [1,1]


def calculate(efficacy, element):
    # 시초뜨면 리스트로 변환해보기
    bomb = {"R":0, "B":0, "G":0, "Y":0, "W":0}
    for i in range(5):
        for j in range(5):
            effi, ele = efficacy[i][j], element[i][j]
            bomb[ele] += effi
    return bomb_qual(bomb["R"], bomb["B"], bomb["G"], bomb["Y"])

def sum_effi(pre, new, x,y):
    res = [[0]*5 for _ in range(5)]
    for i in range(4):
        for j in range(4):
            res[i+x][j+y] = add_efficacy(pre[i+x][j+y], new[i][j])
    return res

def sum_ele(pre, new, x, y):
    res = [["W"]*5 for _ in range(5)]
    for i in range(4):
        for j in range(4):
            res[i+x][j+y] = add_element(pre[i+x][j+y], new[i][j])
    return res

def print_tmp(effi, ele):
    for i in range(5):
        for j in range(5):
            print(effi[i][j], ele[i][j], sep='', end=' ')
        print()

def collocate(A_effi, A_ele, B_effi, B_ele, C_effi, C_ele):
    efficacy = [[0]*5 for _ in range(5)]
    element = [["W"]*5 for _ in range(5)]
    res = []
    for a,b,c in combinations_with_replacement(range(4), 3):
        ax,ay = position(a)[0], position(a)[1]
        bx,by = position(b)[0], position(b)[1]
        cx,cy = position(c)[0], position(c)[1]

        # 각 위치에서 더하기
        # print("위치:", ax,ay,bx,by,cx,cy)
        # efficacy = sum_effi(efficacy, A_effi, ax, ay)
        # element = sum_ele(element, A_ele, ax, ay)
        # print_tmp(efficacy, element)
        # print("="*12)
        # efficacy = sum_effi(efficacy, B_effi, bx, by)
        # element = sum_ele(element, B_ele, bx, by)
        # print_tmp(efficacy, element)
        # print("="*12)

        # efficacy = sum_effi(efficacy, C_effi, cx, cy)
        # element = sum_ele(element, C_ele, cx, cy)
        # print_tmp(efficacy, element)

        efficacy = sum_effi(efficacy, A_effi, ax, ay)
        efficacy = sum_effi(efficacy, B_effi, bx, by)
        efficacy = sum_effi(efficacy, C_effi, cx, cy)

        element = sum_ele(element, A_ele, ax, ay)
        element = sum_ele(element, B_ele, bx, by)
        element = sum_ele(element, C_ele, cx, cy)

        # print_tmp(efficacy, element)
        # input()

        res.append(calculate(efficacy, element))
    
    return max(res)


n = int(input())
res = []
stuff = dict()
for i in range(n):
    efficacy = [list(map(int,input().split())) for _ in range(4)]
    element = [list(map(str, input().rstrip().split())) for _ in range(4)]
    stuff[i] = [efficacy, element]

for a,b,c in permutations(range(n), 3):
    for u,v,w in product(range(4), repeat=3):
        # if a == 1 and b == 2 and c == 0 and u == 3 and v == 0 and w == 3:
        #     print(f"{a}번 재료: {u}방향, {b}번 재료: {v}방향, {c}번 재료: {w}방향")
        A_effi, A_ele = clockwise(stuff[a][0],u), clockwise(stuff[a][1],u)
        B_effi, B_ele = clockwise(stuff[b][0],v), clockwise(stuff[b][1],v)
        C_effi, C_ele = clockwise(stuff[c][0],w), clockwise(stuff[c][1],w)
        res.append(collocate(A_effi, A_ele, B_effi, B_ele, C_effi, C_ele))

print(max(res))