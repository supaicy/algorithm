package my.training.search;

import java.util.*;

public class BreadthFirstSearch {

    // 그래프를 인접 리스트로 표현
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    // 그래프에 간선 추가
    public void addEdge(int u, int v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    // BFS 탐색 메서드
    public void bfs(int start) {

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while(!queue.isEmpty()) { // 큐가 비어있지 않으면
            int node = queue.poll(); // 현재 노드를 큐에서 꺼냄
            System.out.println("Visited: " + node);

            for(int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if(!visited.contains(neighbor)) { // 인접 노드가 방문하지 않았다면
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.addEdge(0,1);
        bfs.addEdge(0,2);
        bfs.addEdge(1,3);
        bfs.addEdge(2,4);

        System.out.println("BFS 시작: ");
        bfs.bfs(0);
    }
}
