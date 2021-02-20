# 실패
n=int(input())

d=[n]
cnt=0
while True:
    print(d)
    if d[-1]<=1:
        break
    if d[-1]%5==0:
        print(11,cnt)
        d.append(d[-1]//5)
        cnt+=1
        continue
    if d[-1]%3==0:
        print(22,cnt)
        d.append(d[-1]//3)
        cnt+=1
        continue
    if d[-1]%2==0:
        print(33,cnt)
        d.append(d[-1]//2)
        cnt+=1
        continue
    d.append(d[-1]-1)
    cnt+=1

print(cnt)