def twoSum(nums,target):

    num_dic = dict()

    for idx in range(len(nums)):
        num = nums[idx]
        if (target - num) in num_dic:
            return [num_dic.get(target - num), idx]
        num_dic[num] = idx

    print(num_dic)
    
    return 0

# nums=[2,7,11,15]
# target=9
# nums=[3,2,4]
# target=6
nums=[2,5,5,11]
target=10
print(twoSum(nums,target))