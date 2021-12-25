n,m=map(int,input().split())

cnt=0

for i in range(n+1):
    for j in range(60):
        for k in range(60):
            time=""
            if i<10:
                time+="0"
            time+=str(i)
            if j<10:
                time+="0"
            time+=str(j)
            if k<10:
                time+="0"
            time+=str(k)

            if str(m) in time:
                cnt+=1

   
print(cnt)