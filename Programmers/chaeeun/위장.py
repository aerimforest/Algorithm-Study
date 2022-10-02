def solution(clothes):
    
    name_list = []
    for i in range(len(clothes)):
        name_list.append(clothes[i][1])

    counts = {}
    for i in name_list:
        try: counts[i] += 1
        except: counts[i] = 1

    answer = 1
    for i in counts.values():
        answer *= (i+1)
    answer -= 1
    # print(answer)
    
    return answer
    
# solution([["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]])
# solution([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]])