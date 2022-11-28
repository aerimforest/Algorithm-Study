import sys

input = sys.stdin.readline

x = int(input())
word = input().strip()
origin = word
word_list = [word]

cnt = 0
while True:
    cnt += 1
    new_word = ''
    mid = len(word) // 2
    for idx in range(mid):
        new_word += word[idx] + word[len(word) - 1 - idx]

    if len(word) % 2 != 0:
        new_word += word[len(word) // 2]

    word = new_word
    if origin == word:
        break
    word_list.append(word)
print(word_list[-x % len(word_list)])
