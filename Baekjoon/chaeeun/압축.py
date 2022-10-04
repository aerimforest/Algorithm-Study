# [참고]

from sys import stdin

s = stdin.readline().strip()
stack = list()

for i in range(len(s)):
    if s[i] == "(":
        stack.append("(")
    elif s[i] == ")": 
        cnt = 0
        while True:
            tmp = stack.pop()
            if tmp == "(": 
                break
            cnt += tmp     
        stack.append(int(stack.pop()) * cnt)  
    elif i < len(s) - 1 and s[i + 1] == "(": 
        stack.append(int(s[i])) 
    else: 
        stack.append(1) 

answer = 0
for st in stack:
    answer += st
print(answer)