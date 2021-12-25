input_data=list(map(str,input()))
answer=[]
cnt=0
for i in input_data:
    if i.isalpha():
        answer.append(i)
    else:
        cnt+=int(i)

answer.sort()

if cnt!=0:
    answer.append(str(cnt))

print(''.join(answer))

