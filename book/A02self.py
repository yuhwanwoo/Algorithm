n=str(input())


count=int(n[0])

for i in range(1,len(n)):
    if count*int(n[i])<count+int(n[i]):
        count+=int(n[i])
    else:
        count*=int(n[i])

print(count)
