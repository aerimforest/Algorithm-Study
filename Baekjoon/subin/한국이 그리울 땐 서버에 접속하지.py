N = int(input())
A = list(map(str,input().split("*")))

for i in range(N):
    B = str(input())

    if len(B)<len(A[0])+len(A[1]):
        print("NE")
    else:
        if B[0:len(A[0])] == A[0] and B[len(B)-len(A[1]):len(B)] == A[1]:
            print("DA")
        else:
            print("NE")