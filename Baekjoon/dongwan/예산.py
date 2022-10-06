from glob import glob


n = int(input())
lst = list(map(int,input().split()))
Money = int(input())


def binary_search() :
    m = 0 
    M = max(lst)

    while m <= M :
        ans = 0
        middle = (m+M)//2
        for i in range(n) :
            if lst[i] > middle :
                ans += middle
            else :
                ans += lst[i]
            
        if ans <= Money :
            m = middle + 1
        else :
            M = middle -1 
    return M

print(binary_search())
    
    
