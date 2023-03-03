import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B11085_군사이동 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    
    static void input() {
    	p = scan.nextInt();
    	w = scan.nextInt();
    	
    	parent = new int[p];
    	rank = new int[p];
    	for (int i = 0; i < p; i++) {
    		parent[i] = i;
    	}
    	
    	c = scan.nextInt();
    	v = scan.nextInt();
    	
    	for (int i = 0; i < w; i++) {
    		int u = scan.nextInt();
    		int v = scan.nextInt();
    		int cost = scan.nextInt();
    		pq.add(new Edge(u, v, cost));
    	}
    }
    
    static int p, w, c, v;
    static int[] parent, rank;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    
    static void union(int u, int v) {
    	u = find(u);
    	v = find(v);
    	
    	if (u != v) {
    		if (rank[u] < rank[v]) {
    			parent[u] = v;
    		} else {
    			parent[v] = u;
    			if (rank[u] == rank[v]) {
    				rank[u]++;
    			}
    		}
    	}
    }
    
    static int find(int x) {
    	if (x == parent[x]) return x;
    	
    	return parent[x] = find(parent[x]);
    }
    
    static void pro() {
    	int ret = 0;
    	while (!pq.isEmpty()) {
    		Edge edge = pq.poll();
    		union(edge.u, edge.v);
    		if (find(c) == find(v)) {
    			ret = edge.cost;
    			break;
    		}
    	}
    	System.out.println(ret);
    }
    
    public static void main(String[] args) {
    	input();
    	
    	pro();
    	    	
    }
    
    static class Edge implements Comparable<Edge> {
    	int u, v, cost;

    	public Edge (int u, int v, int cost) {
    		this.u = u;
    		this.v = v;
    		this.cost = cost;
    	}
    	
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return o.cost - cost;
		}
    }
   
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}