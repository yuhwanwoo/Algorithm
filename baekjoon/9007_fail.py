import bisect
import sys

input=sys.stdin.readline

t=int(input())

def flag(num,answer):
    if abs(num-k)<abs(k-answer):
        return num
    return answer

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
    list1[0].sort()
    list1[1].sort()
    
    ans=0
    # print(list1)
    answer=0
    for l in list1[0]:
        answer=0
        temp=k-l
        idx=bisect.bisect_left(list1[1],temp)
        hap=0
        if idx==0:
            answer=temp+list1[1][0]
        elif idx==len(list1[1]):
            answer=temp+list1[1][idx-1]
            # print(answer)
        else:
            left_hap=temp+list1[1][idx-1]
            right_hap=temp+list1[1][idx]
            answer=left_hap
            if abs(k-left_hap)>abs(right_hap-k):
                answer=right_hap
        if abs(ans-k)>abs(answer-k):
            # print(answer,idx)
            ans=answer
    print(ans)