import java.util.*;

public class ProblemOne {


	public static void shortestPath(Graph graph, int source, HashMap<String,Integer> nodes, HashMap<Integer,String> meadows)
	{	
		int N = nodes.size();
		PriorityQueue<Node> minHeap = new PriorityQueue<>((lhs, rhs) -> lhs.weight - rhs.weight);
		minHeap.add(new Node(source, 0));

		List<Integer> dist = new ArrayList<>(Collections.nCopies(N, Integer.MAX_VALUE));

		dist.set(source, 0);

		boolean[] done = new boolean[N];
		done[source] = true;

		

		while (!minHeap.isEmpty())
		{
			Node node = minHeap.poll();

			int u = node.vertex;

			for (Edge edge: graph.adjList.get(u))
			{
				int v = nodes.get(edge.dest);
				int weight = edge.weight;

				if (!done[v] && (dist.get(u) + weight) < dist.get(v))
				{
					dist.set(v, dist.get(u) + weight);
					minHeap.add(new Node(v, dist.get(v)));
				}
			}

			done[u] = true;
		}
		HashMap<String, Integer> finalVertex = new HashMap<String, Integer>();
		String vertex ="";
		int weight =1000;
		for (int i = 0; i < N; i++)
		{  
			if(weight>=dist.get(i) && meadows.containsKey(i)) {
				
				if(weight==dist.get(i)) {
					finalVertex.put(vertex, weight);
					finalVertex.put(meadows.get(i), dist.get(i));					
					vertex = meadows.get(i);
					weight = dist.get(i);
				}else {
					finalVertex.clear();
					vertex = meadows.get(i);
					weight = dist.get(i);
				}
			}
			
		}
		
		if(finalVertex.size()>0) {
			Iterator it = finalVertex.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() +" "+ pair.getValue());
		    }
		}else {
			System.out.print(vertex +" "+ weight);
		}
	}

	public static void main(String[] args)
	{
		
		Scanner myInput = new Scanner(System.in);
		int p  = myInput.nextInt();
		List<Edge> edges = new ArrayList<Edge>();
		ArrayList pathArray = new ArrayList<String>();
		HashMap<String,Integer> nodes = new HashMap<String,Integer>();
		HashMap<Integer,String> meadows = new HashMap<Integer,String>();
		
		for(int i=0; i <=p;i++) {
			String path = myInput.nextLine();
			if(i!=0) {
				pathArray.add(path);	
			}
		}
		
		Iterator<String> iter = pathArray.iterator(); 
	
	    while (iter.hasNext()) { 
	    	String path =iter.next();
	    	String[] splitedPath = path.split(" ");
			String src = splitedPath[0];
			String dest = splitedPath[1];
			int wit = Integer.parseInt(splitedPath[2]);
			edges.add(new Edge(dest,src, wit));
			if(!nodes.containsKey(src)) {
				nodes.put(src,nodes.size());
				if(src.charAt(0)>='A' && src.charAt(0)<='Z')
				{meadows.put(nodes.size()-1, src);}
			}
			if(!nodes.containsKey(dest)) {
				nodes.put(dest,nodes.size());
				if(dest.charAt(0)>='A' && dest.charAt(0)<='Z')
				{meadows.put(nodes.size()-1, dest);}
			}
	    } 

		Graph graph = new Graph(edges, nodes.size(),nodes);

		shortestPath(graph, nodes.get("z"), nodes,meadows);
	}
}

//Data structure for edges
class Edge
{
	String source, dest; 
	int weight;

	public Edge(String source, String dest, int weight) {
		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}
};

//data structure for nodes
class Node {
	int vertex, weight;

	public Node(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
};

//class to represent a graph object
class Graph
{
	// A List of Lists to represent an adjacency list
	List<List<Edge>> adjList = null;

	// Constructor
	Graph(List<Edge> edges, int N, HashMap<String,Integer> nodes)
	{
		adjList = new ArrayList<>(N);

		for (int i = 0; i < N; i++) {
			adjList.add(i, new ArrayList<>());
		}

		// add edges to the undirected graph
		for (Edge edge: edges) {
			adjList.get(nodes.get(edge.source)).add(edge);
		}
	}
}
