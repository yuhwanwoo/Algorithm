a=int(input())
count=0

list=[500,100,50,10]

for i in list:
    count+=a//i
    a=a%i

print(count)



# 내풀이
#a=int(input())
#b=int(a/500)
#print(b)
#c=int(a%500/100)
#d=int(a%500%100/50)
#e=int(a%500%100%50/10)

#print(b+c+d+e)