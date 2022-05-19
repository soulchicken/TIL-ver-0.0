def solution(phone_book):
    phone_book.sort()
    for i in range(len(phone_book)-1):
        a = len(phone_book[i+1])
        b = len(phone_book[i])
        if a > b and phone_book[i] == phone_book[i+1][:b]: return False
        elif a < b and phone_book[i][:a] == phone_book[i+1]: return False
            
    answer = True
    return answer
