b=input()
n=int(b,16)
for i in range(1,16):
    print("%s*%X=%X"%(b,i,n*i))