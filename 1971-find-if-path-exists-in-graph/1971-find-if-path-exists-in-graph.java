class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if(source == destination) return true; 

       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
         
         for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();

        visited[source] = true;
        q.add(source);

         while (!q.isEmpty()) {
            int node = q.poll();
            
            if (node == destination)return true;
            for (int adjNode : adj.get(node)){

                if (!visited[adjNode]){
                    visited[adjNode] = true;
                    q.add(adjNode);
                }
            }
        }
        return false;
    }
}