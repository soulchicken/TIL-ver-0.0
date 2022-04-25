def solution(answers):
    man1 = [1,2,3,4,5] * 2000
    man2 = [2,1,2,3,2,4,2,5] * 1250
    man3 = [3,3,1,1,2,2,4,4,5,5] * 1000
    score = [0,0,0]
    for i in range(len(answers)):
        if answers[i] == man1[i]: score[0] += 1
        if answers[i] == man2[i]: score[1] += 1
        if answers[i] == man3[i]: score[2] += 1
    answer = []
    x = max(score)
    for i in range(3):
        if score[i] == x:
            answer.append(i+1)
    return answer