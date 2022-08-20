import sys

PALINDROME, PSEUDO_PALINDROME, NO_PALINDROME = 0, 1, 2


def is_pseudo_palindrome(word, start, end):
    if start + 1 == end:
        return PSEUDO_PALINDROME

    if word[start + 1] == word[end]:
        if is_palindrome(word, start + 2, end - 1, False) == PALINDROME:
            return PSEUDO_PALINDROME

    if word[start] == word[end - 1]:
        if is_palindrome(word, start + 1, end - 2, False) == PALINDROME:
            return PSEUDO_PALINDROME

    return NO_PALINDROME


def is_palindrome(word, start, end, pseudo_check):
    while start < end:
        if word[start] != word[end]:
            if pseudo_check:
                return is_pseudo_palindrome(word, start, end)

            return NO_PALINDROME

        start, end = start + 1, end - 1

    return PALINDROME


T = int(input())

for _ in range(T):
    s = sys.stdin.readline().strip()
    print(is_palindrome(s, 0, len(s) - 1, True))
