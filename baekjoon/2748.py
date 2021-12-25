pibo=[0,1]
pibo+=[0]*90

for i in range(2,92):
    pibo[i]=pibo[i-1]+pibo[i-2]

n=int(input())

print(pibo[n])