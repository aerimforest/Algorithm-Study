import sys

def read_line():
    return sys.stdin.readline().rstrip()


def read_line_as(return_type, element_type, seperator):
    return return_type(map(element_type, read_line().split(seperator)))


# main logic
num_a, num_z, k = map(int, read_line().split(' '))
memo = [
    [[0, 1] if n_z else [0, 0] for n_z in range(num_z + 1)]
    for n_a in range(num_a + 1)]
for n_a in range(1, len(memo)):
    memo[n_a][0][0] = 1
    for n_z in range(1, len(memo[n_a])):
        memo[n_a][n_z][0] = sum(memo[n_a - 1][n_z])
        memo[n_a][n_z][1] = sum(memo[n_a][n_z - 1])

n_a, n_z = num_a, num_z
result = list()
while n_a or n_z:
    if k <= memo[n_a][n_z][0]:
        n_a -= 1
        result.append('a')
    elif k <= sum(memo[n_a][n_z]):
        k -= memo[n_a][n_z][0]
        n_z -= 1
        result.append('z')
    else:
        break

if not result:
    print(-1)
else:
    print(*result, sep='')
