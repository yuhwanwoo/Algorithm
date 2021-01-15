def in_judge(word,ans):
    if word in ans:
        return False
    return True

def solution(n, words):
    answer = []
    ans=[words[0]]
    last_word=words[0][-1]
    words=words[1:]
    ans_index=0
    for i in range(len(words)):
        if last_word==words[i][-1]: 
            last_word=words[i][-1]
            if in_judge(words[i],ans):
                ans.append(words[i])
            else:
                ans_index=i+1
                break
        else:
            ans_index=i
            break
    if ans_index==0:
        answer=[0,0]
    else:
        print(ans_index)
        print(ans)
    
    return answer

n=3
words=["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]
solution(n,words)