def twoSum(nums,target):

    num_dic=dict()

    for i in range(len(nums)):
        #num_dic[nums[i]].append((nums[i],i))
        num_dic[nums[i]]=num_dic.get(nums[i],[])+[(nums[i],i)]
        num_dic[target-nums[i]]=num_dic.get(target-nums[i],[])
        
    print(num_dic)
        
    for num in num_dic.keys():
        if num_dic[num]:
            n,i=num_dic[num].pop(0)
        if num_dic[target-n]:
            return [i,num_dic[target-n][0][1]]
    
    return 0




nums=[2,7,11,15]
target=9
nums=[3,2,4]
target=6
nums=[2,5,5,11]
target=10
print(twoSum(nums,target))
