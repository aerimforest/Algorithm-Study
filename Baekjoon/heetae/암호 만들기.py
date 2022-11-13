import sys
from itertools import combinations

input = sys.stdin.readline

l, c = map(int, input().split())
alph = sorted(list(map(str, input().split())))
vowels = ['a', 'e', 'i', 'o', 'u']
res = []

comb = combinations(alph, l)

for c in comb:
    j = 0
    m = 0
    for i in range(l):
        if c[i] in vowels:
            m += 1
        else:
            j += 1
    if m >= 1 and j >= 2:
        print(''.join(c))
