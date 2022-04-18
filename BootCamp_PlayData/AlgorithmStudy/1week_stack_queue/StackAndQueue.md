# 1 Week - Stack & Queue
- [내용 정리](./Summary.md)
- 문제풀이
    - [주식 가격](https://programmers.co.kr/learn/courses/30/lessons/42584)
        - [문제 접근](#1-주식-가격)
        - [소스 코드 전체 링크](./%EC%A3%BC%EC%8B%9D%EA%B0%80%EA%B2%A9.py)
    - [기능 개발](https://programmers.co.kr/learn/courses/30/lessons/42586)
        - [문제 접근](#2-기능-개발)
        - [소스 코드 전체 링크](%EA%B8%B0%EB%8A%A5%EA%B0%9C%EB%B0%9C.py)
    - [다리를 지나는 트럭](https://programmers.co.kr/learn/courses/30/lessons/42583)
        - [문제 접근](#3-다리를-지나는-트럭)
        - [소스 코드 전체 링크](%EB%8B%A4%EB%A6%AC%EB%A5%BC%20%EC%A7%80%EB%82%98%EB%8A%94%20%ED%8A%B8%EB%9F%AD.py)

## 문제 접근
### 1. 주식 가격
- 1. 2중 for문으로 전체 조회를 한다.
    - 바깥 for문에서는 `prices`의 각각 인덱스 i를 가져온다.
    - 안쪽 for문에서는 바깥 인덱스 i보다 큰 j부터 가져온다.
    - `prices[i] > prices[j]`이면 안쪽 for문을 break
    - 안쪽 for문이 끝나면 answer에 count append
- 2. answer에 각각 하나씩 append 한다.
- 3. 스택, 큐 문제인지 모르겠다.

### 2. 기능 개발
- 1. `import deque` 덱을 큐로 활용
- 2. for문으로 각 기능마다 며칠이 걸리는지 계산
    - (100 - 작업진도) / 작업 속도
    - 올림값을 만들기 위해서 `math`의 `ceil` 사용
    - queue에 추가
    <br><br>
    ```py
    for i in range(len(progresses)):
        queue.append( ceil ((100 - progresses[i]) / speeds[i]) )
    ```
- 3. queue에서 하나를 get해서 그 수를 n으로 초기화. 숫자의 갯수 `count = 1`
    - n보다 작은 숫자들을 전부 제거하고 그 수만큼 `count += 1`
    - 제거가 끝나면 answer에 count값 append
    <br><br>
    ```py
    while queue:
        n = queue.popleft()
        count = 1
        while queue and queue[0] <= n:
            count += 1
            queue.popleft()
        answer.append(count)
    ```
### 3. 다리를 지나는 트럭
- 1. `import deque` 덱을 큐로 활용 `bridge` 를 큐(덱)로 사용
    - 최초에는 모든 요소의 값이 0인 브릿지( `weight_in_bridge = 0` )를 만든다.
    - 브릿지에는 아무것도 없어서 무게가 0이다.
    - 1 타임도 안지났기 때문에 `count` 값도 0이다.
    ```py
    from collections import deque
    bridge = deque([0]*bridge_length)
    weight_in_bridge = 0
    ```
- 2. `bridge`에서 하나씩 내린다.
    - `truck_weights`를 하나씩 브릿지에서 얹는다.
    - 만약 얹기엔 이미 브릿지의 하중이 크다면 0을 얹는다.
- 3. 모든 트럭을 브릿지에 얹었다면 반복문 종료
- 4. `브릿지의 길이 + 지금까지의 count` 값을 return