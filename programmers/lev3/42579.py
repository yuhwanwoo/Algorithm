def solution(genres, plays):
    answer = []

    song=dict()

    for i in range(len(genres)):
        song[genres[i]]=song.get(genres[i],[])+[plays[i]]
    
    for i in song.keys():
        song[i].sort(reverse=True)
    print(song)
    


    return answer

genres=["classic","pop","classic","classic","pop"]
plays=[500,600,150,800,2500]

solution(genres,plays)