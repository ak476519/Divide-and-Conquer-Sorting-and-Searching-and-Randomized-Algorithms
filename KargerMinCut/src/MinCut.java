import java.util.Random;

public class MinCut {
    public int kargerMinCut(Graph g, int seed) {
        Random rand = new Random(seed);
        while (g.size() > 2) {
            Vertex from = g.get(rand.nextInt(g.size()));
            Vertex to = from.get(rand.nextInt(from.size()));
            g.cut(from, to);
        }
        return g.numEdges();
    }
}
