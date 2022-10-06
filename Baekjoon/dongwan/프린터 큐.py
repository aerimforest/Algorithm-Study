from collections import deque

T = int(input())


for t in range(T) :
    
    #N : 문서의 개수
    #M : 몇번째로 인쇄되었는지 궁금한 문서 
    N,M = map(int,input().split())
    papers = deque((map(int,input().split())))
    cnt = 0
    while papers :
        MAX = max(papers)
        x = papers.popleft()
        M -= 1 

        if MAX == x :
            cnt += 1 
            if M < 0 :
                print(cnt) 
                break 
        else :
            papers.append(x)
            if M < 0 :
                M = len(papers)-1