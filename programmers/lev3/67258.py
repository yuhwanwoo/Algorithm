def solution(gems):
    answer = []
    get_set = set(gems)
    
    dic = dict()
    dic[gems[0]] = 1
    size = len(get_set)
    
    left = 0
    right = 1

    while left < right:
        if len(dic) == size:
            answer.append((right - left, left, right))

            dic[gems[left]] -= 1

            if dic[gems[left]] == 0:
                del dic[gems[left]]
            left += 1

        elif len(dic) < size:
            if right >= len(gems):
                break
            dic[gems[right]] = dic.get(gems[right], 0) + 1
            right += 1
        else:
            
            if dic[gems[left]] > 0:
                dic[gems[left]] -= 1
            else:
                del dic[gems[left]]
            left += 1
    
    answer.sort()
    
    ans = [answer[0][1] + 1, answer[0][2]]
    
    return ans

gems = ["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]
solution(gems)