#8901 화학 제품

t=int(input())
for _ in range(t):
    a,b,c=map(int,input().split())
    ab,bc,ca=map(int,input().split())
    ans=0
    for i in range(min(a,b)+1):
        atmp=a
        btmp=b
        ctmp=c
        money=i*ab
        atmp-=i
        btmp-=i
        if (bc>=ca):
            j=min(btmp,ctmp)
            money+=j*bc
            btmp-=j
            ctmp-=j
            k=min(atmp,ctmp)
            money+=k*ca
            atmp-=k
            ctmp-=k
        else:
            k=min(atmp,ctmp)
            money+=k*ca
            atmp-=k
            ctmp-=k
            j=min(btmp,ctmp)
            money+=j*bc
            btmp-=j
            ctmp-=j
        if money>ans:
            ans=money
    print(ans)
