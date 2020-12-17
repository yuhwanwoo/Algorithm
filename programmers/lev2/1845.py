def solution(nums):
    answer = 0
    num_dict=dict()
    sel_num=len(nums)//2

    for i in nums:
        num_dict[i]=num_dict.get(i,0)+1
    
    if sel_num>=len(num_dict.keys()):
        answer=len(num_dict.keys())
    else:
        answer=sel_num
    return answer

nums=[3,1,2,3]
solution(nums)