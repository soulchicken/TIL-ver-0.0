def solution(p):
    if not p:
        return ""
    right = 0
    left = 0
    flag = True
    for i in range(len(p)):
        if p[i] == '(' : left += 1
        else : right += 1
        if right > left : flag = False
        if right == left : break
    u = p[:i+1]
    v = p[i+1:]
    if flag:
        return u + solution(v)
    else:
        u = u[1:-1]
        a = ""
        for i in u:
            if i == '(':
                a += ')'
            else:
                a += '('
        return "(" + solution(v) + ")" + a

print("(()())()",solution("(()())()"))
print("()",solution(")("))
print(	"()(())()",solution("()))((()"))
