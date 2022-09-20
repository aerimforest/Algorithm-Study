import sys

input = lambda: sys.stdin.readline()


def get_primes(n):
    is_prime = [True] * (n + 1)

    is_prime[0] = is_prime[1] = False

    for i in range(2, int(n ** 0.5) + 1):
        if not is_prime[i]:
            continue

        for j in range(i * i, len(is_prime), i):
            is_prime[j] = False

    return is_prime


a, b = map(int, input().split())
sqrt_b = int(b ** 0.5)

answer = 0
primes = get_primes(sqrt_b)

for num in range(2, sqrt_b + 1):
    if not primes[num]:
        continue

    sqrt_num = num * num

    while sqrt_num <= b:
        if a <= sqrt_num:
            answer += 1

        sqrt_num *= num

print(answer)
