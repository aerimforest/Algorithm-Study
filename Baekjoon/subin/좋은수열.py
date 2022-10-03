n=int(input())
arr=[1,2,3,4]

def check(num):
    length=len(num)

    for i in range(1,length):
        if num[-i:] == num[-(i*2):-i]:
            return False
    return True


def recursive(num):
    global answer,n

    if len(num)==n:
        print(num)
        exit()

    for i in '123':
        if check(num+str(i)):
            recursive(num+str(i))

recursive('1')