def union(str1_arr, str2_arr):
    sum_cnt = 0
    str1_set = set(str1_arr)
    str2_set = set(str2_arr)

    sum_set = str1_set | str2_set
    for ele in sum_set:
        cnt1 = str1_arr.count(ele)
        cnt2 = str2_arr.count(ele)
        sum_cnt += max(cnt1, cnt2)
        print(ele, max(cnt1, cnt2))

    return sum_cnt

def inter(str1_arr, str2_arr):
    sum_cnt = 0
    str1_set = set(str1_arr)
    str2_set = set(str2_arr)

    for ele in str1_set:
        if ele in str2_set:
            cnt1 = str1_arr.count(ele)
            cnt2 = str2_arr.count(ele)
            sum_cnt += min(cnt1, cnt2)
    
    return sum_cnt

def solution(str1, str2):
    answer = 0

    str1_arr = []
    str2_arr = []

    str1 = str1.upper()
    str2 = str2.upper()
    
    str1_size = len(str1)
    str2_size = len(str2)

    for i in range(1, str1_size):
        if str1[i - 1].isalpha() and str1[i].isalpha():
            str1_arr.append(str1[i - 1: i + 1])
    
    for i in range(1, str2_size):
        if str2[i - 1].isalpha() and str2[i].isalpha():
            str2_arr.append(str2[i - 1: i + 1])
    
    inter_cnt = inter(str1_arr, str2_arr)
    union_cnt = union(str1_arr, str2_arr)
    
    if inter_cnt == 0 and union_cnt == 0:
        answer = 65536
    else:
        answer = int(inter_cnt / union_cnt * 65536)

    return answer

str1 = "FRANCE"
str2 = "french"
str1 = "handshake"
str2 = "shake hands"
str1 = "aa1+aa2"
str2 = "AAAA12"
str1 = "E=M*C^2"
str2 = "e=m*c^2"
print(solution(str1, str2))