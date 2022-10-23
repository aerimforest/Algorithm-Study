from curses.ascii import isdigit


def calculate(num1, order, num2): 
    if order == '+':
        return num1 + num2
    elif order == '-':
        return num1 - num2
    else:
        return num1 * num2

def dfs(idx, cnt, flag, orders): 
    global count
    if cnt == count: 
        candidates.append(orders) 
        return
    if flag:
        dfs(idx+2, cnt+1, False, orders) 
    else: 
        dfs(idx, cnt+1, True, orders[:idx-1] + [calculate(orders[idx-1], orders[idx], orders[idx+1])] + orders[idx+2:]) 
        dfs(idx+2, cnt+1, False, orders) 

order = ['+', '-', '*']
N = int(input())
origin = input()
answer = -10e9
orders = []
candidates = []

num = ''
for unit in origin: # 주어진 계산식(input)을 숫자, 연산자로 분리한다.
    if unit.isdigit() :
        num += unit
    else:
        orders.append(int(num))
        orders.append(unit)
        num = ''
orders.append(int(num))

count = len(orders)//2
dfs(1, 0, False, orders)

for candidate in candidates:
    target = candidate[::-1]
    for i in range(len(candidate)//2):
        target.append(calculate(target.pop(), target.pop(), target.pop()))
    answer = max(answer, target[0])
print(answer)