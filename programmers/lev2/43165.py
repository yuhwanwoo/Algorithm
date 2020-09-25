def dfs(i,target,numbers,data,ans):
    if i==len(numbers):
        if data==target:
            ans.append(data)
        return
    dfs(i+1,target,numbers,data+numbers[i],ans)
    dfs(i+1,target,numbers,data-numbers[i],ans)


def solution(numbers, target):
    answer = 0
    ans=[]
    dfs(1,target,numbers,numbers[0],ans)
    dfs(1,target,numbers,-numbers[0],ans)
    answer=len(ans)
    return answer