public class FordAlgorithm {

    public static void main(String[] args) {

        Graph graph;
        int result;

        //Problem 1
        graph = new Graph(8);

        graph.addEdge(1, 2, 32);
        graph.addEdge(1, 3, 95);
        graph.addEdge(1, 5, 20);
        graph.addEdge(1, 4, 75);
        graph.addEdge(2, 5, 23);
        graph.addEdge(2, 8, 16);
        graph.addEdge(3, 4, 18);
        graph.addEdge(3, 6, 6);
        graph.addEdge(4, 6, 9);
        graph.addEdge(4, 5, 24);
        graph.addEdge(5, 7, 20);
        graph.addEdge(5, 8, 94);
        graph.addEdge(6, 5, 11);
        graph.addEdge(6, 7, 7);
        graph.addEdge(7, 8, 81);

        result = graph.solve(1, 8);
        System.out.println(result);

        //Problem 2
        graph = new Graph(8);

        graph.addEdge(1, 2, 6);
        graph.addEdge(1, 3, 6);
        graph.addEdge(3, 2, 5);
        graph.addEdge(2, 5, 2);
        graph.addEdge(2, 4, 4);
        graph.addEdge(3, 5, 9);
        graph.addEdge(5, 4, 8);
        graph.addEdge(4, 7, 7);
        graph.addEdge(5, 7, 7);
        graph.addEdge(4, 6, 4);
        graph.addEdge(7, 6, 11);
        graph.addEdge(6, 8, 7);
        graph.addEdge(7, 8, 4);

        result = graph.solve(1, 8);
        System.out.println(result);
    }
}
