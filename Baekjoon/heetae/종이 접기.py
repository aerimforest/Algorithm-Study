from sys import stdin

input = stdin.readline

T = int(input())


def is_available_str(str):
    todo = list(str)

    while len(todo) >= 3:
        for i in range(2, len(todo), 2):
            if todo[i - 2] == todo[i]:
                return False

        next_todo = []
        for i in range(1, len(todo), 2):
            next_todo.append(todo[i])

        todo = next_todo

    return True


for _ in range(T):
    curInput = str(input().rstrip())

    if is_available_str(curInput):
        print("YES")
    else:
        print("NO")
