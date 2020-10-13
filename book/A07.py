num=input()

front=list(map(int,num[:(len(num)//2)]))
back=list(map(int,num[(len(num)//2):]))

if sum(front)==sum(back):
    print("LUCKY")
else:
    print("READY")