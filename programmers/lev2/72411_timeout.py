from itertools import combinations

def solution(orders, course):
    answer = []
    
    dic = dict()
    menu_set = set()
    com_list = []

    for order in orders:
        for e in order:
            dic[e] = dic.get(e, 0) + 1
            if dic[e] == 2:
                menu_set.add(e)
    
    menu_set = list(menu_set)

    menu_set.sort()

    num_dict = dict()

    for num in course:
        com_list += list(map(''.join, combinations(menu_set, num)))
        num_dict[num] = 0
    
    ans_dic = dict()

    for order in orders:
        for ele in com_list:
            size = len(ele)
            cnt = 0
            for st in ele:
                if st in order:
                    cnt += 1
            if cnt == size:
                ans_dic[ele] = ans_dic.get(ele, 0) + 1
        
    for key in list(ans_dic.keys()):
        if ans_dic[key] < 2:
            del ans_dic[key]
                
    print(ans_dic)
    for key in ans_dic.keys():
        size = ans_dic[key]
        key_size = len(key)
        if size > num_dict[key_size]:
            num_dict[key_size] = size
    for key in ans_dic.keys():
        if ans_dic[key] == num_dict[len(key)]:
            answer.append(key)
    
    answer.sort()
    print(answer)
    return answer

orders = ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]
course = [2,3,4]
orders = ["XYZ", "XWY", "WXA"]
course = [2,3,4]
solution(orders, course)