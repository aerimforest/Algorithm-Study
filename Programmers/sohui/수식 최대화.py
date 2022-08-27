from itertools import permutations


def split_expression(expression):
    operand = ''
    result = []
    for i, x in enumerate(expression):
        if x.isdigit():
            operand += x
            if i == len(expression) - 1:
                result.append(operand)
        else:
            result.append(operand)
            result.append(x)
            operand = ''
    return result


def solution(expression):
    ops = ["+", "-", "*"]
    pm = list(permutations(ops))
    max_value = 0
    for i in range(6):
        exp = split_expression(expression)
        for j in range(3):
            while pm[i][j] in exp:
                idx = exp.index(pm[i][j])
                exp = exp[:idx - 1] + [str(eval(''.join(exp[idx - 1:idx + 2])))] + exp[idx + 2:]
        max_value = max(max_value, abs(int(exp[0])))
    return max_value
