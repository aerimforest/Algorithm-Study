S, T = input(), input()

while len(T) != len(S):
    T = T[:-1] if T[-1] == 'A' else T[:-1][::-1]

print(1 if S == T else 0)
