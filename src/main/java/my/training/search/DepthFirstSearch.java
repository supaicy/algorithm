package my.training.search;

import java.util.*;

public class DepthFirstSearch {

    // 그래프를 인접 리스트로 표현
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    // 그래프에 간선 추가
    public void addEdge(int u, int v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // 무방향 그래프일 경우
    }

    // 깊이 우선 탐색(DFS) 메소드
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(start, visited);
    }

    // 재귀를 사용한 DFS 탐색
    private void dfsRecursive(int node, Set<Integer> visited) {
        // 현재 노드를 방문 처리
        visited.add(node);
        System.out.println("Visited: " + node);

        // 인접 노드들에 대해 재귀 호출
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) { // 인접 노드에 방문하지 않았다면
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 3);
        dfs.addEdge(2, 4);

        System.out.println("DFS 시작:");
        dfs.dfs(0);
    }
}