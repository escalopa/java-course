import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    // Array of lists of edges
    // Used to save graph edges and vertices
    private final List<Edge>[] adjacency_list;

    // A list containing  all the min_flows_values
    private final List<Integer> flows;

    // Destination point to which we want ot calculate the max_flow
    private int final_point;

    /**
     * Returns a new instance of this class
     * @param vertices number of vertices in the edge
     */
    public Graph(int vertices) {
        flows = new LinkedList<>();
        adjacency_list = new List[vertices + 1];

        //Initialize all list of the array(nodes)

        for (int i = 0; i < adjacency_list.length; i++) {
            adjacency_list[i] = new LinkedList<>();
        }

        // The line below is equivalent of the above loop (ONLY use 1 of them)
        // Arrays.stream(adjacency_list).forEach(list -> list = new LinkedList<>());


    }

    /**
     * @param start_point the point of which our algorithm will start from
     * @param final_point the point of which our algorithm will start from
     */
    public int solve(int start_point, int final_point) {

        this.final_point = final_point;

        // Prepare values for DFS call
        int min_flow = Integer.MAX_VALUE;
        List<Edge> path = new LinkedList<>();

        // Walk through all nodes of the graph util we reach the final_point.
        dfs(start_point, min_flow, path);

        // Sum all min_flows values to get max_min value from starting to end point.
        int sum = 0;
        for (Integer flow : flows) {
            sum += flow;
        }
        return sum;

        // The line below is equivalent to the loop above (ONLY use 1).
        // return flows.stream().mapToInt(Integer::intValue).sum();
    }

    private void dfs(int source, int min_flow, List<Edge> path) {

        // Check if path contains any zero flow value.
        if (contains_zero_flow(path)) return;

        /*
        * This is a DFS recursion call that aims to find the min flow
        * and recursively call the DFS function with the new min_value.
        *
        * We also add edges to the path to track our way to end point.
        * After the call ends we remove the edge since in the next loop
        * we will visit other edges.
        * */
        for (Edge edge : adjacency_list[source]) {
            path.add(edge);
            min_flow = min_flow_path(path);
            dfs(edge.destination, min_flow, path);
            path.remove(edge);
        }

        //Remove min_flow from visited edges
        if (source == final_point) {
            int finalMin_flow = min_flow;
            path.forEach(edge -> {
                edge.flow -= finalMin_flow;
            });

            //System.out.println(min_flow+" "+path);
            flows.add(min_flow);
        }
    }

    /**
     * Return the minimum value between all flows of all edges in the given path
     * @param path list of the edges that we have passed on our path to end_point
     */
    private int min_flow_path(List<Edge> path) {
        int min = Integer.MAX_VALUE;
        for (Edge edge : path) {
            min = Integer.min(min, edge.flow);
        }
        return min;
    }


    /**
     * Return weather the path taken contains any edges with zero flow value
     * @param path list of the edges that we have passed on our path to end_point
     */
    private boolean contains_zero_flow(List<Edge> path) {
        for (Edge edge : path)
            if (edge.flow <= 0) return true;

        return false;
    }


    // Function to print graph edges
    public void print_graph() {
        for (int i = 1; i < adjacency_list.length; i++) {
            for (Edge edge : adjacency_list[i]) {
                System.out.println(edge.toString());
            }
        }
    }

    // Add edge to the
    public void addEdge(int source, int destination, int flow) {

        // Create new instance of Edge with the given parameters
        Edge edge = new Edge(source, destination, flow);

        // Add the edge above to the list of edges of the source node
        adjacency_list[source].add(edge);
    }

    private static class Edge implements Comparable<Edge> {

        // Edge starts from this point
        int source;

        // Edge goes to this point
        int destination;

        // The weight or max_flow that can pass through this edge
        int flow;

        // Init edge class
        public Edge(int source, int destination, int flow) {
            this.source = source;
            this.destination = destination;
            this.flow = flow;
        }

        // Function that returns a string value representing this edge
        @Override
        public String toString() {
            return this.source + " -> " + this.destination + " = " + this.flow;
        }

        // Function used to compare 2 edges
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.flow, o.flow);
        }
    }
}
