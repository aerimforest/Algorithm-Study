def solution(numbers):
    answer = []
    for n in numbers: 
        b = list('0' + bin(n)[2:])
        idx = ''.join(b).rfind('0')
        b[idx] = '1'
        
        # 홀수인 경우
        if n % 2 == 1: 
            b[idx+1] = '0'
            
        answer.append(int(''.join(b), 2))
    return answer
