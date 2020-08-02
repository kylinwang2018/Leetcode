import java.util.ArrayList;
import java.util.List;

/*
There are n servers numbered from 0 to n-1 connected by undirected 
    server-to-server connections forming a network where connections[i] = [a, b] 
    represents a connection between servers a and b. Any server can reach any 
    other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server
    unable to reach some other server.

Return all critical connections in the network in any order.

Example 1:
Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.

Constraints:

1 <= n <= 10^5
n-1 <= connections.length <= 10^5
connections[i][0] != connections[i][1]
There are no repeated connections.
*/

public class Q1192 {

}

class Solution1192 {
    private List<Integer>[] adj;
    private boolean[] visited;
    private int[] discovery;
    private int[] low;
    private int discTime = 0;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) 
    {
        List<List<Integer>> bridges = new ArrayList<List<Integer>>();
        if(connections == null || connections.size() == 0 || n <= 1) return bridges;
        
        adj = new List[n];
        visited = new boolean[n];
        discovery = new int[n];
        low = new int[n];
        
        for (int v=0; v < n; v++)
        {
            adj[v] = new ArrayList<>();
        }
        
        // flush out adjacency list
        for (List<Integer> connection : connections)
        {
            int v = connection.get(0);
            int w = connection.get(1);
            adj[v].add(w);
            adj[w].add(v);
        }
        
        // Now call DFS from each unvisited vertex
        // So that this finds bridges in even disconnected graph
        for (int v=0; v < n; v++)
        {
            if(!visited[v])
            {
                // v is root; its parent is not defined (so -1)
                dfs(bridges, v, -1);
            }
        }
        
        return bridges;

    }
    
    private void dfs(List<List<Integer>> bridges, int current, int parent)
    {
        visited[current] = true;
        discTime++;
        discovery[current] = discTime;
        low[current] = discTime;
        
        for (int w : adj[current])
        {
            // Case 1: w is parent of current
            if(w == parent) continue;
            
            // Case 2: w is already visisted (so, w can be either ancestor or descendent of current)
            if(visited[w])
            {
                // update low of current
                low[current] = Math.min(low[current], discovery[w]);
            }
            else // Case 3: Do dfs with w as current and current as parent
            {
                dfs(bridges, w, current);
                
                // Once you are back from the dfs call of your child, you need to check if
                // connection (current - w) is a bridge or not in "this dfs"
                if (low[w] > discovery[current])
                {
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(current);
                    bridge.add(w);
                    bridges.add(bridge);
                }
                
                // Now, update low value of current based on its child from which it just returned
                low[current] = Math.min(low[current], low[w]);
            }
        }
    }
}