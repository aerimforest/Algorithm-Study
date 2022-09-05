import sys

input = lambda: sys.stdin.readline()

s, e, q = input().split()

answer = 0
participants = set()

while True:
    chatting = input()

    if len(chatting) <= 5:
        break

    time, name = chatting.split()

    if time <= s:
        participants.add(name)
        continue

    if e <= time <= q and name in participants:
        answer += 1
        participants.remove(name)

print(answer)
