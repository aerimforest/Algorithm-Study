import heapq 

def solution(jobs) :
    
    #작업수 , 마지막 작업 시간,정답 
    cnt, time, ans = 0,-1,0
    #heap 
    heap = []
    jobs.sort()
    
    now = jobs[0][0]
    
    #작업이 남았다면
    while cnt < len(jobs) :
        #시작시간과 소요시간을 돌며 
        for s,t in jobs :
            #현재 시작할 수 있으면
            if time < s <= now :
                #힙에 소요시간이 적은 순으로 넣음 
                heapq.heappush(heap, (t,s))
        #힙이 차있으면
        if heap :
            #작업 수 추가 
            cnt += 1
            #마지막 작업 시간은 현재시간
            time = now 
            #소요시간과 시작시간
            t, s = heapq.heappop(heap)
            #현재 시간에 소요시간을 더해 갱신
            now += t 
            #  정답에 현재 시간에서 대기시간을 뺀 값을 더함 
            ans += (now - s)
        #힙에 요소가 없으면 현재시간 올리기
        else :
            now += 1 

    return ans//len(jobs)
    