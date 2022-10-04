from sys import stdin

s = list(stdin.readline().strip())
stack = []

for i in range(len(s)):
    if s[i] != "(" and s[i] != ")":
        if i == len(s) - 1:
            s[i] = 1
        elif s[i + 1] != "(":
            s[i] = 1

for i in s:
    if i != ")":
        stack.append(i)
    else:
        value = 0
        while True:
            stop = stack.pop()
            if stop == "(": break
            value += stop

        stack.append(value * int(stack.pop()))
sum = 0
for i in stack:
    sum += i
print(sum)