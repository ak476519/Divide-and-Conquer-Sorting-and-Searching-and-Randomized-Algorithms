import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Graph {
    private HashMap<Integer, Vertex> vertices;

    Graph(File file) throws FileNotFoundException { 
        vertices = new HashMap<>();
        Scanner member = new Scanner(file);
        while(member.hasNextLine()) {
            Scanner link = new Scanner(member.nextLine());
            int val = link.nextInt();
            Vertex v;
            if (vertices.containsKey(val)) v = vertices.get(val);
            else {
                v = new Vertex(val);
                vertices.put(val, v);
            }
            while (link.hasNext()) {
                int next = link.nextInt();
                if (vertices.containsKey(next)) v.link(vertices.get(next));
                else {
                    Vertex n = new Vertex(next);
                    vertices.put(next, n);
                    v.link(n);
                }
            }
        }
    }

    public Vertex get(int val) {
        int n = val;
        for (int i : vertices.keySet()) {
            if (n == 0) return vertices.get(i);
            n--;
        }
        return null;
    }

    public int size() {
        return vertices.size();
    }

    public int numEdges() {
        int n = 0;
        for (Vertex v : vertices.values()) {
            n += v.size();
        }
        return n/2;
    }

    private void merge(Vertex from, Vertex to) {
        to.inherit(from); //have "to" inherit every link of "from";
        //rewrite the places of "from" by brute force;
        for (Vertex v : vertices.values()) {
            v.replaceLink(from, to);
        }
        //remove self loops;
        while (to.contains(to)) {
            to.remove(to);
        }
        //delete "from" as a vertex;
        vertices.remove(from.val);
        return;
    }

    public void cut(Vertex a, Vertex b) {
        a.unlink(b); //delete one of the edges that connects a and b;
        merge(b, a); //merge b into a;
        return;
    }
}
