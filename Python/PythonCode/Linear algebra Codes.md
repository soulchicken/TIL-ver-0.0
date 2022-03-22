# Linear Algebra Codes
- 파이썬으로 벡터, 행렬 구현
- 넘파이가 사실 제일 편함

## Vector
- 벡터는 파이썬으로 다양하게 표현할 수 있다
- 최선의 방법은 없지만 리스트가 편하기도 함
```py
vector_a = [1, 2, 3] # 리스트
vector_b = (4, 5, 6) # 튜플
vector_c = {'x' : 7, 'y' : 8, 'z' : 9} # 딕셔너리
```

### Vector 덧셈 계산
```py
u = [2, 2]
v = [2, 3]
z = [3, 5]
# result = u + v + z
result = []

# 일반적인 방법
for i in range(len(u)):
    result.append(u[i] + v[i] + z[i])
print(result)
>>> [7, 10] 출력!

# zip 사용
result = [sum(t) for t in zip(u,v,z)]
print(result)
>>> [7, 10] 출력!
```

### Vector Scalar 곱
```py
u = [1, 2, 3]
v = [4, 5, 6]
alpha = 2

# result = 2(u + v)

result = [alpha * sum(t) for t in zip(u,v)]
print(result)
>>> [10, 14, 18] 출력
```

## Matrix
- Vector처럼 여러 방법이 존재함 (튜플, 리스트, 딕셔너리)

### Matrix 덧셈
```py
# C = A + B
matrix_a = [[3, 6], [4, 5]]
matrix_b = [[5, 8], [6, 7]]

result = [[sum(row) for row in zip(*t)] for t in zip(matrix_a, matrix_b)]
print(result)
>>> [[8, 14], [10, 12]] 출력!
```
### Matrix Scalar 곱
```py
matrix_a = [[3, 6], [4, 5]]
alpha = 4
result = [[alpha * element for element in t] for t in matrix_a]
print(result)
>>> [[12, 24], [16, 20]]
```

### Matrix Transpose
```py
matrix_a = [[1, 2, 3], [4, 5, 6]]
result = [[element for element in t] for t in zip(*matrix_a)]
>>> [[1, 4], [2, 5], [3, 6]]
```

### Matrix 곱셈
```py
matrix_a = [[1, 1, 2], [2, 1, 1]]
matrix_b = [[1, 1], [2, 1], [1, 3]]
result = [[sum(a * b for a,b in zip(row_a, col_b)) for col_b in zip(*matrix_b)] for row_a in matrix_a]

print(result)
>>> [[5, 8], [5, 6]] 출력!
```