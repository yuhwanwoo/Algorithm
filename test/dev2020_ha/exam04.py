def solution(votes, k):
    answer = ''

    car=dict()

    for i in votes:
        car[i]=car.get(i,0)+1

    key_list=car.keys()
    vote_list=[]
    for i in key_list:
        vote_list.append((-car[i],i))
    vote_list.sort()

    print(vote_list)
    cnt=0
    for i in range(k):
        cnt+=vote_list[i][0]

    fail=[]
    stand=0
    while cnt<stand:
        a,b=vote_list.pop()
        if stand+a>cnt:
            fail.append(b)
        stand+=a

    answer=fail[-1]
    return answer

votes=["AVANT","PRIDO", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "AVANT", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "SOULFUL", "AVANT", "SANTA"]
k=2
# votes=["AAD", "AAA", "AAC", "AAB"]
# k=4
solution(votes,k)