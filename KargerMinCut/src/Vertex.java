import java.util.ArrayList;

public class Vertex {
    int val;
    private ArrayList<Vertex> links;

    Vertex(int n) {
        val = n;
        links = new ArrayList<>();
    }

    //the size of a vertex is the number of its links, just like the amount of power that resides in a social animal;
    public int size() {
        return links.size();
    }

    public Vertex get(int index) {
        return links.get(index);
    }

    public Boolean contains(Vertex v) {
        return links.contains(v);
    }

    public void replaceLink(Vertex original, Vertex placement) {
        while (contains(original)) {
            links.set(links.indexOf(original), placement);
        }
        return;
    }

    public void link(Vertex v) {
        links.add(v);
        return;
    }

    public void unlink(Vertex v) {
        this.links.remove(v);
        v.links.remove(this);
        return;
    }

    public void remove(Vertex v) {
        links.remove(v);
        return;
    }

    public String toString() {
        return Integer.toString(val);
    }

    public void inherit(Vertex v) {
        this.links.addAll(v.links);
    }

}
