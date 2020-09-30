def solution(skill, skill_trees):
    answer = 0
    if len(skill)>0:
        stand=[]
        for i in skill_trees:
            for j in i:
                if j in skill:
                    stand.append(j)
            jo=''.join(stand)
            if len(jo)==0:
                answer+=1
            if len(jo)>0:
                if (jo in skill) and (jo[0]==skill[0]):
                    answer+=1
            stand=[]
        
    return answer

skill="CBD"
skill_trees=["BACDE", "CBADF", "AECB", "BDA"]
solution(skill,skill_trees)