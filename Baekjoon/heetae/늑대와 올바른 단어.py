import re

result = list()
word = input()
c = 0
p = re.compile("w+o+l+f+")
m = p.findall(word)

if len(m) == 0:
    result.append(False)
else:
    for j in m:
        c = c + len(j)
    if c == len(word):
        for i in m:
            if i.count('w') == i.count('o') == i.count('l') == i.count('f'):
                result.append(True)
            else:
                result.append(False)
    else:
        result.append(False)
if all(result):
    print("1")
else:
    print("0")
