N = int(input())

res = 10e9

def is_good(num) :

    l = len(num)
    for idx in range(1,l//2+1) :
        if num[-idx:] == num[-(idx*2):-idx] :
            return False 
    else :
        return True

def dfs(x) :
    global N, res 
    if len(x) == N :
        print(x)
        exit()
    for i in ['1','2','3'] :
        if is_good(x + i) :
            dfs(x+i)
    return
lst = ['1','2','3','4']

dfs('1')