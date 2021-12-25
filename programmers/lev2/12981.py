import math

def solution(n, words):
    cnt=1
    dic=dict()
    dic[words[0]]=1

    for i in range(1,len(words)):
        cnt+=1
        if words[i-1][-1]!=words[i][0] or words[i] in dic.keys():
            answer=[]       
            if cnt%n==0:
                answer.append(n)
            else:
                answer.append(cnt%n) 
            answer.append(math.ceil(cnt/n))
            return answer
        dic[words[i]]=1
        

    return [0,0]

n=3
words=["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]

n=2
words=	["hello", "one", "even", "never", "now", "world", "draw"]
print(solution(n,words))