S = input()
T = input()

n = len(T)
def solution(x) :
    #T 길이에 도달했을 때, 일치하면 1 출력 후 종료 
    if len(x) == n :
        if x == T :
            print(1)
            exit()
        else :
            return 
    #A를 붙여보고 
    sol1 = x+'A'
    #들어갈 수 있는지 확인 들어갈 가능성이 있으면 재귀 
    if sol1 in T or sol1[::-1] in T :
        solution(sol1)
    #B를 붙여보고 확인 
    sol2 = x+'B'
    if sol2 in T or sol2[::-1] in T :
        solution(sol2[::-1])


solution(S) 

print(0)