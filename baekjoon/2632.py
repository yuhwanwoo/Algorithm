# 파이파이는 통과 파이썬은 시간초과
sell=int(input())

pizzaA=[]
pizzaB=[]

# a,b 피자
a,b=map(int,input().split())

for i in range(a):
    pizzaA.append(int(input()))

pizzaA+=pizzaA
for i in range(b):
    pizzaB.append(int(input()))
pizzaB+=pizzaB

subPizzaA=[]
subPizzaB=[]

n=1

answer=0


# while 2개는 코드 같으므로 모듈화 하자
while n<len(pizzaA)//2+1:
    for i in range(len(pizzaA)//2):
        subNum=0
        for j in range(n):
            subNum+=pizzaA[i+j]
        if subNum<sell:
            subPizzaA.append(subNum)
        if subNum==sell:
            answer+=1
        if n==len(pizzaA)//2:
            break
    n+=1

n=1

while n<len(pizzaB)//2+1:
    for i in range(len(pizzaB)//2):
        subNum=0
        for j in range(n):
            subNum+=pizzaB[i+j]
        if subNum<sell:
            subPizzaB.append(subNum)
        if subNum==sell:
            answer+=1
        if n==len(pizzaB)//2:
            break
    n+=1

subPizzaA.sort()
subPizzaB.sort(reverse=True)

i=0
j=0

while i<len(subPizzaA) and j<len(subPizzaB):
    pieceA = subPizzaA[i]
    pieceB = subPizzaB[j]
    if (pieceA+pieceB)==sell:
        cntA=0
        cntB=0
        while i<len(subPizzaA):
            if subPizzaA[i]==pieceA:
                cntA+=1
                i+=1
            else:
                break
        while j<len(subPizzaB):
            if subPizzaB[j]==pieceB:
                cntB+=1
                j+=1
            else:
                break
        answer+=(cntA*cntB)
    
    elif (pieceA+pieceB)<sell:
        i+=1
    elif (pieceA+pieceB)>sell:
        j+=1

print(answer)