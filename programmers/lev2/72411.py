from itertools import combinations

def solution(orders, course):
    answer = []
    
    for num in course:
        com_list = []
        tmp_dict = dict()
        for order in orders:
            tmp = combinations(sorted(order), num)
            com_list += list(map(''.join, tmp))
        if len(com_list) > 0:
            for ele in com_list:
                tmp_dict[ele] = tmp_dict.get(ele, 0) + 1
            maximum = max(tmp_dict.values())
            for key in tmp_dict.keys():
                if tmp_dict[key] == maximum and maximum > 1:
                    answer.append(key)
    answer.sort()
    return answer


orders = ["XYZ", "XWY", "WXA"]
course = [2,3,4]
solution(orders, course)