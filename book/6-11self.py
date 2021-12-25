n=int(input())

array=[]
for i in range(n):
    stu=input()
    m,n=stu.split()
    array.append((m,int(n)))

def setting(data):
    return data[1]

array=sorted(array,key=setting)

for i in array:
    print(i[0],end=' ')