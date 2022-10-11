n = int(input())
exp = input()
numbers = []
operators = []
for i in range(0, len(exp), 2):
    numbers.append(int(exp[i]))
    if i+1 < n-1:
        operators.append(exp[i+1])


def calculate(lhs, rhs, operator):
    if operator == '+':
        return lhs + rhs
    elif operator == '-':
        return lhs - rhs
    elif operator == '*':
        return lhs * rhs


max_ans = -(1 << 31)


def go(index, is_jumped, result):  # 앞에서 계산 안하고 넘겼으면 is_jumped == True
    if index == len(operators):
        global max_ans
        max_ans = max(max_ans, result)
        return
    if is_jumped:
        next_result = calculate(result,
                                calculate(numbers[index], numbers[index+1], operators[index]), operators[index-1])
        go(index+1, False, next_result)
    else:
        # 1. 마지막 연산자만 아니면 그냥 넘김
        if index + 1 < len(operators):
            go(index+1, True, result)
        # 2. 계산하고 넘김
        go(index + 1, False, calculate(result,
           numbers[index+1], operators[index]))


go(0, False, numbers[0])
print(max_ans)