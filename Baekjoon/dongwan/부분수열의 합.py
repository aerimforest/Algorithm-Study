N,S = map(int,input().split())
res = 0 

def dfs(x,ssum) :
    global N,S,res
    
    if x >= N :
        return
    tmp_sum = ssum + lst[x]

    if tmp_sum == S :
        res += 1 
    
    dfs(x+1,tmp_sum)
    dfs(x+1,tmp_sum-lst[x])
    
lst = list(map(int,input().split()))

lst.sort()

dfs(0,0)
print(res)