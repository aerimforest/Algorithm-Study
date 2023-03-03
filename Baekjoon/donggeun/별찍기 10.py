def counting_star(lis):
    tmp = []
    m = len(lis)
    for i in range(3*m):
        if (i//m == 1):
            tmp.append(lis[i%m] + " "*m + lis[i%m])
        else:
            tmp.append(lis[i%m]*3)
    return tmp

n = int(input())
t = 0
star = ["***","* *", "***"]

while n != 3:
    n //=3
    t += 1

for i in range(t):
    star = counting_star(star)

for s in star:
    print(s)