#배열을 돌리도록하자
n=int(input())

# 0 지우고 뒤에 추가
def remove_zero(arr):
    for i in range(len(arr)):
        l=len(arr)
        for j in range(l):
            if arr[i][j]==0:
                arr[i].pop(j)
                arr[i].append(0)
                j-=1
                l-=1
    return arr


# 배열 회전
def rot_arr(arr):
    length=len(arr)
    temp=[[0]*length for _ in range(length)]
    for i in range(length):
        for j in range(length):
            temp[j][length-i-1]=arr[i][j]

    return temp

def solution(arr,n):
    if n==5:
        max_num=0
        for i in arr:
            max_num=max(max_num,max(i))
        return max_num
    max_n=0
    for _ in range(4):
        length=len(arr)
        arr=rot_arr(arr)
        
        temp=[[0]*length for _ in range(length)]
        # 배열 복사 (temp=arr 이렇게 했더니 주소도 같아져서 같이 바뀜)
        for i in range(length):
            for j in range(length):
                temp[i][j]=arr[i][j]
        # 배열 복사 끝


        for i in range(length):
            for j in range(length-1):
                if temp[i][j]==temp[i][j+1] and temp[i][j]!=0:
                    temp[i][j]+=temp[i][j+1]
                    temp[i][j+1]=0
        max_n=max(max_n,solution(remove_zero(temp),n+1))
        
        

    return max_n


arr=[]

for _ in range(n):
    arr.append(list(map(int,input().split())))

print(solution(arr,0))
