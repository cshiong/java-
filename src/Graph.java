import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;



public class Graph {
	
	public static List<Vertex> vertice = new ArrayList<Vertex>(6);
	public static List<Edge> edges = new ArrayList<Edge>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph g= new Graph();
		
		for(int i=0; i<7; i++){
			Vertex v = g.new Vertex(i);
			vertice.add(v);
		}
		
		edges.add(g.new Edge(vertice.get(0),vertice.get(1),2));
		edges.add(g.new Edge(vertice.get(0),vertice.get(3),7));
		edges.add(g.new Edge(vertice.get(0),vertice.get(4),6));
		edges.add(g.new Edge(vertice.get(0),vertice.get(2),3));
		edges.add(g.new Edge(vertice.get(1),vertice.get(2),1));
		edges.add(g.new Edge(vertice.get(3),vertice.get(2),4));
		edges.add(g.new Edge(vertice.get(1),vertice.get(6),3));
		edges.add(g.new Edge(vertice.get(5),vertice.get(6),6));
		edges.add(g.new Edge(vertice.get(5),vertice.get(4),8));
		edges.add(g.new Edge(vertice.get(4),vertice.get(3),5));
		
		
		/*
		Random r= new Random();
		for(int i= 0; i<15;i++){
			int j= r.nextInt(6);
			int d= r.nextInt(14);
			int k=d-j;
			if(k<0 ||k>6)
				k=0;
			Edge e=g.new Edge(vertice.get(k),vertice.get(j),d);
			edges.add(e);
		}*/
		for(Vertex v: vertice){
			System.out.print("Vertex: " + v.id + " neighbores: ");
			int i=0;
			for (Edge e: edges){
				if(e.A.id==v.id){
					v.add(e.B);
					System.out.print(" " + v.adjacents.get(i++).id);
				}
				else if(e.B.id==v.id){
					v.add(e.A);	
					System.out.print(" " + v.adjacents.get(i++).id);
				}
				
			}
			System.out.println();
		}
		
	for(Edge e: edges){
		System.out.println("Vertex: " + e.A.id + " to Vertex: " + e.B.id  + " Distance: " + e.distance);

	}
    HashMap<Vertex,Path> shortPath = new HashMap<Vertex,Path>();
    List<Vertex> visited = new ArrayList<Vertex>();
    List<Vertex> queue= new LinkedList<Vertex>();
    Vertex v=vertice.get(0);
    for(Vertex childV: v.adjacents){
		//get the direct distance to this vertex from src
			
		queue.add(childV);
		int d_distance= getDistance(v,childV);
		Path path = new Graph.Path(childV, d_distance);
		shortPath.put(childV,path);
    }
    visited.add(v);
    findShortestPaths(shortPath,visited,queue);
    
    for(Entry<Vertex,Path> E: shortPath.entrySet( )){
    	System.out.println("Vertex 0: to Vertex: "+E.getKey().id + " Shortest path distanche: " + E.getValue().distance);
    	System.out.print(" Path: ");
    	for(Vertex v2: E.getValue().path){
    		System.out.print("->" + v2.id);
    	}
    	System.out.println();
    }
	
	}
	
	public static int getDistance(Vertex a, Vertex b){
		if(edges==null || edges.size()==0)
				return Integer.MAX_VALUE;
		for(Edge e: edges){
			if((e.A.id==a.id && e.B.id==b.id )||(e.B.id==a.id&&e.A.id==b.id)) 
				return e.distance;
		}
		return Integer.MAX_VALUE;
	}
	
	public class Vertex{
		public int id;
		public List<Vertex> adjacents;
		
		public Vertex(int id){
			this.id= id;
		}
		
		public void add(Vertex v){
			if(adjacents ==null)
				adjacents = new ArrayList<Vertex>();
			adjacents.add(v);
		}		
	}
  
	public class Edge{
		public Vertex A;
		public Vertex B;
		public int distance;
		
		public Edge(Vertex a, Vertex b, int d){
			this.A=a;
			this.B=b;
			this.distance=d;
		}
	}
	
	public static class Path{
		public List<Vertex> path;
		public int distance;	
		
		public Path(Vertex v, int d){
			if( path ==null)
				path = new ArrayList<Vertex>();
			
			path.add(v);
			distance=d;
		}
		public Path(Path p,Vertex v,int d){
			path = new ArrayList<Vertex>();
			for(Vertex v1: p.path)
				path.add(v1);
			path.add(v);
			distance = p.distance + d;
			
		}
	}
	
	/*
	 * Dijksha shortest path to all the vertices 
	 */
	public static void findShortestPaths(HashMap<Vertex,Path> allPath,
			List<Vertex> visited,  List<Vertex> queue){
		if(queue.size()==0)
			return;
		Vertex v=queue.remove(0);
		if(visited.contains(v))
			return;
		Path p=allPath.get(v); //get the path to this start vertex;
		
		int shortestD2V=0;
		if(p!=null)
			shortestD2V=p.distance;
		for(Vertex childV: v.adjacents){
			//get the direct distance to this vertex from src.
			if(visited.contains(childV))
				continue;
				
			queue.add(childV);
			int d_distance= getDistance(v,childV);//get distance between this start to this child
			
			//find the shortest path from the original to this childV;
			Path s_path = allPath.get(childV);
				
			if(s_path ==null || s_path.distance > (d_distance+shortestD2V)){
				Path path = new Graph.Path(allPath.get(v), childV, d_distance);	
				allPath.put(childV, path);							
			}
		}
		//finish handler this vertex;
		visited.add(v);
		findShortestPaths(allPath,visited,queue);
	}
}
