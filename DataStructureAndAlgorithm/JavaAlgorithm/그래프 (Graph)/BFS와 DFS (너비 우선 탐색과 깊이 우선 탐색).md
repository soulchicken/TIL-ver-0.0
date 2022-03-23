# 1. 너비 우선 탐색 (BFS, Breadth-First Search)
- 너비 우선 탐색 (Breadth First Search) : 정점들과 같은 레벨에 있는 노드들 (형제 노드들)을 먼저 탐색하는 방식

## 구현 방법
- 큐 (Queue)를 사용한다
  - needVisit, visited 큐를 각각 생성

## 시간 복잡도 (일반적인 경우)
- 노드 수 : V
- 간선 수 : E
- 시간 복잡도 : O(V+E)
  - while문에서  needVisit이 V + E 번 발생

# 2. 깊이 우선 탐색 (DFS, Depth-First Search)
- 깊이 우선 탐색 (Depth First Search) : 정점의 자식들을 먼저 탐색하는 방식

## 구현 방법
- 스택 (Stack) 과 큐 (Queue)를 사용한다
  - needVisit 스택과 visited 큐를 각각 생성

## 시간 복잡도 (일반적인 경우)
- 노드 수 : V
- 간선 수 : E
- 시간 복잡도 : O(V+E)
  - while문에서  needVisit이 V + E 번 발생