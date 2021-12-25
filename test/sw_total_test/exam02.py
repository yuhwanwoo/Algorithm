def lastLetters(word):
    answer=""
    word=word[len(word)-2:]
    for i in word:
        answer=i+" "+answer
    
    return answer
word="bat"
word="APPLE"
lastLetters(word)