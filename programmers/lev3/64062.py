# 징검다리 건너기
def cal(stones,k,mid):
    cnt=0
    for stone in stones:
        if stone<=mid:
            cnt+=1
        else:
            cnt=0
        if cnt==k:
            return False
    return True

def solution(stones, k):
    answer=0
    maxi=max(stones)
    
    left=0
    right=maxi

    while left<=right:
        mid=(left+right)//2
        
        if cal(stones,k,mid):
            answer=mid
            left=mid+1
        else:
            right=mid-1
    
    print(answer)
    return answer+1
stones=[2, 4, 5, 3, 2, 1, 4, 2, 5, 1]
k=3
solution(stones,k)