import math

n = int(input())
array = list(map(int, input().split()))
prime = []

def check(num):
    if num <= 1:
        return False
    for i in range(2, int(num**0.5)+1):
        if num%i == 0:
            return False
    return True

for i in array:
    if check(i):
        prime.append(i)

if not prime:
    print(-1)
else:
    result = prime[0]
    for j in range(1, len(prime)):
        result = math.lcm(result, prime[j])
    print(result)