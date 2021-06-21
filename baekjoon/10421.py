from itertools import product

s1=int(input())
arr1=list(map(int,input().split()))
s2=int(input())
arr2=list(map(str,input().split()))

cnt=0
arr=[""]*s1
arr=["222","22","444","444"]
# 222  0
#  22  1

def dfs(i):
    global cnt
    if i==s1:
        
        cnt+=1
        return
    if i==0 or i==1:
        temp_arr=list(map(''.join,product(arr2,repeat=arr1[i])))
        print(temp_arr)
        # print(temp_arr)
        for num in temp_arr:
            arr[i]=num
            dfs(i+1)
            arr[i]="0"
    if i>=2 and i<s1-1:
        # 틀리더라도 여기가 틀렸을것
        temp=str(int(arr[0])*int(arr[1][arr1[1]+1-i]))
        if len(temp)!=arr1[i]:
            return
        for j in temp:
            if j not in arr2:
                return
        arr[i]=temp
        dfs(i+1)
        arr[i]="0"
    if i==(s1-1):
        tmp=0
        if s1==3:
            temp=str(int(arr[0])*int(arr[1]))
            if len(temp)!=arr1[i]:
                return
            for j in temp:
                if j not in arr2:
                    # print(temp,j)
                    return
            cnt+=1
        else:
            for j in range(2,s1):
                tmp+=int(arr[j]+(j-2)*"0")
            temp=str(tmp)
            # print(arr)
            if len(temp)!=arr1[i]:
                return
            for j in temp:
                if j not in arr2:
                    # print(temp,j)
                    return
            arr[i]=temp
            dfs(i+1)
            arr[i]=""
    return

dfs(0)
print(cnt)