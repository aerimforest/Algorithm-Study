import re
for _ in range(int(input())):
    s = input()
    print("YES" if re.fullmatch('(100+1+|01)+', s) != None else "NO")