# Python for ML

> 네이버 부스트코스 '머신러닝을 위한 파이썬' 강의 내용 정리

## Lecture OverView

- 순정 파이썬이 아니라 `ANACONDA`를 사용한다.
    - `ANACONDA`는 과학 계산용의 많은 모듈을 포함하고 있다.
    - `CONDA` : 파이썬 가상 환경 관리 패키지
    - `IDE` : 주피터
    - `Numpy`, `Pandas`, `Matplotlib` 패키지 사용

## 용어 개념 정리
- Machine Learning Process
    1. 기존 데이터를 머신 러닝 알고리즘을 사용해서 모델을 만든다.
    2. 새로운 데이터를 그 모델에 적용시켜 예측을한다.
    > 주로 하는 일은 알고리즘을 통한 모델 만들기가 된다.

- Machine Learning Key Concept
    1. model : 예측을 위한 수학 공식, 함수 1차 방정식, 확률 분포, condition rule
    2. Algorithms : 어떠한 문제를 풀기 위한 과정. Model을 생성하기 위한 (훈련) 과정

- 모델을 학습할 때 영향을 주는 요인
    - `y = ax + b`
        - 주어진 X 값 : 독립 변수
        - 주어진 Y 값 : 종속 변수
        - a, b : 알고리즘을 통해 최적값을 찾음
    - 특징 (feature)
        - [Boston House Price Dataset](http://www.dator.co.kr/ctg258/textyle/1721307)(대표적인 머신러닝 toy dataset) 에서는 13개의 x 변수, 1개의 y 변수를 갖는다. x 변수의 실제 데이터의 **특징**을 나타낸다.
        - 머신러닝에서 **데이터의 특징을 나타내는 변수**
        - feature, 독립변수, input 변수 등은 동일 의미로 사용
        - 일반적으로 Table 상에 Data를 표현할 때, Column을 의미
        - 하나의 **data instance (실제 데이터)**는 feature vector로 표현
        - 머신러닝의 거의 모든 알고리즘들은 통계학자들이 만들었다.
- 용어 정리
    - 전체 테이블 : **Data table**, sample
    - 컬럼 명 : **attribute**, field, **feature**, **column**
    - 한 행 : **instance**, **tuple**, **row**
    - 컬럼 : Feature vector
    - 셀 하나 : data (테이블 전체를 data 라고도 부르기도 한다)

## Pandas
- 엑셀처럼 데이터를 호출해서 핸들링하는 도구