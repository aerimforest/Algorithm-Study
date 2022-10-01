from itertools import combinations
def solution(clothes):
    dic = dict()
    is_dic = []
    
    for cloth,type in clothes :
        if type in is_dic :
            dic[type].append(cloth)
        else :
            dic[type] = [cloth]
            is_dic.append(type)
            
    result = 1 
    for key in dic.keys():
        result *= (len(dic[key]) +1)
        
    answer  = result -1
    
    return answer