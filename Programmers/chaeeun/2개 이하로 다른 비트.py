# (참고)

def solution(numbers) :
    answer = []
    for number in numbers :
        bin_num = list('0' + bin(number)[2:]) # 앞에는 0b 형태로 나와서 slicing
        index = ''.join(bin_num).rfind('0')
        # find(), rfind() : 문자열 내부에서 특정 문자가 어디에 위치하는지 찾기
        # find() - 왼쪽부터 / rfind() - 오른쪽부터
        bin_num[index] = '1'

        ### 다음 숫자로 넘어가기 (+=1)
        if number % 2 == 1 :
            bin_num[index+1] = '0'

        answer.append(int(''.join(bin_num), 2)) # 2: 2진수를 int로 바꿔줌
      # '_'.join(리스트) : ['a','b','c'] => 'a_b_c'

    return answer
