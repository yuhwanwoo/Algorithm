def solution(clothes):
    answer = 1
    having_cloth=dict()
    for cloth,loc in clothes:
        having_cloth[loc]=having_cloth.get(loc,[])+[cloth]
    for key in having_cloth.keys():
        answer*=(len(having_cloth[key])+1)
    answer-=1
    return answer

clothes=[["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]
solution(clothes)