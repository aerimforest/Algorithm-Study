import sys

input = lambda: sys.stdin.readline()


def is_prime(x):
    for i in range(2, int(x ** 0.5) + 1):
        if not x % i:
            return False

    return True


n = int(input())
numbers = set(map(int, input().split()))

answer = 1
for number in numbers:
    if is_prime(number):
        answer *= number

print(answer if answer != 1 else -1)
