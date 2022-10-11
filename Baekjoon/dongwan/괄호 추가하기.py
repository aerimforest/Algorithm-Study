def dfs(idx, total):
    global ans

    #연산자의 끝에 도달하면 멈추고, 최대값 반환 
    if idx == len(operator):
        ans = max(ans, int(total))
        return

    #첫번째 가능 값 계산하기 
    first = str(eval(total + operator[idx] + nums[idx + 1]))
    #다음 연산으로 
    dfs(idx + 1, first)

    #아직 마지막 연산이 아니면 
    if idx + 1 < len(operator):
        #뒤에 괄호를 가정하고 연산해보기 
        tmp = str(eval(nums[idx + 1] + operator[idx + 1] + nums[idx + 2]))
        #괄호 연산한 값을 현재 값에서 연산하기 
        second = str(eval(total + operator[idx] + tmp))
        # 괄호 연산을 마쳤으므로 연산 한 번건너뛰고 완전탐색 
        dfs(idx + 2, second)



n = int(input())
num_lst = input()
nums, operator = [], []
ans = -(10e9)

for x in num_lst:
    if x.isdigit() :
        nums.append(x)
    else :
        operator.append(x)

dfs(0, nums[0])
print(ans)