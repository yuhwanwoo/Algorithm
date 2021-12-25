import bisect
import sys

input=sys.stdin.readline

t=int(input())

for _ in range(t):
    k,n=map(int,input().split())
    arr=[]
    list1=[[],[]]
    for _ in range(4):
        arr.append(list(map(int,input().split())))
    
    for l in range(n):
        for m in range(n):
            list1[0].append(arr[0][l]+arr[1][m])
            list1[1].append(arr[2][l]+arr[3][m])
    list1[1].sort()
    # list1[0].sort()
    
    ans=int(1e9)
    
    # print(list1)
    for l in list1[0]:
        answer=-1
        temp=k-l
        idx=bisect.bisect_left(list1[1],temp)
        
        if idx==0:
            answer=l+list1[1][0]
            # print("ans1",idx,l,answer)
        elif idx==len(list1[1]):
            
            answer=l+list1[1][idx-1]
            # print("ans2",idx,l,answer)
        else:
            left_hap=l+list1[1][idx-1]
            right_hap=l+list1[1][idx]
            answer=left_hap
            
            if abs(k-left_hap)>abs(right_hap-k):
                
                answer=right_hap
            # print("ans3",idx,l,answer)
        if abs(ans-k)>abs(answer-k):
            # print(answer,idx)
            ans=answer
        if abs(ans-k)==abs(answer-k):
            if ans>answer:
                ans=answer
    print(ans)