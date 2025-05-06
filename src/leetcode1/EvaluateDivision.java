package leetcode1;

import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Step 1: Build the graph as an adjacency list
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(A, new HashMap<>());
            graph.putIfAbsent(B, new HashMap<>());
            graph.get(A).put(B, value);
            graph.get(B).put(A, 1.0 / value);
        }

        // Step 2: Process each query using BFS
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String C = queries.get(i).get(0);
            String D = queries.get(i).get(1);
            result[i] = bfs(graph, C, D);
        }

        return result;
    }

    // BFS function to find the path between start and end
    private double bfs(Map<String, Map<String, Double>> graph, String start, String end) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return -1.0;
        }
        if (start.equals(end)) {
            return 1.0;
        }

        Queue<Pair> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Pair(start, 1.0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String node = current.variable;
            double value = current.value;

            if (node.equals(end)) {
                return value;
            }

            visited.add(node);

            for (Map.Entry<String, Double> neighbor : graph.get(node).entrySet()) {
                if (!visited.contains(neighbor.getKey())) {
                    queue.offer(new Pair(neighbor.getKey(), value * neighbor.getValue()));
                }
            }
        }

        return -1.0; // No valid path found
    }

    // Helper class to store variable and computed value
    static class Pair {
        String variable;
        double value;

        Pair(String variable, double value) {
            this.variable = variable;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        EvaluateDivision solver = new EvaluateDivision();
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );

        System.out.println(Arrays.toString(solver.calcEquation(equations, values, queries)));
    }
}

