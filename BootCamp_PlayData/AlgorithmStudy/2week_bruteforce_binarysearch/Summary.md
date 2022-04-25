# 2 week - Brute Force & Binary Search 완전탐색 & 이분탐색

## 0. 탐색
- 많은 데이터 속에서 원하는 데이터를 찾는 것으로   
  웹에서 특정 문자를 가진 웹 문서를 찾거나 신용카드나 버스카드 역시 검색 알고리즘을 사용한다.

### 0.1. 탐색의 종류
- 완전탐색
- 이분탐색
- 깊이우선탐색
- 너비우선탐색
- 문자열 탐색
- KMP
- BM

## 1. Brute Force 완전 탐색
- 컴퓨터의 빠른 계산 성능을 활용하여 가능한 모든 경우의 수를 탐색
- 효율성 관점에서는 최악의 방법
- 그렇지만 완전탐색으로는 풀리지 않는 문제는 없어짐

### 1.1. 구현 방법
- 1. 반복문 활용
- 2. 재귀함수

### 1.1.1. 반복문으로 구현
- 뒤집어진 트럼프카드(리스트) 중에서 8을 찾기
```py
def solution(trump):
    for i in range(len(trump)):
        if trump[i] == 8:
            return i
    return -1
print(solution([1,2,3,4,5,6,7,8,9,10]))
# 7 출력!
```

### 1.1.2. 재귀함수
```py
def solution(trump,loc):
    if len(trump) == loc:
        return -1
    if trump[loc] == 8:
        return loc
    return solution(trump, loc + 1)
print(solution([1,2,3,4,5,6,7,8,9,10],0))
```
<hr>

## 2. Binary Search 이분 탐색
- UPDOWN 게임을 한다고 했을 때 (1 ~ 1000 사이의 수 맞추기) 가장 먼저 물어보는 수는 500이 된다.
- 범위를 점차 조금씩 줄여가는 것.
- 이진검색이라고도 하고 오름차순으로 **정렬된 리스트**에서 특정 값의 위치를 찾는 알고리즘
- 중간의 값을 선택하여 찾고자 하는 값과 크고 작음을 비교하는 방법

### 2.1. 구현 방법
- 왼쪽 끝, 오른쪽 끝으로 left, right 값으로 지정하고, mid 값으로 (left + right)//2 로 한다.
- 뒤집어진 트럼프 카드가 오름차순으로 정리되있다고 할 때 8 찾기
```py
def solution(trump):
    left = 0
    right = len(trump) - 1
    while (left <= right):
        mid = (left + right) // 2
        if trump[mid] == 8:
            return mid
        elif trump[mid] < 8:
            left = mid + 1
        elif trump[mid] > 8:
            right = mid - 1
    return mid
print(solution([1,2,3,4,5,6,7,8,9,10]))
```