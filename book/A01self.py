# 내 생각에 이건 틀림
n=int(input())
fear=list(map(int,input().split()))

answerlist=[0]*(len(fear)+1)

for i in range(len(fear)):
    answerlist[fear[i]]+=1

cnt=0

for i in range(1,len(answerlist)):
    if answerlist[i]>=i:
        cnt+=1

print(cnt)