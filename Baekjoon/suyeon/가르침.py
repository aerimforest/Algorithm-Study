import sys
from itertools import combinations

essential = {'a', 'c', 'i', 'n', 't'}


def is_read(word, k_alphabet):
    for alphabet in word:
        if alphabet not in k_alphabet and alphabet not in essential:
            return False

    return True


def get_max_words():
    max_words = 0

    for k_alphabet in combinations(base - essential, k - len(essential)):
        max_words = max(max_words, sum([True for word in words if is_read(word, set(k_alphabet))]))

    return max_words


n, k = map(int, input().split())
words, base = [], set()

for _ in range(n):
    temp = sys.stdin.readline().strip()[4:-4]

    words.append(temp)
    base.update(list(temp))

print(get_max_words() if k - len(essential) >= 0 else 0)
