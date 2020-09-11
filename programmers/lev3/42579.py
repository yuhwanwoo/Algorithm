# 베스트앨범
def solution(genres, plays):
    answer = []

    song=dict()
    hap=dict()

    for i in range(len(genres)):
        song[genres[i]]=song.get(genres[i],[])+[plays[i]]
    
    for i in song.keys():
        song[i].sort()
        hap[sum(song[i])]=i
    print(song) # {'classic': [150, 500, 800], 'pop': [600, 2500]}
    print(hap) # {1450: 'classic', 3100: 'pop'}
    lis=sorted(hap,reverse=True)
    print(lis) # [3100, 1450]

    for i in lis:
        if len(song[hap[i]])>1:
            for v in range(2):
                print(song[hap[i]][-1])
                top=song[hap[i]][-1]
                song[hap[i]]=song[hap[i]][:-1]
                for v in range(len(plays)):
                    if plays[v]==top and hap[i]==genres[v]:
                        answer.append(v)
                        plays[v]=0
                        break
        else:
            top=song[hap[i]][-1]
            for v in range(len(plays)):
                    if plays[v]==top and hap[i]==genres[v]:
                        answer.append(v)
    
    return answer

genres=["classic","classic","classic","classic","pop"]
plays=[500,150,800,800,2500]

solution(genres,plays)