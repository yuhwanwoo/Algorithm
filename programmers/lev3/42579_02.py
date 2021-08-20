def solution(genres, plays):
    answer = []

    genres_dict = dict()

    genres_sum = dict()

    for i in range(len(genres)):
        genres_dict[genres[i]] = genres_dict.get(genres[i], []) + [(plays[i], i)]
        genres_sum[genres[i]] = genres_sum.get(genres[i], 0) + plays[i]

    # print(genres_sum)
    genres_sum = sorted(genres_sum.items(), key = lambda x:x[1], reverse = True)
    # print(genres_sum)

    for key in genres_dict.keys():
        genres_dict[key].sort(key = lambda x:(-x[0], x[1]))
    
    for genre in genres_sum:
        if len(genres_dict[genre[0]]) > 1:
            for i in range(2):
                cnt, idx = genres_dict[genre[0]][i]
                answer.append(idx)
        else:
            cnt, idx = genres_dict[genre[0]][0]
            answer.append(idx)
    return answer








genres = ["classic", "aop", "classic", "classic", "aop"]
plays = [500, 600, 150, 800, 2500]

genres=["classic","classic","classic","classic","pop"]
plays=[500,150,800,800,2500]

genres = ["A", "A", "B", "A", "B", "B", "A", "A", "A", "A"]
plays = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
print(solution(genres, plays))