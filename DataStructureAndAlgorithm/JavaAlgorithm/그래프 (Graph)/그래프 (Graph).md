# 그래프 (Graph)
- 정점(Vertex) 또는 노드(Node)와 간선(Edge)로 표현하기 위해 사용

## 용어 정리
- **노드 (Node)** : 위치. 정점(Vertex)라고도 한다
- **간선 (Edge)** : 위치간 관계를 표시. 노드를 연결한 선. (link, branch 라고도 한다)
- **인접 정점 (Adjacent Vertex)** : 간선으로 직접 연결된 정점(노드)
- 정점의 차수 (Degree) : 무방향 그래프에서 하나의 정점에 인접한 정점의 수
- 진입 차수 (In-Degree) : 방향 그래프에서 외부에서 오는 간선의 수
- 진출 차수 (Out-Degree) : 방향 그래프에서 외부로 향하는 간선의 수
- 경로 길이 (Path-Length) : 경로를구성하기 위해 사용된 간선의 수
- 단순 경로 (Simple Path) : 처음 정점과 끝 정점을 제외하고 중복된 정점이 없는 경로
- 사이클 (Cycle) : 단순 경로의 시작 정점과 종료 정점이 동일한 경우

## 그래프 종류
- ### 무방향 그래프 (Undirected Graph)
  - 방향이 없는 그래프
  - 간선을 통해, 노드는 양뱡향으로 갈 수 있음
- ### 방향 그래프 (Directed Graph)
  - 간선에 방향이 있는 그래프
- ### 가중치 그래프 (Weighted Graph) 또는 네트워크 (Network)
  - 간선에 비용 또는 가중치가 할당된 그래프
- ### 연결 그래프 (Connected Graph) 와 비연결 그래프 (Disconnected Graph)
  - 연결 그래프 : 무방향 그래프에 있는 모든 노드에 대해 항상 경로가 존재하는 경우
  - 비연결 그래프 : 무방향 그래프에서 특정 노드에 대해 경로가 존재하지 않는 경우
- ### 사이클 (Cycle) 과 비순환 그래프 (Acyclic Graph)
  - 사이클 : 단순 경로의 시작 노드와 종료 노드가 동일한 경우
  - 비순환 그래프 : 사이클이 없는 그래프
- ### 완전 그래프 (Complete Graph)
  - 그래프의 모든 노드가 서로 연결되어 있는 그래프

## BFS와 DFS
- 대표적인 그래프 탐색 알고리즘
  - 너비 우선 탐색 (Breadth First Search) : 정점들과 같은 레벨에 있는 노드들 (형제 노드들)을 먼저 탐색하는 방식
  - 깊이 우선 탐색 (Depth First Search) : 정점의 자식들을 먼저 탐색하는 방식

## JAVA에서 사용 방법
- Java Collection Framework 에서 제공하는 Hashmap과 ArrayList를 활용해서 그래프를 표현
- key 값을 노드. value를 ArrayList로 사용