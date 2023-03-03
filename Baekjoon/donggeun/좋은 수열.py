def bt(s):
    if len(s) == n:
        print(*s,sep='')
        exit(0)
    for i in nums:
        if check(s, i):
            s.append(i)
            bt(s)
            s.pop()

def check(word,k):
    tmp = word + [k]
    for i in range(2, len(tmp)+1, 2):
        for j in range(0, len(tmp)-i+1):
            if tmp[j:i+j-i//2] == tmp[j+i//2:i+j]:
                return False
    return True

n = int(input())
nums = [1,2,3]
bt([])