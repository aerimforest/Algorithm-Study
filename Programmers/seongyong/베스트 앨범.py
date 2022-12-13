def solution(genres, plays):

    import operator

    play_info = dict()
    album = list()

    for i in range(len(genres)):
        if genres[i] in play_info:
            play_info[genres[i]][0] += plays[i]
            play_info[genres[i]][1][i] = plays[i]
        else:
            play_info[genres[i]] = list()
            play_info[genres[i]].insert(0, plays[i])
            play_info[genres[i]].insert(1, {i: plays[i]})

    play_info = sorted(play_info.items(),
                       key=operator.itemgetter(1),
                       reverse=True)

    for genre_info in play_info:
        play_time = genre_info[1][1]
        play_time = sorted(play_time.items(),
                           key=operator.itemgetter(1),
                           reverse=True)

        album.append(play_time[0][0])
        if len(play_time) > 1:
            album.append(play_time[1][0])

    return album
