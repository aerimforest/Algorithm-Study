import sys
from itertools import combinations

essential = {'a', 'c', 'i', 'n', 't'}


def get_max_words():
    max_words = 0

    for alphabet_list in combinations(other_set, k - 5):
        alphabet_list = set(alphabet_list) | essential

        count = 0

        for word in words:
            if word <= alphabet_list:
                count += 1

        if max_words < count:
            max_words = count

    return max_words


n, k = map(int, sys.stdin.readline().split())

words, all_set = [], set()

for _ in range(n):
    temp = set(sys.stdin.readline().strip())

    all_set |= temp
    words.append(temp)

if k < 5:
    print(0)
else:
    other_set = all_set - essential
    print(get_max_words() if len(other_set) > k - 5 else n)
