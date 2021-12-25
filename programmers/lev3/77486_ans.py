from collections import deque

def solution(enroll, referral, seller, amount):
    answer = []

    names = dict()
    money = dict()

    names["-"] = "root"
    money["-"] = 0

    size = len(enroll)

    for i in range(size):
        names[enroll[i]] = referral[i]
        money[enroll[i]] = 0

    for i in range(len(seller)):
        child = seller[i]
        parent = names[child]
        mon = amount[i] * 100
        money[child] += mon
        while True:
            commission = mon // 10
            money[child] -= commission
            money[parent] += commission
            child = parent
            parent = names[child]
            mon = commission
            if parent == 'root':
                break
    
    for person in enroll:
        answer.append(money[person])
    
    return answer

enroll = ["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]
referral = ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]
seller = ["young", "john", "tod", "emily", "mary"]
amount = [12, 4, 2, 5, 10]
solution(enroll, referral, seller, amount)